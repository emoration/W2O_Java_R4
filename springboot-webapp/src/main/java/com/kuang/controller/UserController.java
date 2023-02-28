package com.kuang.controller;

import com.kuang.dto.login.LoginReq;
import com.kuang.dto.login.LoginResData;
import com.kuang.dto.register.RegisterReq;
import com.kuang.dto.response.GeneralRes;
import com.kuang.dto.register.RegisterResData;
import com.kuang.pojo.User;
import com.kuang.service.UserService;
import com.kuang.utils.Secret;
import com.kuang.utils.Token;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;


    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        System.err.println("hello");
        return "hello";
    }

    @RequestMapping(value = "/user")
    @ResponseBody
    public GeneralRes register(@RequestBody RegisterReq registerReq) {
        GeneralRes res = new GeneralRes(200, "success", null, "");
//        sout
        System.err.println("register parm:" + registerReq);
        String username = registerReq.getUsername();
        String password = registerReq.getPassword();
        String checkPassword = registerReq.getCheckPassword();

        if (!password.equals(checkPassword)) {
            System.err.println("passwordNoEqual");
            res.setError("passwordNoEqual");
            return res;
        }
        if (userService.queryUserByName(username) != null) {
            System.err.println("userExisted");
            res.setError("userExisted");
            return res;
        }

        userService.addUser(new User(0, username, Secret.makeSecret(password)));

        User user = userService.queryUserByName(username);

        res.setData(new RegisterResData(user.getId(), user.getUsername()));

        return res;
    }

    @RequestMapping(value="/user/login")
    @ResponseBody
    public GeneralRes login(@RequestBody LoginReq loginReq) {
        GeneralRes res = new GeneralRes(200, "success", null, "");

//        sout
        System.err.println(loginReq);
        String username = loginReq.getUsername();
        String password = loginReq.getPassword();

        User user = userService.queryUserByName(username);
        if (user == null) {
            System.err.println("userNoExist");
            res.setError("userNoExist");
            return res;
        }
        if (!Secret.checkSecret(password,user.getPassword())) {
            System.err.println("passwordNoCorrect");
            res.setError("passwordNoCorrect");
            return res;
        }

        res.setData(new LoginResData(user.getId(), user.getUsername(),Token.makeToken(username)));

        return res;
    }

}