package com.smatech.auth_service.util;

import com.smatech.auth_service.dto.UserResponse;
import com.smatech.auth_service.model.User;

import java.time.format.DateTimeFormatter;

public class UserMapper {

    public static UserResponse toResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(String.valueOf(user.getId()));
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setAddress(user.getAddress());
        response.setMobileNumber(user.getPhoneNumber());

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        response.setCreatedAt(user.getCreatedAt() != null ? user.getCreatedAt().format(formatter) : null);
        response.setUpdatedAt(user.getUpdatedAt() != null ? user.getUpdatedAt().format(formatter) : null);

        return response;
    }
}