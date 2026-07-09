package jpabasic.jpa.memo.controller;

import jakarta.validation.Valid;
import jpabasic.jpa.memo.dto.*;
import jpabasic.jpa.memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/memos")
public class MemoController {

    private final MemoService memoService;

    // 등록
    @PostMapping
    public ResponseEntity<CreateMemoResponse> create(@Valid @RequestBody CreateMemoRequest request) {
        CreateMemoResponse result = memoService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // 전체 조회
    @GetMapping
    public ResponseEntity<List<GetMemoResponse>> getAll() {
        List<GetMemoResponse> result = memoService.getAll();
        return ResponseEntity.ok(result);
    }

    // 단 건 조회
    @GetMapping("/{memoId}")
    public ResponseEntity<GetMemoResponse> getOne(@PathVariable Long memoId) {
        GetMemoResponse result = memoService.getOne(memoId);
        return ResponseEntity.ok(result);
    }

    // 수정
    @PutMapping("/{memoId}")
    public ResponseEntity<UpdateMemoResponse> update(@PathVariable Long memoId, @Valid @RequestBody UpdateMemoRequest request) {
        UpdateMemoResponse result = memoService.update(memoId, request);
        return ResponseEntity.ok(result);
    }

    // 삭제
    @DeleteMapping("/{memoId}")
    public ResponseEntity<Void> delete(@PathVariable Long memoId) {
        memoService.delete(memoId);
        return ResponseEntity.noContent().build();
    }
}
