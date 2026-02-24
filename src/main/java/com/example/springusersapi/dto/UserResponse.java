package com.example.springusersapi.dto;

import java.util.Date;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String name,
        String email,
        String phone
) {}
