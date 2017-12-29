package com.fq.model;

import java.io.Serializable;

/**
 * @title : seckill-online
 * @description: 仓库
 * @author: 番茄很忙
 * @date: 2017/12/29 17:50
 * @version: 1.0
 */
public class Depot implements Serializable {

    private Integer id;

    /**
     * 仓库名
     */
    private String dName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }
}
