package com.march.christmas.dto;

import lombok.Getter;
import lombok.Setter;

public class PostDto {

    private String title;
    private String content;

    // 새로운 생성자 추가
    public PostDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Getter
    @Setter
    public static class CreateRequest {
        private String title;
        private String content;
        private Long authorId;

    }

    @Getter
    @Setter
    public static class UpdateRequest {
        private String title;
        private String content;
    }
}
