package com.example.springusersapi.service;

import com.example.springusersapi.domain.entity.User;
import com.example.springusersapi.dto.CreateUserRequest;
import com.example.springusersapi.dto.UserResponse;
import com.example.springusersapi.exception.BusinessException;
import com.example.springusersapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse create(CreateUserRequest request) {

        if (repository.findByEmail(request.email()).isPresent()) {
            throw new BusinessException("Email já cadastrado");
        }

        User user = new User();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));

        repository.save(user);

        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
