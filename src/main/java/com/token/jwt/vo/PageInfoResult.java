package com.token.jwt.vo;


/**
 * @author haort
 * @date 2018/2/28
 */
public class PageInfoResult {
    Integer page;
    Integer size;
    Long total;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
