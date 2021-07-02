package edu.cmk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.cmk.entity.AssemblePSU;
import edu.cmk.entity.Sale;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Entity .entity.Sale
 */
@Repository
public interface SaleMapper extends BaseMapper<Sale> {
    List<AssemblePSU> getAssembled();

    AssemblePSU getAssembledOneById(Integer id);

    List<AssemblePSU> getAssembledOneByName(String name);//一条数据也用list方便后续统一操作
}




