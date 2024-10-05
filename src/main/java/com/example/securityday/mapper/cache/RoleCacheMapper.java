package com.example.securityday.mapper.cache;

import com.example.securityday.dto.RoleDto;
import com.example.securityday.entity.cache.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleCacheMapper {

    public static RoleDto RoleCacheToRoleDto(Role role){
        return new RoleDto(role.getAuthority());
    }

    public static List<RoleDto> RoleCacheListToRoleDtos(List<Role> roles){
        List<RoleDto> result = new ArrayList<>();
        for (int i = 0; i < roles.size(); i++) {
            result.add(RoleCacheToRoleDto(roles.get(i)));
        }
        return result;
    }

}
