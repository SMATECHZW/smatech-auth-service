package com.smatech.auth_service.dto;

import lombok.Data;

@Data
public class LoginCredentials {
    private String email;
    private String password;
}
