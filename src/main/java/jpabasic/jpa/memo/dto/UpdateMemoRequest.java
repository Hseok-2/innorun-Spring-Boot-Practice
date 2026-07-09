package jpabasic.jpa.memo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateMemoRequest {

    @NotBlank(message = "메모 수정 시 메모 내용은 필수입니다.")
    private String contents;
}
