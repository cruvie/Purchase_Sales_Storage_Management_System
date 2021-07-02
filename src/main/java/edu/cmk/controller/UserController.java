package edu.cmk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.cmk.entity.User;
import edu.cmk.service.UserService;
import edu.cmk.utils.LayuiJsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/userlist")
    public LayuiJsonResult<User> getAll(String sel_name) {
        List<User> userList;
        if (sel_name != null) {
            System.out.println(sel_name);
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.like("realName", sel_name);
            userList = userService.list(userQueryWrapper);
        } else {
            userList = userService.list();
        }
        return new LayuiJsonResult<>(userList, userList.size());
    }

    @ResponseBody
    @RequestMapping(value = "/useraddedit")
    public User useraddedit(User user) {

        System.out.println(user);
        Boolean i = false;

        if (user.getId() == null) {
            i = userService.save(user);
        } else {
            i = userService.updateById(user);
        }
        if (i) {//前台使用ajax必须返回严格的json格式才会进入ajax的success
            return user;
        }
        return null;
    }

    /* @ResponseBody
     @RequestMapping(value = "/userdelete")
     public List<User> userdelete(List<User> userList) {
         System.out.println(userList);

         Boolean de = false;
         for (User user : userList) {
             de = userService.removeById(user.getId());
         }

         if (de) {//前台使用ajax必须返回严格的json格式才会进入ajax的success
             return userList;
         }
         return null;
     }   */
    @ResponseBody
    @RequestMapping(value = "/userdelete")
    public List<User> userdelete(String users) {
        System.out.println(users);

        //转换字符串为Java对象集合(ArrayList存储)
        ArrayList<User> userList = new ArrayList<>();
        JSONArray platformArray = JSON.parseArray(users);
        for (Object jsonObject : platformArray) {
            User user = JSONObject.parseObject(jsonObject.toString(), User.class);
            userList.add(user);
            System.out.println(user);
        }

        Boolean de = false;
        for (User user : userList) {
            de = userService.removeById(user.getId());
        }

        if (de) {//前台使用ajax必须返回严格的json格式才会进入ajax的success
            return userList;
        }
        return null;
    }
}
