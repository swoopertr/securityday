package com.example.securityday.service.impl;

import com.example.securityday.dto.RoleDto;
import com.example.securityday.entity.Role;
import com.example.securityday.mapper.RoleMapper;
import com.example.securityday.repository.IRoleRepository;
import com.example.securityday.service.IRoleService;
import com.example.securityday.service.cache.IRoleCacheService;
import com.example.securityday.util.CacheHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    private IRoleRepository roleRepository;
    private IRoleCacheService roleCacheService;

    @Autowired
    public RoleServiceImpl(IRoleRepository roleRepository, IRoleCacheService roleService) {
        this.roleRepository = roleRepository;
        this.roleCacheService = roleService;
    }

    @Override
    public List<RoleDto> getAll() {
        //in-memory cache
//        if(!CacheHelper.roleDtos.isEmpty()){
//            return CacheHelper.roleDtos;
//        }
//
//        List<Role> rolesList = roleRepository.findAll();
//        CacheHelper.roleDtos.addAll(RoleMapper.RolesToRolesDtos(rolesList));
//        return CacheHelper.roleDtos;

        //redis cache
        //todo: 1. get all related data from cache
        List<RoleDto> roleCacheDtoList = roleCacheService.getAll();
        if (roleCacheDtoList.size() > 0){
            return roleCacheDtoList;
        }


        List<Role> roles = roleRepository.findAll();
        //todo: 2. insert into cache
        for (int i = 0; i < roles.size(); i++) {
            Role roleEntity = roles.get(i);
            com.example.securityday.entity.cache.Role roleCache = RoleMapper.RoleToRoleCache(roleEntity);
            roleCacheService.insert(roleCache);
        }

        return RoleMapper.RolesToRolesDtos(roles);
    }
}
