package jpabasic.jpa.user.dto;

import jpabasic.jpa.user.domain.User;
import lombok.Getter;

@Getter
public class CreateUserResponse {

    private final Long id;
    private final String name;
    private final String email;
    private final String address;

    public CreateUserResponse(Long id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public static CreateUserResponse from(User user) {
        return new CreateUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getAddress()
        );
    }
}
