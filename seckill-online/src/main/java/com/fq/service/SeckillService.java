package com.fq.service;

/**
 * @title : seckill-online
 * @description: 秒杀业务
 * @author: 番茄很忙
 * @date: 2017/12/28 10:31
 * @version: 1.0
 */
public interface SeckillService {

    /**
     * @description: 提交订单
     * @author: 番茄很忙
     * @param
     * @return
     * @date:2017/12/28 10:49
     */
    public boolean saveGoods();

    /**
     * @description: 取消订单
     * @author: 番茄很忙
     * @param
     * @return
     * @date:2017/12/28 10:55
     */
    public boolean cancelGoods();

}
