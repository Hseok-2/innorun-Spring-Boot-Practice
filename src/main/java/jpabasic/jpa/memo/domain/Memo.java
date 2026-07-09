package jpabasic.jpa.memo.domain;

import jakarta.persistence.*;
import jpabasic.jpa.global.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Memo extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String contents;

    public Memo(String contents) {
        this.contents = contents;
    }

    public void updateMemo(String newMemo) {
        this.contents = newMemo;
    }
}
