package jpabasic.jpa.member.repository;

import jpabasic.jpa.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
