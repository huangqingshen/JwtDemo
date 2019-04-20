package com.token.jwt.vo;


import java.util.ArrayList;
import java.util.List;

/**
 * 带分页信息的数据
 */
public class PageDataResult<T> {
    PageInfoResult pageInfo;

    List<T> data = new ArrayList<>();

    public PageDataResult() {
    }

    public PageDataResult(PageInfoResult pageInfo, List<T> data) {
        this.pageInfo = pageInfo;
        this.data = data;
    }

    public PageInfoResult getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfoResult pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}