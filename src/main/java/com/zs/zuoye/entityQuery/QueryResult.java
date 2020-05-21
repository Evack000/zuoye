package com.zs.zuoye.entityQuery;

import java.util.List;

public class QueryResult<EntityType> {
    private List<EntityType> data;
    private int count;
    private int pageSize;
    private int pageNumber;


    public QueryResult(){

    }

    public QueryResult(List<EntityType> data, int count, int pageSize, int pageNumber) {
        this.data = data;
        this.count = count;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public List<EntityType> getData() {
        return data;
    }

    public void setData(List<EntityType> data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
