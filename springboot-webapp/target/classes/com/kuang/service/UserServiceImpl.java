package com.kuang.service;

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
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User queryUserById(int id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public User queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }
}
