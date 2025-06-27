package com.smatech.auth_service.service;


import com.smatech.auth_service.dto.*;

public interface AuthService {
    RegisterResponse register(RegisterDTO registerDTO);
    Response registerUser(RegisterDTO registerDTO);
    Response login(LoginCredentials loginCredentials);
}
