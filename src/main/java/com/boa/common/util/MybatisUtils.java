package com.boa.common.util;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

public class MybatisUtils {

    public static DefaultParameterHandler copy(DefaultParameterHandler handler){

        MappedStatement mappedStatement = (MappedStatement) ReflectUtils.getFieldValue(handler, "mappedStatement");
        Object parameterObject = ReflectUtils.getFieldValue(handler, "parameterObject");
        BoundSql boundSql = (BoundSql)ReflectUtils.getFieldValue(handler, "boundSql");
        return new DefaultParameterHandler(mappedStatement,parameterObject,boundSql);
    }

    public static void replaceSql(BoundSql boundSql,String sql ){

        ReflectUtils.setFieldValue(boundSql,"sql",sql);
    }
}

