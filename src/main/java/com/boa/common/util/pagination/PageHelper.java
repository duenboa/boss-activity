package com.boa.common.util.pagination;//package com.boa.stu.test.util.pagination;
//
//import java.beans.BeanInfo;
//import java.beans.IntrospectionException;
//import java.beans.Introspector;
//import java.beans.PropertyDescriptor;
//import java.lang.reflect.InvocationTargetException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static javafx.scene.input.KeyCode.T;
//
///**
// * @Copyright (C), 2012-2020 上海好屋网信息技术有限公司
// * @Author: DengBenbo 20160289
// * @Date: 2017/4/10
// * @Version: 1.0.0
// * @Description:
// * @History: 变更记录
// * <author>           <time>             <version>        <desc>
// * Duenboa            2017/4/10            00000001         创建文件
// */
//public class PageHelper<T> {
//
//    private Object query;
//
//    private Long totalRecord; //总记录数
//    private Long pageNum; //查询的页号从1开始
//    private Long startRow; // 查询起始记录数
//    private Long pageSize; // 每页显示记录数
//    private Long totalPageSize; //总页数
//
//    private List<T> content; //分页后的数据内容
//
//
//    public List<T> getContent() {
//        return content;
//    }
//
//    public void setContent(List<T> content) {
//        this.content = content;
//    }
//
//    public Object getQuery() {
//        return query;
//    }
//
//    public void setQuery(Object o) {
//        query = new HashMap<Object, Object>();
//        Map map = (Map) this.query;
//        BeanInfo beanInfo;
//        try {
//            beanInfo = Introspector.getBeanInfo(o.getClass());
//        } catch (IntrospectionException e) {
//            e.printStackTrace();
//            throw new IllegalArgumentException(e.getMessage(), e);
//        }
//        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
//        for (PropertyDescriptor descriptor : descriptors) {
//            try {
//                map.put(descriptor.getName(), descriptor.getReadMethod().invoke(o));
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//                throw new IllegalStateException(e);
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//                throw new IllegalStateException(e);
//            }
//        }
//        map.put("startRow", startRow);
//        map.put("pageSize", pageSize);
//    }
//
//
//    public Long getPageNum() {
//        return pageNum;
//    }
//
//    public void setPageNum(Long pageNum) {
//        this.pageNum = pageNum;
//    }
//
//    public Long getStartRow() {
//        if (startRow == null && pageNum != null) {
//            startRow = (pageNum - 1) * pageSize;
//        }
//        return startRow;
//    }
//
//    public void setStartRow(Long startRow) {
//        this.startRow = startRow;
//    }
//
//    public Long getPageSize() {
//        return pageSize;
//    }
//
//    public void setPageSize(Long pageSize) {
//        this.pageSize = pageSize;
//        assembleField();
//    }
//
//    public Long getTotalRecord() {
//        return totalRecord;
//    }
//
//    public void setTotalRecord(Long totalRecord) {
//        this.totalRecord = totalRecord;
//        assembleField();
//    }
//
//    public Long getTotalPageSize() {
//        if (totalRecord != null && pageSize != null && totalRecord != 0 && pageSize != 0) {
//            if (totalRecord < pageSize) {
//                totalPageSize = 1L;
//            } else {
//                totalPageSize = totalRecord / pageSize;
//                int addPage = totalRecord % pageSize > 0 ? 1 : 0;  // 不是整除则多一个尾页.
//                totalPageSize = totalPageSize + addPage;
//            }
//        }
//        return totalPageSize;
//    }
//
//    public void setTotalPageSize(Long totalPageSize) {
//        this.totalPageSize = totalPageSize;
//    }
//
//    private void assembleField() {
//        if (pageSize != null && pageNum != null && totalRecord != null) {
//            getStartRow();
//            getTotalPageSize();
//        }
//    }
//}
