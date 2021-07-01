package edu.cmk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import edu.cmk.entity.Product;
import edu.cmk.mapper.ProductMapper;
import edu.cmk.service.ProductService;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}




