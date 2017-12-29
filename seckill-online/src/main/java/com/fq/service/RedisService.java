package com.fq.service;

import java.util.Map;

/**
 * @title : seckill-online
 * @description:
 * @author: 番茄很忙
 * @date: 2017/12/28 10:32
 * @version: 1.0
 */
public interface RedisService {

    /**
     * @description: 保存用户验证码
     * @author: 番茄很忙
     * @param
     * @return
     * @date:2017/12/28 10:48
     */
    public void saveIdenCode(Map<String,String> map);

}
