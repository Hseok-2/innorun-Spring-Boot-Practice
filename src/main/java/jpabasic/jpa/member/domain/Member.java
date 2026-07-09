package jpabasic.jpa.member.domain;

import jakarta.persistence.*;
import jpabasic.jpa.global.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Builder
    private Member(String name) {
        this.name = name;
    }

    public void update(String newName) {
        this.name = newName;
    }
}
