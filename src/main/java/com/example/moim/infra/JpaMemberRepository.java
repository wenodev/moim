package com.example.moim.infra;

import com.example.moim.domain.Member;
import com.example.moim.domain.MemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberRepository extends MemberRepository, JpaRepository<Member, Long> {
    Member save(Member member);
}
