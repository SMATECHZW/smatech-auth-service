package com.smatech.auth_service.service;

import com.smatech.auth_service.dto.EmailNotificationRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class EmailNotificationServiceImpl implements EmailNotificationService {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${notification.url}")
    private String emailServiceUrl;

    public void sendEmail(EmailNotificationRequest request) {
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(
                    emailServiceUrl,
                    request,
                    String.class
            );
            System.out.println("Email sent: " + response.getBody());
        } catch (RestClientException e) {
            System.err.println("Failed to send email: " + e.getMessage());
        }
    }
}
