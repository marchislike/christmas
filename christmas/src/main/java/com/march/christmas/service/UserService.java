package com.march.christmas.service;

import com.march.christmas.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // final 필드를 매개변수로 하는 생성자를 자동 생성
public class UserService {
    private final UserRepository userRepository;



}
