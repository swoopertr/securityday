package com.example.securityday.service;

import com.example.securityday.entity.ApplicationUser;

public interface IAuthenticationService {
    ApplicationUser registerUser(String fullname, String email, String password);
}
