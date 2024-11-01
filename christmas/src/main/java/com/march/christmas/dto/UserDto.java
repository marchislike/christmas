package com.march.christmas.dto;

import lombok.Getter;
import lombok.Setter;

public class UserDto {

    @Getter
    @Setter
    public static class SignupRequest{
        private String username;
        private String password;
    }

    @Getter
    @Setter
    public static class LoginRequest{
        private String username;
        private String password;
    }
}
