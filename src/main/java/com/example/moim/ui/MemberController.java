package com.example.moim.ui;

import com.example.moim.application.MemberService;
import com.example.moim.dto.HostRequest;
import com.example.moim.dto.HostResponse;
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

    @PostMapping("/host")
    public ResponseEntity<HostResponse> createHost(@RequestBody HostRequest request) {
        HostResponse response = memberService.createHost(request);
        return ResponseEntity.created(URI.create("/host/" + response.getId())).build();
    }

}
