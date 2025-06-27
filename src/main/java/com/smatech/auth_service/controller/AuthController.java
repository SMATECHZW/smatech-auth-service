package com.smatech.auth_service.controller;


import com.smatech.auth_service.dto.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.smatech.auth_service.security.JWTUtil;
import com.smatech.auth_service.service.AuthService;
import com.smatech.auth_service.service.UserInfoConfigManager;
import com.smatech.auth_service.util.ResponseHandler;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private JWTUtil jwtUtil;


    @PostMapping("/register")
    public Response register(@Valid @RequestBody RegisterDTO registerDTO) {
        return authService.registerUser(registerDTO);
    }
    @PostMapping("/login")
    public Response login(@Valid @RequestBody LoginCredentials loginCredentials) {
        return authService.login(loginCredentials);
    }

 /*   @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginDTO loginDTO) {
        try {
            //Authentication authenticate =
                    authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
            UserDetails userDetails = userInfoConfigManager.loadUserByUsername(loginDTO.getUsername());
            String jwt = jwtUtil.generateToken(userDetails.getUsername());
            var loginResponse = LoginResponse
                    .builder()
                    .accessToken(jwt)
                    .build();
            return ResponseHandler.generateResponse("User logged in successfully", HttpStatus.OK, loginResponse);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Incorrect username or password", HttpStatus.BAD_REQUEST);
        }
    }*/
    @PostMapping("/validate")
    public ResponseEntity<Object> validateToken(@Valid @RequestBody ValidateTokenRequest request) {
        return ResponseHandler.generateResponse("Token is valid", HttpStatus.OK, jwtUtil.validateToken(request.getToken()));
    }
}
