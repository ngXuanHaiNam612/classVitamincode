package com.vitamincode.vitamincode_be.dto.request;

import com.vitamincode.vitamincode_be.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDtoRequest {
    private String username;
    private String password;
    private String email;
    private Boolean enabled;
    private Role role;
}
