import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.cmk.entity.AssemblePSU;
import edu.cmk.entity.User;
import edu.cmk.service.SaleService;
import edu.cmk.service.UserService;
import edu.cmk.utils.LayuiJsonResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class testsale {
    @Autowired
    private SaleService saleService;


    @Test
    public void login() {

        List<AssemblePSU> saleList = saleService.getAssembled();
        System.out.println(saleList);


    }
}
