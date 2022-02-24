package com.example.codecoverage.controller;


import com.example.codecoverage.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class CacheController {

    private final UserService userService;

    public CacheController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<String>> getUsers() {
        log.info("request with cache");
        var users = userService.getAllUsers();
        CacheControl cacheControl = CacheControl.maxAge(Duration.ofSeconds(10));
        cacheControl.cachePublic();
        return ResponseEntity.ok()
                .cacheControl(cacheControl)
                .body(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<String> getUser(@PathVariable("userId") int id) {
        log.info("request without cache");
        return ResponseEntity.ok(userService.getById(id));
    }


}
