package edu.cmk.service;


import com.baomidou.mybatisplus.extension.service.IService;
import edu.cmk.entity.AssemblePSU;
import edu.cmk.entity.Sale;

import java.util.List;

/**
 *
 */
public interface SaleService extends IService<Sale> {
    List<AssemblePSU> getAssembled();

    AssemblePSU getAssembledOneById(Integer id);

    List<AssemblePSU> getAssembledOneByName(String name);//一条数据也用list方便后续统一操作
}
