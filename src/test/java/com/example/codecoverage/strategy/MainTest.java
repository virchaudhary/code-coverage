package com.example.codecoverage.strategy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MainTest {

    @Autowired
    private Main main;

    @Test
    public void testMainClass() {
        main.test();
    }

}