package jpabasic.jpa.user.repository;

import jpabasic.jpa.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

