package com.example.securityday.service.cache.impl;

import com.example.securityday.dto.RoleDto;
import com.example.securityday.entity.cache.Role;
import com.example.securityday.mapper.cache.RoleCacheMapper;
import com.example.securityday.repository.cache.IRoleCacheRepository;
import com.example.securityday.service.cache.IRoleCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleCacheServiceImpl implements IRoleCacheService {

    private IRoleCacheRepository roleCacheRepository;

    @Autowired
    public RoleCacheServiceImpl(IRoleCacheRepository roleCacheRepository) {
        this.roleCacheRepository = roleCacheRepository;
    }

    @Override
    public List<RoleDto> getAll() {
        List<Role> roles = (List<Role>) roleCacheRepository.findAll();
        List<RoleDto> roleDtos = RoleCacheMapper.RoleCacheListToRoleDtos(roles);
        return roleDtos;
    }

    @Override
    public RoleDto insert(Role role) {
        Role saved = roleCacheRepository.save(role);
        return RoleCacheMapper.RoleCacheToRoleDto(saved);
    }
}
