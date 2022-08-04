package com.example.moim.member.application;

import com.example.moim.member.domain.Member;
import com.example.moim.member.domain.MemberRepository;
import com.example.moim.member.dto.HostRequest;
import com.example.moim.member.dto.HostResponse;
import com.example.moim.member.dto.ParticipantRequest;
import com.example.moim.member.dto.ParticipantResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public HostResponse createHost(HostRequest request) {
        Member member = memberRepository.save(Member.createHost(request.getName(), request.getDateOfBirth(),
                request.getGender(), request.getUserID(), request.getPassword(), request.getEmail(), request.getCompany()));

        return HostResponse.of(member);
    }

    public ParticipantResponse createParticipant(ParticipantRequest request) {
        Member participant = Member.createParticipant(request.getName(), request.getDateOfBirth(),
                request.getGender(), request.getUserID(), request.getPassword(), request.getEmail(),
                request.getIngredients(), request.getIntroduction());

        Member member = memberRepository.save(participant);

        return ParticipantResponse.of(member);
    }
}
