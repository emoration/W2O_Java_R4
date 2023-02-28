package com.kuang;

import com.kuang.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringbootWebappApplicationTest {


    @Autowired
    UserServiceImpl userService;
    @Test
    void doaTest() {
        System.err.println("test");
        System.err.println(userService.queryUserById(1));
    }
}