package org.exam.diemprojectsbackend.service;

import org.exam.diemprojectsbackend.model.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


    public LoginResponse authenticate(String username, String password) {
        if ("admin".equals(username) && "password".equals(password)) {
            return new LoginResponse(true, "Login successful", "dummy-token");
        } else {
            return new LoginResponse(false, "Invalid username or password");
        }
    }
}
