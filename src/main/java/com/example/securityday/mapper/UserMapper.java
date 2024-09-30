package com.example.securityday.mapper;

import com.example.securityday.dto.UserDto;
import com.example.securityday.entity.ApplicationUser;

import javax.security.auth.kerberos.KerberosTicket;

public class UserMapper {
    public static UserDto UserToUserDto(ApplicationUser user){
        return new UserDto(
                user.getFull_name(),
                user.getEmail(),
                RoleMapper.RolesToRolesDtos(user.getRoles())
        );
    }
}
