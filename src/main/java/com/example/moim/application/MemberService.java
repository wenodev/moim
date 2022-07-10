package com.example.moim.application;

import com.example.moim.domain.Gender;
import com.example.moim.dto.HostRequest;
import com.example.moim.dto.HostResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MemberService {
    public HostResponse createHost(HostRequest request) {
        return new HostResponse(
                1L, "주최자", LocalDate.now(), Gender.MALE, "host",
                "password", "weno@next.com", "next"
        );
    }
}
