package com.example.moim.application;

import com.example.moim.domain.Member;
import com.example.moim.domain.MemberRepository;
import com.example.moim.dto.HostRequest;
import com.example.moim.dto.HostResponse;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public HostResponse createHost(HostRequest request) {
        Member member = memberRepository.save(new Member(request.getName(), request.getDateOfBirth(), request.getGender(), request.getUserID(),
                request.getPassword(), request.getEmail(), request.getCompany()));

        return HostResponse.of(member);
    }
}
