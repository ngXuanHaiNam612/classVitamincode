package com.vitamincode.vitamincode_be.convert;

import com.vitamincode.vitamincode_be.dto.response.RoleDtoResponse;
import com.vitamincode.vitamincode_be.entity.Role;

public class RoleConvert {

    public static RoleDtoResponse roleEntityConvertToRoleResponse(Role role){

        return RoleDtoResponse.builder()
                .roleId(role.getRoleId())
                .roleName(role.getRoleName())
                .roleDescription(role.getDescription())
                .build();
    }
}
