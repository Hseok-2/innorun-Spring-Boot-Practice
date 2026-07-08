package jpabasic.jpa.user.controller;

import jpabasic.jpa.user.dto.*;
import jpabasic.jpa.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // 등록
    @PostMapping
    public ResponseEntity<CreateUserResponse> create(@RequestBody CreateUserRequest request) {
        CreateUserResponse result = userService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // 전체 조회
    @GetMapping
    public ResponseEntity<List<GetUserResponse>> getAll() {
        List<GetUserResponse> result = userService.getAll();
        return ResponseEntity.ok(result);
    }

    // 단 건 조회
    @GetMapping("/{userId}")
    public ResponseEntity<GetUserResponse> getOne(@PathVariable Long userId) {
        GetUserResponse result = userService.getOne(userId);
        return ResponseEntity.ok(result);
    }

    // 수정
    @PutMapping("/{userId}")
    public ResponseEntity<UserUpdateResponse> update(@PathVariable Long userId, @RequestBody UserUpdateRequest request) {
        UserUpdateResponse result = userService.update(userId, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 삭제
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable Long userId) {
        userService.delete(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
