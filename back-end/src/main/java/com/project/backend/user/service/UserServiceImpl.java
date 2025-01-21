package com.project.backend.user.service;

import com.project.backend.user.domain.User;
import com.project.backend.user.dto.UserRequest;
import com.project.backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Transactional
    @Override
    public void register(UserRequest userRequest) {
        // 입력 값 검증
        userRequest.validate();

        // 사용자 이름 중복 확인
        if (userRepository.existsByUsername(userRequest.getUsername())) {
            throw new IllegalStateException("이미 존재하는 사용자 이름입니다.");
        }

        // 사용자 생성
        User user = User.create(userRequest.getUsername(), userRequest.getPassword());

        // 사용자 저장
        userRepository.save(user);
    }
}