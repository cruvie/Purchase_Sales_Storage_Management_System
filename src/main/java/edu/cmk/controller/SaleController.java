package edu.cmk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.cmk.entity.*;
import edu.cmk.entity.Sale;
import edu.cmk.service.ProductService;
import edu.cmk.service.SaleService;
import edu.cmk.service.UserService;
import edu.cmk.utils.LayuiJsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SaleController {
    @Autowired
    private SaleService saleService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @ResponseBody
    @RequestMapping(value = "/salelist")
    public LayuiJsonResult<AssemblePSU> getAll(String sel_name) {
        List<AssemblePSU> assemblePSUS = new ArrayList<>();

        if (sel_name != null) {

            System.out.println(sel_name);
            assemblePSUS.addAll(saleService.getAssembledOneByName(sel_name));

        } else {
            assemblePSUS = saleService.getAssembled();
        }
        return new LayuiJsonResult<AssemblePSU>(assemblePSUS, assemblePSUS.size());
    }

    @ResponseBody
    @RequestMapping(value = "/saleaddedit")
    public Sale saleaddedit(Sale sale) {

        System.out.println(sale);
        //通过productid查询单价
        Product product = productService.getById(sale.getProductid());
        //计算总价
        sale.setTotalprice(product.getPrice().multiply(new BigDecimal(sale.getCount())));
        //库存减少
        product.setQuantity(product.getQuantity() - sale.getCount());
        productService.updateById(product);

        System.out.println(sale);

        Boolean i = false;

        if (sale.getId() == null) {
            i = saleService.save(sale);
        } else {
            i = saleService.updateById(sale);
        }
        if (i) {//前台使用ajax必须返回严格的json格式才会进入ajax的success
            return sale;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/saledelete")
    public List<AssemblePSU> saledelete(String sales) {
        System.out.println(sales);

        //转换字符串为Java对象集合(ArrayList存储)
        ArrayList<AssemblePSU> assemblePSUArrayList = new ArrayList<>();
        JSONArray platformArray = JSON.parseArray(sales);
        for (Object jsonObject : platformArray) {
            AssemblePSU assemblePSU = JSONObject.parseObject(jsonObject.toString(), AssemblePSU.class);
            assemblePSUArrayList.add(assemblePSU);
            System.out.println(assemblePSU);
        }

        Boolean de = false;
        for (AssemblePSU assemblePSU : assemblePSUArrayList) {
            de = saleService.removeById(assemblePSU.getSale().getId());
        }

        if (de) {//前台使用ajax必须返回严格的json格式才会进入ajax的success
            return assemblePSUArrayList;
        }
        return null;
    }
}
