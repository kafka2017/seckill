package com.fq.service;

import com.common.utils.ResultJson;
import com.fq.model.Goods;

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
    public ResultJson<Integer> saveGoods(Goods goods);

    /**
     * @description: 取消订单
     * @author: 番茄很忙
     * @param
     * @return
     * @date:2017/12/28 10:55
     */
    public ResultJson<Integer> cancelGoods();

}
