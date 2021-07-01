package edu.cmk.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.cmk.entity.User;
import edu.cmk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login")
    public User login(@RequestParam("username") String username,
                      @RequestParam("password") String password) {

        QueryWrapper<User> usersQueryWrapper = new QueryWrapper<>();
        //指定条件,key为表字段
        usersQueryWrapper.eq("username", username);
        usersQueryWrapper.eq("password", password);
        //返回的结果最多1条，返回多条记录会报错
        User user = userService.getOne(usersQueryWrapper);
        //System.out.println(users);

        return user;

    }
}
