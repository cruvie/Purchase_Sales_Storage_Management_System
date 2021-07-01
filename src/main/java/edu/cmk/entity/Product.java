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
 * @TableName products
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@TableName(value ="products")
public class Product implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String productname;

    /**
     * 
     */
    private String quantity;

    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private BigDecimal price;

}