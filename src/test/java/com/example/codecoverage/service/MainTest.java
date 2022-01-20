package com.example.codecoverage.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MainTest {

    @Autowired
    private Main main;

    @Test
    public void testMainClass() {
        main.test();
    }

}