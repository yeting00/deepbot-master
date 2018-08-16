package com.perspicace.ai.deepbot.model;

import java.io.Serializable;

/**
 * @program: deepbot
 * @description: 购物的词槽
 * @author: Destiny
 * @create: 2018-08-09 17:17
 **/
public class Slot4Shopping implements Serializable {
    private String goodsType;   // 物品名
    private String goodsName;   // 物品名

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
