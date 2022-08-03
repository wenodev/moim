package com.example.moim.application;

import com.example.moim.domain.Member;
import com.example.moim.domain.MemberRepository;
import com.example.moim.dto.HostRequest;
import com.example.moim.dto.HostResponse;
import com.example.moim.dto.ParticipantRequest;
import com.example.moim.dto.ParticipantResponse;
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
