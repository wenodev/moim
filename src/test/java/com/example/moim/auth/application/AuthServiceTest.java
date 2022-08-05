package com.example.moim.auth.application;

import com.example.moim.auth.dto.TokenRequest;
import com.example.moim.auth.dto.TokenResponse;
import com.example.moim.auth.infra.JwtTokenProvider;
import com.example.moim.member.application.MemberService;
import com.example.moim.member.domain.Gender;
import com.example.moim.member.domain.Member;
import com.example.moim.utils.CipherGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {
    @Mock
    private MemberService memberService;
    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @InjectMocks
    private AuthService authService;

    @DisplayName("유효한 id와 password를 요청하면, accessToken을 반환한다")
    @Test
    void login() {
        String memberId = "test-id";
        String password = "test-password";
        String encodedPassword = CipherGenerator.encode("test-password");
        TokenRequest request = new TokenRequest(memberId, password);
        Member member = Member.createParticipant("참여자", LocalDate.now(), Gender.MALE,
                "test-id", encodedPassword,
                "weno@next.com", List.of("후추", "돼지고기"), "안녕하세요");
        given(memberService.getByMemberId(memberId)).willReturn(member);
        given(jwtTokenProvider.createToken(request.getMemberId())).willReturn(encodedPassword);

        TokenResponse response = authService.login(request);

        assertThat(response.getAccessToken()).isEqualTo(encodedPassword);
    }
}
