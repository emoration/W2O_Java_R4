package com.kuang.controller;

import com.kuang.dto.login.LoginReq;
import com.kuang.dto.login.LoginResData;
import com.kuang.dto.register.RegisterReq;
import com.kuang.dto.GeneralRes;
import com.kuang.dto.register.RegisterResData;
import com.kuang.pojo.User;
import com.kuang.service.UserService;
import com.kuang.util.JasyptUtils;
import com.kuang.util.JwtUtil;
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
//        sout
        System.err.println("register parm:" + registerReq);
        String username = registerReq.getUsername();
        String password = registerReq.getPassword();
        String checkPassword = registerReq.getCheckPassword();

        if (!password.equals(checkPassword)) {
            System.err.println("passwordNoEqual");
            return GeneralRes.BadRes403("passwordNoEqual","passwordNoEqual");
        }
        if (userService.queryUserByName(username) != null) {
            System.err.println("userExisted");
            return GeneralRes.BadRes403("userExisted","userExisted");
        }

        userService.addUser(new User(0, username, JasyptUtils.encrypt(password)));
        User user = userService.queryUserByName(username);

        RegisterResData registerResData = new RegisterResData(user.getId(), user.getUsername());

        return GeneralRes.GoodRes200(registerResData);
    }

    @RequestMapping(value="/user/login")
    @ResponseBody
    public GeneralRes login(@RequestBody LoginReq loginReq) {

        String username = loginReq.getUsername();
        String password = loginReq.getPassword();

        User user = userService.queryUserByName(username);
        if (user == null) {
            System.err.println("userNoExist");
            return GeneralRes.BadRes403("userNoExist","userNoExist");
        }
        if (!JasyptUtils.checkCrypt(password,user.getPassword())) {
            System.err.println("passwordNoCorrect");
            return GeneralRes.BadRes403("passwordNoCorrect","passwordNoCorrect");
        }

        LoginResData loginResData = new LoginResData(user.getId(), user.getUsername(), JwtUtil.sign(user.getId(), user.getUsername()));

        return GeneralRes.GoodRes200(loginResData);
    }

}