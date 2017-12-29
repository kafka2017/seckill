package com.fq.controller;

import com.alibaba.druid.util.StringUtils;
import com.common.enumUtil.CodeEnum;
import com.common.utils.ImageCode;
import com.common.utils.ResultJson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;

/**
 * @title : seckill-online
 * @description:
 * @author: 番茄很忙
 * @date: 2017/12/28 15:21
 * @version: 1.0
 */
@RestController
@RequestMapping(value="/code")
public class CodeController {

    /**
     * @description: 生成验证码
     * @author: 番茄很忙
     * @param
     * @return
     * @date:2017/12/28 15:24
     */
    @RequestMapping(value="/createImageCode")
    public String createImageCode(Integer wImg, Integer hImg, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(wImg==null){
            wImg = 60;
        }
        if(hImg==null){
            hImg = 20;
        }
        OutputStream os = response.getOutputStream();
        Map<String,Object> map = ImageCode.getImageCode(wImg, hImg, os);
        String simpleCaptcha = "simpleCaptcha";
        request.getSession().setAttribute(simpleCaptcha, map.get("strEnsure").toString().toLowerCase());
        request.getSession().setAttribute("codeTime",System.currentTimeMillis());
        try {
            ImageIO.write((BufferedImage) map.get("image"), "JPEG", os);
        } catch (IOException e) {
            return "";
        }
        return null;
    }

    /**
     * @description: 验证验证码
     * @author: 番茄很忙
     * @param
     * @return
     * @date:2017/12/28 15:25
     */
    @RequestMapping(value="/checkImageCode")
    private ResultJson<Boolean> checkImageCode(HttpServletRequest request){
        String checkCode = request.getParameter("checkCode");
        HttpSession session = request.getSession();
        Object cko = session.getAttribute("simpleCaptcha") ; //验证码对象
        if(cko == null){
            return ResultJson.failed(CodeEnum.error.code(),"验证码不能为空");
        }
        String captcha = cko.toString();
        System.out.println("提交的验证码checkCode:"+checkCode);
        System.out.println("captcha:"+captcha);
        Date now = new Date();
        Long codeTime = Long.valueOf(session.getAttribute("codeTime")+"");
        if(checkCode!=null){
            checkCode = checkCode.toUpperCase();
        }

        if(StringUtils.isEmpty(checkCode) || captcha == null || !(checkCode.equalsIgnoreCase(captcha))) {
            return ResultJson.failed(CodeEnum.error.code(), "验证码错误！");
        } else if ((now.getTime()-codeTime)/1000/60>5) {
            //验证码有效时长为5分钟
            return ResultJson.failed(CodeEnum.error.code(), "验证码已失效，请重新输入！");
        }else {
            session.removeAttribute("simpleCaptcha");
            return ResultJson.success(CodeEnum.error.code(), "验证通过");
        }
    }
}
