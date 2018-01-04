package com.fq.mapper;

import com.fq.model.Stock;

import java.util.List;

/**
 * @title : seckill-online
 * @description:
 * @author: 番茄很忙
 * @date: 2018/1/4 10:17
 * @version: 1.0
 */
public interface StockMapper {

    /**
     * 获取所有商品库存
     * @return
     */
    public List<Stock> queryStockall();
}
