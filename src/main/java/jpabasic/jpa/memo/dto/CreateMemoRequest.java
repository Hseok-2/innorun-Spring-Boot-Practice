package jpabasic.jpa.memo.dto;

import jakarta.validation.constraints.NotBlank;
import jpabasic.jpa.memo.domain.Memo;
import lombok.Getter;

@Getter
public class CreateMemoRequest {

    @NotBlank(message = "메모 내용은 필수입니다.")
    private String contents;

    public Memo toEntity() {
        return new Memo(this.contents);
    }
}
