package com.fq.service;

import com.common.utils.ResultJson;

/**
 * @title : seckill-online
 * @description:
 * @author: 番茄很忙
 * @date: 2018/1/4 10:51
 * @version: 1.0
 */
public interface StockService {

    /**
     * 将mysql库存初始化到redis库存,秒杀活动开始前
     * @return
     */
    public ResultJson<Integer> initStock();

    /**
     * 将redis 库存同步到mysql中，秒杀活动结束后
     * @return
     */
    public ResultJson<Integer> syncStock();
}
