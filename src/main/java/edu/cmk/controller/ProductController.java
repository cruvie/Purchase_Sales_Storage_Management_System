package edu.cmk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.cmk.entity.Product;
import edu.cmk.entity.Product;
import edu.cmk.service.ProductService;
import edu.cmk.service.UserService;
import edu.cmk.utils.LayuiJsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @ResponseBody
    @RequestMapping(value = "/productlist")
    public LayuiJsonResult<Product> getAll(String sel_name) {
        List<Product> productList;
        if (sel_name != null) {
            System.out.println(sel_name);
            QueryWrapper<Product> productQueryWrapper = new QueryWrapper<>();
            productQueryWrapper.like("productName", sel_name);
            productList = productService.list(productQueryWrapper);
        } else {
            productList = productService.list();
        }
        return new LayuiJsonResult<>(productList, productList.size());
    }

    @ResponseBody
    @RequestMapping(value = "/productaddedit")
    public Product productaddedit(Product product) {

        System.out.println(product);
        Boolean i = false;

        if (product.getId() == null) {
            i = productService.save(product);
        } else {
            i = productService.updateById(product);
        }
        if (i) {//前台使用ajax必须返回严格的json格式才会进入ajax的success
            return product;
        }
        return null;
    }
    
    @ResponseBody
    @RequestMapping(value = "/productdelete")
    public List<Product> productdelete(String products) {
        System.out.println(products);

        //转换字符串为Java对象集合(ArrayList存储)
        ArrayList<Product> productList = new ArrayList<>();
        JSONArray platformArray = JSON.parseArray(products);
        for (Object jsonObject : platformArray) {
            Product product = JSONObject.parseObject(jsonObject.toString(), Product.class);
            productList.add(product);
            System.out.println(product);
        }

        Boolean de = false;
        for (Product product : productList) {
            de = productService.removeById(product.getId());
        }

        if (de) {//前台使用ajax必须返回严格的json格式才会进入ajax的success
            return productList;
        }
        return null;
    }
}
