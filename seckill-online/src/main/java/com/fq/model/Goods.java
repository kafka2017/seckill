package com.fq.model;

import java.io.Serializable;

/**
 * @title : seckill-online
 * @description:
 * @author: 番茄很忙
 * @date: 2017/12/29 17:47
 * @version: 1.0
 */
public class Goods implements Serializable {

    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单号
     */
    private Integer productId;

    /**
     * 会员id
     */
    private Integer memberId;

    /**
     * 订单价格
     */
    private Double goodsPrice;

    /**
     * 数量
     */
    private Integer gNum;

    /**
     * 创建时间
     */
    private String createOn;

    /**
     * 访问者ip
     */
    private String ip;

    /**
     * 当前时间戳
     */
    private Long timeStamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getgNum() {
        return gNum;
    }

    public void setgNum(Integer gNum) {
        this.gNum = gNum;
    }

    public String getCreateOn() {
        return createOn;
    }

    public void setCreateOn(String createOn) {
        this.createOn = createOn;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
