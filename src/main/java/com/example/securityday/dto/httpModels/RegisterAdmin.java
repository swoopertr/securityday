package com.example.securityday.dto.httpModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterAdmin {
    private String email;
    private String fullname;
    private String password;
}
