package edu.cmk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import edu.cmk.entity.Products;
import edu.cmk.mapper.ProductsMapper;
import edu.cmk.service.ProductsService;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products> implements ProductsService {

}




