package com.example.moim.auth.ui;

import com.example.moim.auth.application.AuthService;
import com.example.moim.auth.dto.TokenRequest;
import com.example.moim.auth.dto.TokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login/token")
    public ResponseEntity<TokenResponse> login(@RequestBody TokenRequest request) {
        TokenResponse response = authService.login(request);
        return ResponseEntity.ok().body(response);
    }
}
