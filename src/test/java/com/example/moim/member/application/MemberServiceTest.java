package com.example.moim.member.application;

import com.example.moim.member.application.MemberService;
import com.example.moim.member.domain.Gender;
import com.example.moim.member.domain.Member;
import com.example.moim.member.domain.MemberRepository;
import com.example.moim.member.dto.HostRequest;
import com.example.moim.member.dto.HostResponse;
import com.example.moim.member.dto.ParticipantRequest;
import com.example.moim.member.dto.ParticipantResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

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

        Member member = Member.createHost("주최자1", LocalDate.now(), Gender.MALE, "host",
                "password", "weno@next.com", "next");

        given(memberRepository.save(any(Member.class))).willReturn(member);

        HostResponse response = memberService.createHost(request);

        assertThat(response.getName()).isEqualTo("주최자1");
    }

    @DisplayName("주최자 회원가입 한다.")
    @Test
    void createParticipant() {
        ParticipantRequest request = new ParticipantRequest(
                "참여자", LocalDate.now(), Gender.MALE, "participant",
                "password", "weno@next.com", List.of("후추", "돼지고기"), "안녕하세요"
        );

        Member member = Member.createParticipant("주최자1", LocalDate.now(), Gender.MALE, "host",
                "password", "weno@next.com", List.of("후추", "돼지고기"), "안녕하세요");

        given(memberRepository.save(any(Member.class))).willReturn(member);

        ParticipantResponse response = memberService.createParticipant(request);

        assertThat(response.getName()).isEqualTo("주최자1");
    }
}
