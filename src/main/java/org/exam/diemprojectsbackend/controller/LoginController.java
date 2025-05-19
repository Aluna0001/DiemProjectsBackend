package org.exam.diemprojectsbackend.controller;

import org.exam.diemprojectsbackend.service.LoginService;
import org.exam.diemprojectsbackend.model.LoginRequest;
import org.exam.diemprojectsbackend.model.LoginResponse;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        // Authentication to the service layer
        return loginService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
    }
}