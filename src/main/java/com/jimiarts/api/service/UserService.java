package com.jimiarts.api.service;

import com.jimiarts.api.model.User;
import com.jimiarts.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    final UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }
}
