package edu.cmk.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 
 * @TableName sale
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

@Component
@TableName(value ="sale")
public class Sale implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer count;

    /**
     * 
     */
    private BigDecimal totalprice;

    /**
     * 
     */
    private String saledate;

    /**
     * 
     */
    private Integer userid;

    /**
     * 
     */
    private Integer productid;

}