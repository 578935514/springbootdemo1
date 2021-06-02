package com.cxp.sbt.util;

import java.util.List;

//分页类，保持返回数据类型一致
public class Pager<T> {

    private int page;//分页起始页
    private int size;//每页记录数
    private List<T> contens;//返回的记录集合
    private long total;//总记录条数

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<T> getContens() {
        return contens;
    }

    public void setContens(List<T> contens) {
        this.contens = contens;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }


}
