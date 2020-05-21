package com.zs.zuoye.entityQuery;

public abstract class PageEntityQuery extends AbstractEntityQuery {
    private int startPer;
    private int perPage;

    public int getStartPer() {
        return startPer;
    }

    public void setStartPer(int startPer) {
        this.startPer = startPer;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }
}
