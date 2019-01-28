package com.my.web.bean;

/**
 * Created by zxc on 2019/1/23.
 */
public class Result {
    private Object data;
    private boolean success=true;



    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
