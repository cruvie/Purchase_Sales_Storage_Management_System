import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.cmk.entity.User;
import edu.cmk.service.UserService;
import edu.cmk.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class testlogin {
    @Autowired
    private UserService userService;

    @Test
    public void login() {

        QueryWrapper<User> usersQueryWrapper = new QueryWrapper<>();
        //指定条件,key为表字段
        usersQueryWrapper.eq("username", "admin");
        usersQueryWrapper.eq("password", "123456");
        //返回的结果最多1条，返回多条记录会报错
       // User user = userService.getOne(usersQueryWrapper);
        User user = userService.getById(1);
        System.out.println(user);


    }
}
