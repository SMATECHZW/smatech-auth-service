package com.smatech.auth_service.dto;

import lombok.Data;

@Data
public class UserResponse {
    private String id;
    private String name;
    private String email;
    private String address;
    private String mobileNumber;
    private String createdAt;
    private String updatedAt;

}