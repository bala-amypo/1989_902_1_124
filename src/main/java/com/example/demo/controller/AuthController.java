package com.example.demo.controller;

//import com.example.demo.dto.*;
import com.example.demo.entity.UserAccount;
import com.example.demo.exception.UnauthorizedException;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userAccountService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserAccountService userAccountService,
                          AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil) {
        this.userAccountService = userAccountService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public JwtResponse register(@RequestBody RegisterRequest request) {
        UserAccount user = new UserAccount(
                null,
                request.fullName,
                request.email,
                request.password,
                request.role
        );

        UserAccount saved = userAccountService.register(user);
        String token = jwtUtil.generateToken(
                saved.getId(),
                saved.getEmail(),
                saved.getRole()
        );

        return new JwtResponse(token, saved.getId(), saved.getEmail(), saved.getRole());
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.email, request.password
                    )
            );
        } catch (Exception e) {
            throw new UnauthorizedException("Invalid credentials");
        }

        UserAccount user = userAccountService.findByEmailOrThrow(request.email);
        String token = jwtUtil.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return new JwtResponse(token, user.getId(), user.getEmail(), user.getRole());
    }
}
