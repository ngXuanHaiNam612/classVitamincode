package com.vitamincode.vitamincode_be.dto.response;

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
    private Integer roleId;
}
