package top.json.edgeball.consts;

import lombok.Getter;

@Getter
public enum Priority {
    NORMAL(1, "普通用户"),
    SUPERADMIN(1, "超级管理员");

    private int code;
    private String msg;

    public String toString() {
        return this.code + ":" + this.msg;
    }

    private Priority(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
