package com.kuang.service;

import com.kuang.mapper.UserMapper;
import com.kuang.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    void addUser() {
        User user = new User(0, "admi4n", "123456");
        userService.addUser(user);
    }

    @Test
    void getUserById() {
        System.out.println(userService.queryUserById(1));
    }
}