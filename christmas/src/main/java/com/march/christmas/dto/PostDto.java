package com.march.christmas.dto;

import lombok.Getter;
import lombok.Setter;

public class PostDto {

    @Getter
    @Setter
    public static class CreateRequest {
        private String title;
        private String content;
    }

    @Getter
    @Setter
    public static class UpdateRequest {
        private String title;
        private String content;
    }
}
