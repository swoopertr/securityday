package com.example.securityday.service.impl;

import com.example.securityday.entity.ApplicationUser;
import com.example.securityday.entity.Role;
import com.example.securityday.repository.IRoleRepository;
import com.example.securityday.repository.IUserRepository;
import com.example.securityday.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    private PasswordEncoder passwordEncoder;
    private IRoleRepository roleRepository;
    private IUserRepository userRepository;

    @Autowired
    public AuthenticationServiceImpl(PasswordEncoder passwordEncoder,
                                     IRoleRepository roleRepository,
                                     IUserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ApplicationUser registerUser(String fullname, String email, String password) {
        String encodedPassword = passwordEncoder.encode(password);

        Role userRole = roleRepository.getAuthorityByName("ADMIN");

        ApplicationUser user = new ApplicationUser();
        user.setFull_name(fullname);
        user.setEmail(email);
        user.setPassword(encodedPassword);
        List<Role> tmp  = new ArrayList<>();
        tmp.add(userRole);
        user.setRoles(tmp);

        return userRepository.save(user);
    }
}
