package com.vitamincode.vitamincode_be.dto.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RoleDtoResponse {

    private Integer roleId;
    private String roleName;
    private String roleDescription;
}
