package com.fq.service.impl;

import com.common.enumUtil.CodeEnum;
import com.common.utils.ResultJson;
import com.fq.model.CodeImage;
import com.fq.service.RedisService;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

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
    public ResultJson<Integer> saveIdenCode(CodeImage codeImage) {

        if(codeImage==null){
            return ResultJson.failed();
        }

        //验证
        Validator validator = new Validator();
        List<ConstraintViolation> ret = validator.validate(codeImage);
        if(!ret.isEmpty()){
            return ResultJson.failed(CodeEnum.error.code(), ret.get(0).getMessage());
        }

        HashOperations<Object,Object,Object> hashOperations = redisTemplate.opsForHash();

        //key : codeImage_会员Id
        String key = "codeImage_"+codeImage.getMenberId();

//        if(hashOperations.get(key,"timeStamp")!=null){
//
//            Long saveTie = Long.parseLong(hashOperations.get(key,"timeStamp")+"");
//            boolean flag = calTimeStamp(saveTie,codeImage.getTimeStamp());
//
//            if(!flag){
//                return ResultJson.failed(CodeEnum.often.code(),CodeEnum.often.msg());
//            }
//        }

        hashOperations.put(key,"memberId",codeImage.getMenberId()+"");//会员id
        hashOperations.put(key,"code",codeImage.getCode());//验证码
        hashOperations.put(key,"timeStamp",codeImage.getTimeStamp()+"");//时间戳
        Long pageView = hashOperations.increment(key,"pageView",1);//访问量

        if(pageView>0){
            return ResultJson.success();
        }
        return ResultJson.failed();
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
