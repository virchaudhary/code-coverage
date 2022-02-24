package com.example.codecoverage.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public List<String> getAllUsers() {
        return List.of("ram", "shyam");
    }

    public String getById(int id) {
        return "user" + id;
    }
}
