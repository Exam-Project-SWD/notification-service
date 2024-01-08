package org.example.notificationservice.service;

import lombok.RequiredArgsConstructor;
import org.example.notificationservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
}
