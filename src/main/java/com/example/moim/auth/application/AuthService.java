package com.example.moim.auth.application;

import com.example.moim.auth.dto.TokenRequest;
import com.example.moim.auth.dto.TokenResponse;
import com.example.moim.auth.infra.JwtTokenProvider;
import com.example.moim.member.application.MemberService;
import com.example.moim.member.domain.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AuthService {
    private final MemberService memberService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthService(MemberService memberService, JwtTokenProvider jwtTokenProvider) {
        this.memberService = memberService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public TokenResponse login(TokenRequest request) {
        Member member = memberService.getByMemberId(request.getUserId());
        member.checkPassword(request.getPassword());

        String token = jwtTokenProvider.createToken(request.getUserId());
        return new TokenResponse(token);
    }
}
