package com.example.moim.member.domain;

import com.example.moim.member.domain.Member;
import com.example.moim.member.domain.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("멤버를 저장한다.")
    @Test
    void save() {
        Member save = memberRepository.save(new Member());

        assertThat(save.getId()).isEqualTo(1L);
    }
}
