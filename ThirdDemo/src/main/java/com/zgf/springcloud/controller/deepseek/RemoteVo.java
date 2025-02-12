package com.zgf.springcloud.controller.deepseek;

import lombok.Data;

import java.util.List;

@Data
public class RemoteVo {
    private List<Messages> messages;

    private String model = "deepseek-chat";

    private int frequency_penalty = 0;

    private int max_tokens = 2048;

    private int presence_penalty = 0;

    private Response_format response_format;

    private String stop;

    private boolean stream = false;

    private String stream_options;

    private int temperature = 1;

    private int top_p = 1;

    private String tools;

    private String tool_choice = "none";

    private boolean logprobs = false;

    private String top_logprobs = null;

    @Data
    public static class Messages {
        private String content;

        private String role;

        public Messages(String content, String role) {
            this.content = content;
            this.role = role;
        }

        public Messages() {
        }
    }

    @Data
    public static class Response_format {
        private String type;

        public Response_format(String type) {
            this.type = type;
        }

        public Response_format() {
        }
    }
}
