package com.boa.common.util.pagination;


import com.boa.common.util.ReflectUtils;
import com.boa.common.util.dialect.Dialect;
import com.boa.common.util.dialect.MysqlDialect;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.springframework.jdbc.support.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


/**
 * 分页拦截器
 * 需要在mybatis.xml的配置中申明
 * <pre>
 *   </configuration>
 *             <settings>
 *                <setting name="mapUnderscoreToCamelCase" value="true"/>
 *                <setting name="callSettersOnNulls" value="true"/>
 *                <!-- 全局映射器启用缓存 -->
 *                <setting name="cacheEnabled" value="false"/>
 *                <!-- 查询时，关闭关联对象即时加载以提高性能 -->
 *                <setting name="lazyLoadingEnabled" value="true"/>
 *                <!-- 设置关联对象加载的形态，此处为按需加载字段(加载字段由SQL指 定)，不会加载关联表的所有字段，以提高性能 -->
 *                <setting name="aggressiveLazyLoading" value="false"/>
 *                <!-- 对于未知的SQL查询，允许返回不同的结果集以达到通用的效果 -->
 *                <setting name="multipleResultSetsEnabled" value="true"/>
 *                <!-- 允许使用列标签代替列名 -->
 *                <setting name="useColumnLabel" value="true"/>
 *                <!-- 允许使用自定义的主键值(比如由程序生成的UUID 32位编码作为键值)，数据表的PK生成策略将被覆盖 -->
 *                <setting name="useGeneratedKeys" value="true"/>
 *                <!-- 给予被嵌套的resultMap以字段-属性的映射支持 -->
 *                <setting name="autoMappingBehavior" value="FULL"/>
 *                <!-- 对于批量更新操作缓存SQL以提高性能 -->
 *                <setting name="defaultExecutorType" value="SIMPLE"/>
 *                <!-- 数据库超过25000秒仍未响应则超时 -->
 *                <setting name="defaultStatementTimeout" value="25000"/>
 *                <!--打印sql-->
 *                <setting name="logImpl" value="STDOUT_LOGGING"/>
 *          </settings>
 *          <!--------------------------------------------------------------------->
 *          <!-- 全局别名设置，在映射文件中只需写别名，而不必写出整个类路径 -->
 *          <typeAliases>
 *          <!-- 别名声明写这里 -->
 *          </typeAliases>
 *         <!--------------------------------------------------------------------->
 *         <plugins>
 *             <!-- 插件, 拦截器-->
 *             <plugin interceptor="com.boa.stu.test.util.pagination.PagePlugin">
 *             <property name="dialectClass" value="com.boa.stu.test.util.dialect.MysqlDialect"/>
 *             </plugin>
 *             <plugin interceptor="com.boa.stu.test.util.extend.EntityListenerPlugin"/>
 *         </plugins>
 *   </configuration>
 * </pre>
 */
@Intercepts({
        @Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class, Integer.class})
//        , @Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class})
        , @Signature(method = "query", type = Executor.class, args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
        , @Signature(method = "query", type = Executor.class, args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})
})
public class PagePlugin implements Interceptor {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(PagePlugin.class);
    //数据方言类
    private String dialectClass = MysqlDialect.class.getName();
    //默认数据方言
    private Dialect dialect = new MysqlDialect();

    /**
     * 拦截后要执行的方法
     */
    public Object intercept(Invocation invocation) throws Throwable {

        Object target = invocation.getTarget();
        if (target instanceof RoutingStatementHandler) { //设置分页属性,更改查询结果为分页结果

            RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
            ParameterHandler parameterHandler = handler.getParameterHandler();
            Page page = ReflectUtils.findMemberByType(parameterHandler.getParameterObject(), Page.class);
            if (null != page) {

                Connection connection = (Connection) invocation.getArgs()[0];
                BoundSql boundSql = handler.getBoundSql();
                Long totalSize = count(connection, boundSql.getSql(), parameterHandler);
                page.setTotalSize(totalSize);
                String pageSql = dialect.pageSql(boundSql.getSql(), page);
                ReflectUtils.setFieldValue(boundSql, "sql", pageSql);
            }
            return invocation.proceed();

        } else if (target instanceof Executor) { //执行分页查询,并设置分页数据

            Object result = invocation.proceed();
            for (Object object : invocation.getArgs()) {

                Page page = ReflectUtils.findMemberByType(object, Page.class);
                if (null != page) {
                    page.setData((java.util.List) result);
                    return result;
                }
            }
        }
        return invocation.proceed();
    }


    /**
     * 拦截器对应的封装原始对象的方法
     */
    public Object plugin(Object target) {
        if (target instanceof RoutingStatementHandler || target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {
    }

    public Dialect getDialect() {
        return dialect;
    }

    public void setDialect(Dialect dialect) {
        this.dialect = dialect;
    }

    public String getDialectClass() {
        return dialectClass;
    }

    public void setDialectClass(String dialectClass) {
        this.dialectClass = dialectClass;
        try {
            if (null != dialectClass) {
                Class cls = Class.forName(dialectClass);
                if (cls.isAssignableFrom(Dialect.class)) {
                    setDialect((Dialect) cls.newInstance());
                } else {
                    logger.warn("参数 {} 不是 {} 的子类,使用默认 mysql 方言", dialectClass, Dialect.class);
                }
            }
        } catch (Exception e) {
            logger.error(" 方言注入错误! {} ", e.getMessage());
        }
    }

    /**
     * 执行 count 操作
     *
     * @param connection       数据库连接
     * @param sql              sql
     * @param parameterHandler 参数设置处理器
     * @return
     */
    private Long count(Connection connection, String sql, ParameterHandler parameterHandler) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(countSql(sql));
            parameterHandler.setParameters(preparedStatement);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return (Long) JdbcUtils.getResultSetValue(resultSet, 1, Long.class);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(preparedStatement);
        }
        return 0l;
    }

    /**
     * 生成 COUNT 语句
     *
     * @param sql 生成前SQL
     * @return
     */
    public String countSql(String sql) {
        return new StringBuffer("SELECT COUNT(1) AS ROW_COUNT FROM ( ").append(sql).append(" ) AS COUNT_QUERY").toString();
    }

}