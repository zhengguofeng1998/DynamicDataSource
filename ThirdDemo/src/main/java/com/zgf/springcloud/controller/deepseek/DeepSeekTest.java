package com.zgf.springcloud.controller.deepseek;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.zgf.springcloud.eum.DeepSeekRoleEnum;
import com.zgf.springcloud.eum.DeepSeekUrlEnum;

import java.util.ArrayList;
import java.util.List;


public class DeepSeekTest {

    private final static String token = "sk-0db0fb10738241e284b5b07baafe5c1c";

    public static void main(String[] args) {
        // deepSeekTest();
        models();
    }

    public static void deepSeekTest() {
        RemoteVo remoteVo = new RemoteVo();
        List<RemoteVo.Messages> messagesList = new ArrayList<>();
        messagesList.add(new RemoteVo.Messages("You are a helpful assistant", DeepSeekRoleEnum.SYSTEM.code));
        messagesList.add(new RemoteVo.Messages("你好", DeepSeekRoleEnum.USER.code));
        remoteVo.setMessages(messagesList);
        RemoteVo.Response_format text = new RemoteVo.Response_format("text");
        remoteVo.setResponse_format(text);
        String jsonStr = JSONUtil.toJsonStr(remoteVo);
        HttpResponse execute = HttpRequest.post(DeepSeekUrlEnum.对话补全.url)
                .body(jsonStr)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + token)
                .execute();
        String body = execute.body();
        System.out.println(body);
    }


    public static void models() {
        HttpResponse execute = HttpRequest.get(DeepSeekUrlEnum.列出模型.url)
                .contentType("text/plain")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + token)
                .execute();
        String body = execute.body();
        System.out.println(body);
    }
}
