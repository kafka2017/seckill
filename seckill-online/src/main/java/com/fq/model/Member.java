package com.fq.model;

import java.io.Serializable;

/**
 * @title : seckill-online
 * @description: 会员信息
 * @author: 番茄很忙
 * @date: 2017/12/29 17:46
 * @version: 1.0
 */
public class Member implements Serializable {

    private Integer id;

    private String mName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
