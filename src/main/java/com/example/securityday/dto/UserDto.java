package com.example.securityday.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String full_name;

    private String email;

    private List<RoleDto> roleDtos;
}
