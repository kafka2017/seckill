package com.fq.service;

import com.common.utils.JSONHelper;
import com.common.utils.ResultJson;
import com.fq.SpringBaseTest;
import com.fq.model.Goods;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @title : seckill-online
 * @description:
 * @author: 番茄很忙
 * @date: 2018/1/3 15:14
 * @version: 1.0
 */

public class SeckillServiceTest extends SpringBaseTest{

    @Autowired
    private SeckillService seckillService;

    @Test
    public void saveGoods() throws  Exception{
        //for(int i=0;i<10;i++){
            Goods goods = new Goods();
            goods.setIp("127.0.0.1");
            goods.setgNum(1);
            goods.setMemberId(2);
            goods.setOrderNo("ABC123456");
            goods.setGoodsPrice(123.0);
            goods.setTimeStamp(System.currentTimeMillis());
            ResultJson<Integer> rs = seckillService.saveGoods(goods);
            System.out.println(JSONHelper.toString(rs));
       // }

    }


}