package com.vitamincode.vitamincode_be.dto.response;

import com.vitamincode.vitamincode_be.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDtoResponse{
    private String username;
    private String email;
    private Boolean enabled;
    private Role role;
}
