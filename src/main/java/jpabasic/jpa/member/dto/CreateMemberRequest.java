package jpabasic.jpa.member.dto;

import jakarta.validation.constraints.NotBlank;
import jpabasic.jpa.member.domain.Member;
import lombok.Getter;

@Getter
public class CreateMemberRequest {

    @NotBlank(message = "이름은 필수입니다.")
    private String name;

    // Builder 패턴 적용
    public Member toEntity() {
        return Member.builder()
                .name(this.name)
                .build();
    }
}
