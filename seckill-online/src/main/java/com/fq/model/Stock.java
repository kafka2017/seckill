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

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 仓库id
     */
    private Integer depotId;

    /**
     * 总价格
     */
    private Double sPrice;

    /**
     * 总库存
     */
    private Integer sNum;

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

    public Integer getDepotId() {
        return depotId;
    }

    public void setDepotId(Integer depotId) {
        this.depotId = depotId;
    }

    public Double getsPrice() {
        return sPrice;
    }

    public void setsPrice(Double sPrice) {
        this.sPrice = sPrice;
    }

    public Integer getsNum() {
        return sNum;
    }

    public void setsNum(Integer sNum) {
        this.sNum = sNum;
    }
}
