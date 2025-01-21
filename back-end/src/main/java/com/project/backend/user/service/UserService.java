package com.project.backend.user.service;


import com.project.backend.user.dto.UserRequest;

public interface UserService {

    void register(UserRequest userRequest);
}
