package com.example.moim.member.domain;

import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByMemberId(String memberId);
}
