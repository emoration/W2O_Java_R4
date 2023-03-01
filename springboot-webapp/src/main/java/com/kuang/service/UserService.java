package com.kuang.service;

import com.kuang.exception.SqlException;
import com.kuang.pojo.User;

public interface UserService {

    int addUser(User user)throws SqlException;
    User queryUserById(int id)throws SqlException;

    User queryUserByName(String username)throws SqlException;
}
