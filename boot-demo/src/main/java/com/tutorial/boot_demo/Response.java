package com.tutorial.boot_demo;

/**
 * @author Siyuan
 * @date 2024/11/01/20:16
 */
public class Response<T> {
    private T data;
    private boolean success;
    private String errorMsg;

    public static <K> Response<K> newSuccess(K data) {
        Response response = new Response();
        response.setData(data);
        response.setSuccess(true);
        return response;
    }

    public static Response<Void> newFailed(String errorMsg) {
        Response response = new Response();
        response.setSuccess(false);
        response.setErrorMsg(errorMsg);
        return response;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
