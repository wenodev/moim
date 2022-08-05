package com.example.moim.member.ui;

import com.example.moim.member.application.MemberService;
import com.example.moim.member.dto.HostRequest;
import com.example.moim.member.dto.HostResponse;
import com.example.moim.member.dto.ParticipantRequest;
import com.example.moim.member.dto.ParticipantResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/members/host")
    public ResponseEntity<HostResponse> createHost(@RequestBody HostRequest request) {
        HostResponse response = memberService.createHost(request);
        return ResponseEntity.created(URI.create("/host/" + response.getId())).build();
    }

    @PostMapping("/members/participant")
    public ResponseEntity<ParticipantResponse> createParticipant(@RequestBody ParticipantRequest request) {
        ParticipantResponse response = memberService.createParticipant(request);
        return ResponseEntity.created(URI.create("/participant/" + response.getId())).build();
    }
}
