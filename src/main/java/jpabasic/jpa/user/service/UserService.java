package jpabasic.jpa.user.service;

import jpabasic.jpa.user.domain.User;
import jpabasic.jpa.user.dto.*;
import jpabasic.jpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 등록
    public CreateUserResponse save(CreateUserRequest request) {
        User user = userRepository.save(request.toEntity());
        return CreateUserResponse.from(user);
    }

    // 전체 조회
    @Transactional(readOnly = true)
    public List<GetUserResponse> getAll() {
        return userRepository.findAll().stream()
                .map(GetUserResponse::from)
                .collect(Collectors.toList());
    }

    // 단 건 조회
    @Transactional(readOnly = true)
    public GetUserResponse getOne(Long userId) {
        return userRepository.findById(userId)
                .map(GetUserResponse::from)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 유저입니다."));
    }

    // 수정
    public UserUpdateResponse update(Long userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 유저입니다."));
        user.update(request.getName(), request.getEmail(), request.getAddress());

        return UserUpdateResponse.from(user);
    }

    // 삭제
    public void delete(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 유저입니다."));
        userRepository.delete(user);
    }
}
