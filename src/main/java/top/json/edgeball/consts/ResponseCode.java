package top.json.edgeball.consts;


import lombok.Getter;

public enum ResponseCode {
    SUCCESS(0, "success"),
    DATABASE_ERROR(1, "数据库异常"),
    USER_DOES_NOT_EXIST(2, "用户不存在");

    private int code;
    private String msg;

    public String toString() {
        return this.code + ":" + this.msg;
    }

    private ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
