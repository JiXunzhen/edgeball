package top.json.edgeball.service;

import lombok.Getter;
import lombok.Setter;
import top.json.edgeball.consts.ResponseCode;

import java.io.Serializable;

public class Response<T> implements Serializable {
    private static final long serialVersionUID = 2319215648193331915L;
    private boolean success;
    private ResponseCode code;
    private String errMsg;

    private T data;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ResponseCode getCode() {
        return code;
    }

    public void setCode(ResponseCode code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{success=" + this.success + ", code=" + this.code + ", errMsg='" + this.errMsg + '\'' + ", data=" + this.data + '}';
    }

    public static <T> Response<T> buildSucess(T data) {
        Response<T> response = new Response<>();
        response.setData(data);
        response.setSuccess(true);
        response.setCode(ResponseCode.SUCCESS);
        return response;
    }

    public static <T> Response<T> buildFail(ResponseCode code, String msg) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setCode(code);
        response.setErrMsg(msg);
        return response;
    }
    public static <T> Response<T> buildFail(ResponseCode code) {
        return buildFail(code, code.getMsg());
    }
}
