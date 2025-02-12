package com.zgf.springcloud.eum;

public enum DeepSeekRoleEnum {

    USER("user", "用户"),
    SYSTEM("system", "系统");

    public final String code;

    public final String value;

    DeepSeekRoleEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

}
