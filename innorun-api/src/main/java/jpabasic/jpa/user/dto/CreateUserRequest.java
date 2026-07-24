package jpabasic.jpa.user.dto;

import jpabasic.jpa.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateUserRequest {

    private String name;
    private String email;
    private String address;

    public User toEntity() {
        return new User(this.name, this.email, this.address);
    }
}
