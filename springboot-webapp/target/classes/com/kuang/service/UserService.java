package com.kuang.service;

import com.kuang.pojo.User;

public interface UserService {

    int addUser(User user);
    User queryUserById(int id);

    User queryUserByName(String username);
}
