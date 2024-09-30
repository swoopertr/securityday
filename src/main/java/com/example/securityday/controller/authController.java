package com.example.securityday.controller;


import com.example.securityday.dto.UserDto;
import com.example.securityday.dto.httpModels.RegisterAdmin;
import com.example.securityday.entity.ApplicationUser;
import com.example.securityday.mapper.UserMapper;
import com.example.securityday.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class authController {

    private IAuthenticationService authenticationService;

    @Autowired
    public authController(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping({"","/"})
    public String ok(){
        return "ok";
    }

    @PostMapping("/registeradmin")
    public UserDto registerAdmin(@RequestBody RegisterAdmin registerAdmin){
        ApplicationUser applicationUser = authenticationService.registerUser(
                registerAdmin.getFullname(),
                registerAdmin.getEmail(),
                registerAdmin.getPassword()
        );
        System.out.println("register");


        return UserMapper.UserToUserDto(applicationUser);
    }

}
