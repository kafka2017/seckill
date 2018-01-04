package com.fq.service.impl;

import com.common.utils.JSONHelper;
import com.common.utils.ResultJson;
import com.fq.mapper.StockMapper;
import com.fq.model.Stock;
import com.fq.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title : seckill-online
 * @description:
 * @author: 番茄很忙
 * @date: 2018/1/4 10:52
 * @version: 1.0
 */
@Service(value="/stockService")
public class StockServiceImpl implements StockService {

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    private final static String stockKey = "stock";


    @Override
    public ResultJson<Integer> initStock() {
        List<Stock> list = stockMapper.queryStockall();

        if(list!=null && list.size()>0){
            ListOperations<String,Object> listOperations = redisTemplate.opsForList();

            if(listOperations.size(stockKey)>0){
                redisTemplate.delete(stockKey);
            }
            Long l = listOperations.leftPush(stockKey,list);
            if(l>0){
                return ResultJson.success();
            }
        }
        return ResultJson.failed();
    }

    @Override
    public ResultJson<Integer> syncStock() {

        ListOperations<String,Object> listOperations = redisTemplate.opsForList();

        List<Object> list = listOperations.range(stockKey,0,-1);

        System.out.println(JSONHelper.toString(list));

        return null;
    }
}
