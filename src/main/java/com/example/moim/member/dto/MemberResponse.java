package com.example.moim.member.dto;

import com.example.moim.member.domain.Member;

public class MemberResponse {
    private HostResponse host;
    private ParticipantResponse participant;

    public static MemberResponse of(Member member) {
        return new MemberResponse(member);
    }

    public MemberResponse(Member member) {
        this.host = HostResponse.of(member);
        this.participant = ParticipantResponse.of(member);
    }

    public MemberResponse() {
    }

    public HostResponse getHost() {
        return host;
    }

    public ParticipantResponse getParticipant() {
        return participant;
    }
}
