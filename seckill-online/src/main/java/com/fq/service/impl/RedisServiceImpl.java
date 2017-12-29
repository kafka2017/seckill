package com.fq.service.impl;

import com.fq.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @title : seckill-online
 * @description:
 * @author: 番茄很忙
 * @date: 2017/12/29 10:59
 * @version: 1.0
 */
@Service(value="/redisService")
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void saveIdenCode(Map<String,String> map) {
        redisTemplate.opsForHash().putAll("hasOps",map);
    }
}
