package com.example.springusersapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
        @NotBlank(message = "Nome é obrigatório")
        String name,

        @Email(message = "Email inválido")
        @NotBlank(message = "Email é obrigatório")
        String email,

        @Pattern(
                regexp = "^(\\+55)?[0-9]{10,11}$",
                message = "Telefone inválido. Use formato: 85999999999 ou +5585999999999"
        )
        String phone,

        @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
        String password
) {}