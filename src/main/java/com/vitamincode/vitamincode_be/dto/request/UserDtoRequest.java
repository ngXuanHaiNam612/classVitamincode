package com.vitamincode.vitamincode_be.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDtoRequest {
    private String username;
    private String password;
    private String email;
    private Boolean enabled;
    private Integer roleId;
}
