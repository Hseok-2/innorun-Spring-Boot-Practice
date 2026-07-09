package jpabasic.jpa.member.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jpabasic.jpa.member.domain.Member;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateMemberResponse {

    private final Long id;
    private final String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private final LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private final LocalDateTime updatedAt;

    public CreateMemberResponse(Long id, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static CreateMemberResponse from(Member member) {
        return new CreateMemberResponse(
                member.getId(),
                member.getName(),
                member.getCreatedAt(),
                member.getUpdatedAt()
        );
    }
}
