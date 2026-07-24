package jpabasic.jpa.user.dto;

import jpabasic.jpa.user.domain.User;
import lombok.Getter;

@Getter
public class UserUpdateResponse {

    private final long id;
    private final String name;
    private final String email;
    private final String address;

    public UserUpdateResponse(long id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public static UserUpdateResponse from(User user) {
        return new UserUpdateResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getAddress()
        );
    }
}
