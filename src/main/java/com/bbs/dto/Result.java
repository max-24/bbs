package com.bbs.dto;

import com.sun.org.apache.xml.internal.utils.Trie;

/*
用来controller层向view传递数据封装的类
 */

public class Result<T> {

    private Boolean success;
    private T data;
    private String error;

    public Result(Boolean success,String error)
    {
        this.success=success;
        this.error=error;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Result(Boolean success, T data)
    {
        this.success=success;
        this.data=data;
    }




}
