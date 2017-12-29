package com.fq.model;

import java.io.Serializable;

/**
 * @title : seckill-online
 * @description: 库存信息
 * @author: 番茄很忙
 * @date: 2017/12/29 17:44
 * @version: 1.0
 */
public class Stock implements Serializable {

    private Integer id;

    private Integer productId;

    private Integer deportId;

    private Double sPrice;

    private Integer sSum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getDeportId() {
        return deportId;
    }

    public void setDeportId(Integer deportId) {
        this.deportId = deportId;
    }

    public Double getsPrice() {
        return sPrice;
    }

    public void setsPrice(Double sPrice) {
        this.sPrice = sPrice;
    }

    public Integer getsSum() {
        return sSum;
    }

    public void setsSum(Integer sSum) {
        this.sSum = sSum;
    }
}
