package com.example.securityday.service.cache;

import com.example.securityday.dto.RoleDto;
import com.example.securityday.entity.cache.Role;

import java.util.List;

public interface IRoleCacheService {
    List<RoleDto> getAll();
    RoleDto insert(Role role);
}
