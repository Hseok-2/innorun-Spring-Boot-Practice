package jpabasic.jpa.memo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jpabasic.jpa.memo.domain.Memo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetMemoResponse {

    private final Long id;
    private final String contents;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd HH:mm:ss", timezone = "Asia/seoul")
    private final LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd HH:mm:ss", timezone = "Asia/seoul")
    private final LocalDateTime updatedAt;

    public GetMemoResponse(Long id, String contents, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.contents = contents;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static GetMemoResponse from(Memo memo) {
        return new GetMemoResponse(
                memo.getId(),
                memo.getContents(),
                memo.getCreatedAt(),
                memo.getUpdatedAt()
        );
    }
}
