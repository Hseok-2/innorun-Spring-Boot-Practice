package jpabasic.jpa.member.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jpabasic.jpa.member.domain.Member;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateMemberResponse {

    private final Long id;
    private final String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private final LocalDateTime createAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private final LocalDateTime updatedAt;

    public UpdateMemberResponse(Long id, String name, LocalDateTime createAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
    }

    public static UpdateMemberResponse from(Member member) {
        return new UpdateMemberResponse(
                member.getId(),
                member.getName(),
                member.getCreatedAt(),
                member.getUpdatedAt()
        );
    }
}
