package com.fq.controller;

import com.common.utils.ImageCode;
import com.common.utils.IpUtils;
import com.common.utils.ResultJson;
import com.fq.model.Goods;
import com.fq.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * @title : seckill-online
 * @description:
 * @author: 番茄很忙
 * @date: 2017/12/28 14:10
 * @version: 1.0
 */

@RestController
public class SeckillController {

    @Autowired
    private SeckillService seckillService;

    /**
     * 提交订单
     * @param goods
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/saveGoods")
    public ResultJson<Integer> saveGoods(Goods goods,HttpServletRequest request) throws Exception {

        String ip = IpUtils.getIpAddr(request);
        goods.setIp(ip);
        goods.setTimeStamp(System.currentTimeMillis());
        ResultJson<Integer> rs = seckillService.saveGoods(goods);
        return rs;
    }

}
