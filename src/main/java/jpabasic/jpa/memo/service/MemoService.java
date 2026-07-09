package jpabasic.jpa.memo.service;

import jpabasic.jpa.memo.domain.Memo;
import jpabasic.jpa.memo.dto.*;
import jpabasic.jpa.memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    // 등록
    public CreateMemoResponse save(CreateMemoRequest request) {
        Memo memo = memoRepository.save(request.toEntity());
        return CreateMemoResponse.from(memo);
    }

    // 전체 조회
    @Transactional(readOnly = true)
    public List<GetMemoResponse> getAll() {
        return memoRepository.findAll().stream()
                .map(GetMemoResponse::from)
                .toList();
    }

    // 단 건 조회
    @Transactional(readOnly = true)
    public GetMemoResponse getOne(Long id) {
        return memoRepository.findById(id)
                .map(GetMemoResponse::from)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 메모입니다."));
    }

    // 수정
    public UpdateMemoResponse update(Long id, UpdateMemoRequest request) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 메모입니다."));
        memo.updateMemo(request.getContents());
        return UpdateMemoResponse.from(memo);
    }

    // 삭제
    public void delete(Long memoId) {
        Memo memo = memoRepository.findById(memoId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 메모입니다"));
        memoRepository.delete(memo);
    }
}
