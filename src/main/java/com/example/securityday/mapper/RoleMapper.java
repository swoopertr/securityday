package com.example.securityday.mapper;

import com.example.securityday.dto.RoleDto;
import com.example.securityday.entity.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleMapper {
    public static RoleDto RoleToRoleDto(Role role){
        return new RoleDto(role.getAuthority());
    }

    public static List<RoleDto> RolesToRolesDtos(List<Role> roles){
        List<RoleDto> result = new ArrayList<>();
        for (int i = 0; i < roles.size(); i++) {
            result.add(RoleToRoleDto(roles.get(i)));
        }
        return result;
    }
}
