package com.fq.service.impl;

import com.common.enumUtil.CodeEnum;
import com.common.utils.ResultJson;
import com.fq.model.Goods;
import com.fq.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @title : seckill-online
 * @description:
 * @author: 番茄很忙
 * @date: 2018/1/3 10:26
 * @version: 1.0
 */
@Service(value="seckillService")
public class SeckillServiceImpl implements SeckillService {

    @Autowired
    private RedisTemplate redisTemplate;

    private static AtomicLong atomicLong = new AtomicLong(0);

    //限制请求次数
    private static Integer limitCount = 10;

    /**
     * 请求总数
     * @return
     */
    public static long requestCount(){
        return atomicLong.incrementAndGet();
    }


    @Override
    public ResultJson<Integer> saveGoods(Goods goods) {

        if (goods == null) {
            return ResultJson.failed();
        }

        long reCount = requestCount();

        if(reCount>=limitCount){
            return ResultJson.failed(CodeEnum.snatched_out.code(),CodeEnum.snatched_out.msg());
        }

        HashOperations<Object,Object,Object> m =  redisTemplate.opsForHash();

        //用户请求
        String key = "userRequest_"+goods.getMemberId();
        //黑名单
        String blacklistKey = "blacklist_"+goods.getMemberId();

        if(m.get(key,"ip")!=null && m.get(key,"timeStamp")!=null && m.get(key,"pageView")!=null){
            String ip = m.get(key,"ip").toString();
            Long timeStamp = Long.parseLong(m.get(key,"timeStamp")+"");
            Integer pageView = Integer.parseInt(m.get(key,"pageView")+"");
            Long curTime = System.currentTimeMillis();
            //请求频繁60秒
            boolean flag = calTimeStamp(timeStamp,curTime);

            //同一个ip，请求频繁60秒，并且请求大于10次
            if((ip.equals(goods.getIp())) && (flag) && (pageView > 10)){

                m.put(blacklistKey,"memberId",goods.getMemberId()+"");
                m.put(blacklistKey,"ip",goods.getIp());
                m.put(blacklistKey,"timeStamp",goods.getTimeStamp()+"");
            }
        }

        //黑名单查询
        if(m.get(blacklistKey,"memberId")!=null){
            return ResultJson.failed(CodeEnum.black_user.code(),CodeEnum.black_user.msg());
        }
        //添加请求数
        m.put(key,"memberId",goods.getMemberId()+"");
        m.put(key,"ip",goods.getIp());
        m.put(key,"timeStamp",goods.getTimeStamp()+"");
        Long l = m.increment(key,"pageView",1);





        if(l>0){
            return ResultJson.success();
        }
        return ResultJson.failed();
    }

    @Override
    public ResultJson<Integer> cancelGoods() {
        return null;
    }


    /**
     * @description: 判断请求频繁时间范围
     * @author: 番茄很忙
     * @param
     * @return
     * @date:2018/1/2 15:24
     */
    private boolean calTimeStamp(Long savetime,Long curtime){
        //60毫秒
        Long maxTime = 60000L;
        if(savetime==null || curtime==null){
            return false;
        }

        Long cut = curtime-savetime;
        if(cut<maxTime){
            return false;
        }
        return true;
    }
}
