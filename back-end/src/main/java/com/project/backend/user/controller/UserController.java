package com.project.backend.user.controller;


import com.project.backend.user.dto.UserRequest;
import com.project.backend.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "사용자 인증 API", description = "사용자 인증 및 로그아웃 관련 API 엔드포인트")
@RestController
@RequestMapping("/api/users/")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("join")
    public ResponseEntity<String> Register(@RequestBody UserRequest userRequest) {
        userService.register(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공");
    }
}
