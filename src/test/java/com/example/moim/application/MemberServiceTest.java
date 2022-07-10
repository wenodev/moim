package com.example.moim.application;

import com.example.moim.domain.Gender;
import com.example.moim.domain.Member;
import com.example.moim.domain.MemberRepository;
import com.example.moim.dto.HostRequest;
import com.example.moim.dto.HostResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {
    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @DisplayName("주최자 회원가입 한다.")
    @Test
    void createHost() {
        HostRequest request = new HostRequest(
                "주최자1", LocalDate.now(), Gender.MALE, "host",
                "password", "weno@next.com", "next");

        Member member = new Member("주최자1", LocalDate.now(), Gender.MALE, "host",
                "password", "weno@next.com", "next");

        given(memberRepository.save(any(Member.class))).willReturn(member);

        HostResponse response = memberService.createHost(request);

        assertThat(response.getName()).isEqualTo("주최자1");
    }
}
