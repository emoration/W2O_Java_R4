package com.kuang.service;

import com.kuang.mapper.UserMapper;
import com.kuang.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class UserServiceImplTest {

//    @Autowired
//    UserServiceImpl userService;
//
//    @Test
//    void addUser() {
//        userService = new UserServiceImpl();
//        userService.setUserMapper(new UserMapper() {
//            @Override
//            public int addUser(User user) {
//                return 0;
//            }
//
//            @Override
//            public User queryUserById(int id) {
//                return null;
//            }
//        });
//        User user = new User(0, "admin", "123456");
//        userService.addUser(user);
//    }
//
//    @Test
//    void getUserById() {
//        System.out.println(userService.queryUserById(1));
//    }
}