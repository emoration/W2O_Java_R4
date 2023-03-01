package com.kuang.service;

import com.kuang.exception.SqlException;
import com.kuang.pojo.User;
import com.kuang.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) throws SqlException {
        try {
            queryUserByName(user.getUsername());
        } catch (SqlException e) {
            return userMapper.addUser(user);
        }
        throw new SqlException("add user existed");
    }

    @Override
    public User queryUserById(int id) throws SqlException {
        User user = userMapper.queryUserById(id);
        if (user == null) {
            throw new SqlException("query user not found");
        }
        return user;
    }

    @Override
    public User queryUserByName(String username) throws SqlException {
        User user = userMapper.queryUserByName(username);
        if (user == null) {
            throw new SqlException("query user not found");
        }
        return user;
    }
}
