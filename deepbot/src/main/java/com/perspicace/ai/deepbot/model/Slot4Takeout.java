package com.perspicace.ai.deepbot.model;

/**
 * @program: deepbot
 * @description: 外卖词槽
 * @author: Destiny
 * @create: 2018-08-09 17:31
 **/
public class Slot4Takeout {
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
