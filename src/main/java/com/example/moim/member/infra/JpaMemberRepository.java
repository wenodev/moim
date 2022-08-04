package com.example.moim.member.infra;

import com.example.moim.member.domain.Member;
import com.example.moim.member.domain.MemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaMemberRepository extends MemberRepository, JpaRepository<Member, Long> {
    Member save(Member member);

    Optional<Member> findByMemberId(String memberId);
}
