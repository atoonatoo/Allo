package com.project.backend.user.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;

    public void validate() {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("아이디가 비어있습니다.");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("비밀번호가 비어있습니다.");
        }
    }
}
