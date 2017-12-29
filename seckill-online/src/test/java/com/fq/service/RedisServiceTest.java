package com.fq.service;

import com.fq.SpringBaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

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
        Map<String,String> map = new HashMap<String,String>();
        map.put("memberid","1");
        map.put("visitors","200");
        redisService.saveIdenCode(map);
    }

}