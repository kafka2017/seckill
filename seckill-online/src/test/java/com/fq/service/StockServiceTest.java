package com.fq.service;

import com.common.utils.JSONHelper;
import com.common.utils.ResultJson;
import com.fq.SpringBaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @title : seckill-online
 * @description:
 * @author: 番茄很忙
 * @date: 2018/1/4 10:56
 * @version: 1.0
 */
public class StockServiceTest extends SpringBaseTest{

    @Autowired
    private StockService stockService;

    @Test
    public void initStock() throws Exception {
        ResultJson<Integer> rs = stockService.initStock();
        System.out.println(JSONHelper.toString(rs));
    }

    @Test
    public void syncStock() throws Exception{
        ResultJson<Integer> rs = stockService.syncStock();
        System.out.println();
    }

}