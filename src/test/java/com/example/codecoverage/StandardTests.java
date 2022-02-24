package com.example.codecoverage;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class StandardTests {

    @BeforeAll
    static void initAll() {
        System.out.println("before class");
    }

    @BeforeEach
    void init() {
        System.out.println("before method");
    }

    @Test
    @DisplayName("Custom test name containing spaces")
    void succeedingTest() {
        int max = Integer.MAX_VALUE;
        long sum = (Long.valueOf(max) +  Long.valueOf(max) )/1;
        System.out.println("sum = " + sum);
    }

    @Test
    @Disabled("Disabled until bug #42 has been resolved")
    void failingTest() {
        fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }

    @Test
    void abortedTest() {
        assumeTrue("abc".contains("Z"));
        fail("test should have been aborted");
    }

    @AfterEach
    void tearDown() {
        System.out.println("after test method");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("after class");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "dev")
    void onlyOnStagingServer() {
        System.out.println("running only when ENV is dev");
    }


    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Repeat!")
    void customDisplayName(TestInfo testInfo) {
        assertEquals("Repeat! 1/10", testInfo.getDisplayName());
    }

}