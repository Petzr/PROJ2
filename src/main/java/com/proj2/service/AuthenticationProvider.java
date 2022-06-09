package com.proj2.service;

import com.proj2.model.UserRepository;

public class AuthenticationProvider {
    private final UserRepository userRepository = UserRepository.getInstance();
}
