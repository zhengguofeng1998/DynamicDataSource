package com.zgf.springcloud.eum;

public enum DeepSeekUrlEnum {
    对话补全("https://api.deepseek.com/chat/completions", "POST"),
    列出模型("https://api.deepseek.com/models", "GET"),
    查询余额("https://api.deepseek.com/user/balance", "GET"),
    FIM补全("https://api.deepseek.com/beta/completions", "POST"),
    ;

    public final String url;

    public final String methodType;


    DeepSeekUrlEnum(String url, String methodType) {
        this.url = url;
        this.methodType = methodType;
    }
}
