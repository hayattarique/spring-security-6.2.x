package org.boot.controller;

import lombok.RequiredArgsConstructor;
import org.boot.entities.User;
import org.boot.security.beans.service.UserDetailsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserDetailsServiceImpl userDetailsService;

    @GetMapping
    public ResponseEntity<String> getProduct() {
        String message = "Hello this is TATA Product";
        return ResponseEntity.ok(message);
    }
}
