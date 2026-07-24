package jpabasic.jpa.member.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateMemberRequest {

    @NotBlank(message = "이름 수정 시 이름 작성은 필수 입니다.")
    private String name;
}
