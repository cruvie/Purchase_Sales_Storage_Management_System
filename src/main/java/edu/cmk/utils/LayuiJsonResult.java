package edu.cmk.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 定义layui的统一 JSON 结构
 *
 * @param <T>
 */
@Data

public class LayuiJsonResult<T> {


    private Integer code;
    private String msg;
    private Integer count;
    private List<T> data;

    /**
     * 若没有数据返回，默认状态码为 0，提示信息为“操作成功！”
     */
    public LayuiJsonResult() {
        this.code = 0;
        this.msg = "操作成功！";
        this.count = 0;
    }

    /**
     * 有数据返回，状态码为 0，人为指定提示信息
     *
     * @param data
     * @param msg
     */
    public LayuiJsonResult(List<T> data, Integer count) {
        this.code = 0;
        this.msg = "操作成功！";
        this.data = data;
        this.count = count;
    }

}
