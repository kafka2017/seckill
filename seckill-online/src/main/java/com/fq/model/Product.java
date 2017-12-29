package com.fq.model;

import java.io.Serializable;

/**
 * @title : seckill-online
 * @description: 商品信息
 * @author: 番茄很忙
 * @date: 2017/12/29 17:42
 * @version: 1.0
 */
public class Product implements Serializable {

    private Integer id;

    /**
     * 商品编码
     */
    private String pCode;

    /**
     * 商品名称
     */
    private String pName;

    /**
     * 商品价格
     */
    private Double pPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Double getpPrice() {
        return pPrice;
    }

    public void setpPrice(Double pPrice) {
        this.pPrice = pPrice;
    }
}
