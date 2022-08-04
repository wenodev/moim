package com.example.moim.auth.application;

import com.example.moim.auth.dto.TokenRequest;
import com.example.moim.auth.dto.TokenResponse;
import com.example.moim.member.application.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {
    @Mock
    private MemberService memberService;

    @InjectMocks
    private AuthService authService;

    @DisplayName("유효한 id와 password를 요청하면, accessToken을 반환한다")
    @Test
    void login() {

        String userId = "test-id";
        String password = "test-password";
        TokenRequest request = new TokenRequest(userId, password);

        TokenResponse response = authService.login(request);

        assertThat(response.getAccessToken()).isNotBlank();
    }
}
