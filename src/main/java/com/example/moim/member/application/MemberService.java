package com.example.moim.member.application;

import com.example.moim.common.ErrorMessage;
import com.example.moim.common.NotFoundException;
import com.example.moim.member.domain.Member;
import com.example.moim.member.domain.MemberRepository;
import com.example.moim.member.dto.HostRequest;
import com.example.moim.member.dto.HostResponse;
import com.example.moim.member.dto.MemberResponse;
import com.example.moim.member.dto.ParticipantRequest;
import com.example.moim.member.dto.ParticipantResponse;
import com.example.moim.member.dto.RoleRequest;
import com.example.moim.utils.CipherGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public HostResponse createHost(HostRequest request) {
        Member member = memberRepository.save(Member.createHost(request.getName(), request.getDateOfBirth(),
                request.getGender(), request.getUserID(), CipherGenerator.encode(request.getPassword()), request.getEmail(), request.getCompany()));

        return HostResponse.of(member);
    }

    public ParticipantResponse createParticipant(ParticipantRequest request) {
        Member participant = Member.createParticipant(request.getName(), request.getDateOfBirth(),
                request.getGender(), request.getMemberId(), CipherGenerator.encode(request.getPassword()), request.getEmail(),
                request.getIngredients(), request.getIntroduction());

        Member member = memberRepository.save(participant);

        return ParticipantResponse.of(member);
    }

    @Transactional(readOnly = true)
    public Member getByMemberId(String memberId) {
        return memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND));
    }

    public void updateParticipant(String memberId, ParticipantRequest request) {
        Member member = getByMemberId(memberId);
        member.updateParticipant(request.getName(), request.getDateOfBirth(), request.getGender(),
                request.getEmail(), request.getIngredients(), request.getIntroduction());
    }

    public void addRole(String memberId, RoleRequest request) {
        Member member = getByMemberId(memberId);
        member.addRole(request.getRole());
    }

    public MemberResponse findMember(String memberId) {
        Member member = getByMemberId(memberId);
        return MemberResponse.of(member);
    }
}
