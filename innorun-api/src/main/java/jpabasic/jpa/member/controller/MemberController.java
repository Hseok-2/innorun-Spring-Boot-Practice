package jpabasic.jpa.member.controller;

import jakarta.validation.Valid;
import jpabasic.jpa.member.dto.*;
import jpabasic.jpa.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    // 등록
    @PostMapping
    public ResponseEntity<CreateMemberResponse> create(@Valid @RequestBody CreateMemberRequest request) {
        CreateMemberResponse result = memberService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // 전체 조회
    @GetMapping
    public ResponseEntity<List<GetMemberResponse>> getAll() {
        List<GetMemberResponse> result = memberService.getAll();
        return ResponseEntity.ok(result);
    }

    // 단 건 조회
    @GetMapping("/{memberId}")
    public ResponseEntity<GetMemberResponse> getOne(@PathVariable Long memberId) {
        GetMemberResponse result = memberService.getOne(memberId);
        return ResponseEntity.ok(result);
    }

    // 수정
    @PutMapping("/{memberId}")
    public ResponseEntity<UpdateMemberResponse> update(@PathVariable Long memberId, @Valid @RequestBody UpdateMemberRequest request) {
        UpdateMemberResponse result = memberService.update(memberId, request);
        return ResponseEntity.ok(result);
    }

    // 삭제
    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> delete(@PathVariable Long memberId) {
        memberService.delete(memberId);
        return ResponseEntity.noContent().build();
    }
}
