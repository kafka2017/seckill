package com.fq.model;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

/**
 * @title : seckill-online
 * @description:
 * @author: 番茄很忙
 * @date: 2018/1/2 10:28
 * @version: 1.0
 */
public class CodeImage {

    /**
     * 访问数
     */
    private Integer pageView;

    /**
     * 会员id
     */
    @NotNull(message = "会员id不能为空")
    @NotEmpty(message = "会员id不能为空")
    private Integer menberId;

    /**
     * 验证码
     */
    @NotNull(message = "验证码不能为空")
    @NotEmpty(message = "验证码不能为空")
    private String code;

    /**
     * 当前时间戳
     */
    @NotNull(message ="当前时间戳不能为空")
    @NotEmpty(message="当前时间戳不能为空")
    private Long timeStamp;

    public Integer getMenberId() {
        return menberId;
    }

    public void setMenberId(Integer menberId) {
        this.menberId = menberId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
