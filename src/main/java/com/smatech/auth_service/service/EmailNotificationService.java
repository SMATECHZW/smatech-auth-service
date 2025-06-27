package com.smatech.auth_service.service;

import com.smatech.auth_service.dto.EmailNotificationRequest;

public interface EmailNotificationService {
    void sendEmail(EmailNotificationRequest request);
}
