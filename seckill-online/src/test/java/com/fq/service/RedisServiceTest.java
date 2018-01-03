package com.fq.service;

import com.common.utils.JSONHelper;
import com.common.utils.ResultJson;
import com.fq.SpringBaseTest;
import com.fq.model.CodeImage;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

/**
 * @title : seckill-online
 * @description:
 * @author: 番茄很忙
 * @date: 2017/12/29 15:12
 * @version: 1.0
 */
public class RedisServiceTest extends SpringBaseTest {

    @Autowired
    RedisService redisService;

    @Test
    public void saveIdenCode() throws Exception {

        ExecutorService es = Executors.newFixedThreadPool(3);
        long s = System.currentTimeMillis();
        //模拟10000个线程
        for(int i=0;i<10;i++){

            final int index = i;

            es.execute(new Runnable() {
                @Override
                public void run() {
                    //每个线程添加1000条数据
                        CodeImage ci = new CodeImage();
                        ci.setMenberId(index);
                        ci.setCode("cB23"+index);
                        ci.setTimeStamp(System.currentTimeMillis());
                        ResultJson<Integer> rs = redisService.saveIdenCode(ci);
                        System.out.println(JSONHelper.toString(rs));
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            });

            Thread.sleep(2000);
        }
        long e = System.currentTimeMillis();
        System.out.println("花费时间："+(e-s)/1000);


    }

}