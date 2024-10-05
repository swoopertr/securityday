package com.example.securityday.controller;

import com.example.securityday.dto.RoleDto;
import com.example.securityday.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class roleController {

    private IRoleService roleService;

    @Autowired
    public roleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping({"","/"})
    public String ok(){
        return "roles";
    }

    @GetMapping("/all")
    public List<RoleDto> getAll(){
        return roleService.getAll();
    }
}
