package jpabasic.jpa.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequest {

    private String name;
    private String email;
    private String address;
}
