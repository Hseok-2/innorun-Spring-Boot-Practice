package jpabasic.jpa.member.service;

import jpabasic.jpa.member.domain.Member;
import jpabasic.jpa.member.dto.*;
import jpabasic.jpa.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 등록
    public CreateMemberResponse save(CreateMemberRequest request) {
        Member member = memberRepository.save(request.toEntity());
        return CreateMemberResponse.from(member);
    }

    // 전체 조회
    @Transactional(readOnly = true)
    public List<GetMemberResponse> getAll() {
        return memberRepository.findAll().stream()
                .map(GetMemberResponse::from)
                .toList();
    }

    // 단 건 조회
    @Transactional(readOnly = true)
    public GetMemberResponse getOne(Long memberId) {
        return memberRepository.findById(memberId)
                .map(GetMemberResponse::from)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 멤버입니다."));
    }

    // 수정
    public UpdateMemberResponse update(Long memberId, UpdateMemberRequest request) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 멤버입니다."));
        member.update(request.getName());
        return UpdateMemberResponse.from(member);
    }

    // 삭제
    public void delete(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 멤버입니다."));
        memberRepository.delete(member);
    }
}
