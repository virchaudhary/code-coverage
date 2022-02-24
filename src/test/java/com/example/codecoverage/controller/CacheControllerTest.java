package com.example.codecoverage.controller;

import com.example.codecoverage.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CacheController.class)
class CacheControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    UserService userService;

    @Test
    void getUsers() throws Exception {
        Mockito.when(userService.getAllUsers()).thenReturn(List.of("ram","shyam", "me"));
        mvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$", hasItems("ram","shyam","me")));
        Mockito.verify(userService, times(1)).getAllUsers();
    }

    @Test
    void getUser() throws Exception {
        int userId = 1;
        Mockito.when(userService.getById(anyInt())).thenReturn("user");
        mvc.perform(get("/users/{userId}", userId))
                .andDo(print())
                .andExpect(status().isOk())
                        .andExpect(content().string("user"));
        Mockito.verify(userService, times(1)).getById(userId);
        Mockito.verify(userService, times(0)).getAllUsers();
    }
}