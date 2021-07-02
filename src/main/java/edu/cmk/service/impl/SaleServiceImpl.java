package edu.cmk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import edu.cmk.entity.AssemblePSU;
import edu.cmk.entity.Sale;
import edu.cmk.mapper.SaleMapper;
import edu.cmk.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class SaleServiceImpl extends ServiceImpl<SaleMapper, Sale> implements SaleService {
    @Autowired
    SaleMapper saleMapper;

    @Override
    public List<AssemblePSU> getAssembled() {
        return saleMapper.getAssembled();
    }

    @Override
    public AssemblePSU getAssembledOneById(Integer id) {
        return saleMapper.getAssembledOneById(id);
    }

    @Override
    public List<AssemblePSU> getAssembledOneByName(String name) {
        return saleMapper.getAssembledOneByName(name);
    }
}




