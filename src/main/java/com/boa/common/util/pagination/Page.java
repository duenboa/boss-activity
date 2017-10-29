package com.boa.common.util.pagination;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * 分页对象
 *
 * @param <T>
 */
public class Page<T> implements Serializable {

    private Object query; //貌似无用
    private List data;  //分页查询完之后, list就被封装进data里了
    private Long totalSize; //总记录数
    private Integer pageSize = 20; //每页记录数, 默认20
    private Integer pageNumber = 1; // 查询页号, 默认1
    private Integer totalPage;  // 总页数

    public Page() {
        query = new HashMap<Object, Object>(0);
    }

    public Object getQuery() {
        return query;
    }

    public void setQuery(Object query) {
        this.query = query;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {

        this.totalSize = totalSize;
        this.totalPage = Double.valueOf(Math.ceil(new Double(totalSize) / pageSize)).intValue();
    }


    public Integer getStart() {
        return (pageNumber - 1) * pageSize;
    }


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = Math.max(1, pageNumber);
    }

    public Integer getTotalPage() {
        return totalPage;
    }
}
