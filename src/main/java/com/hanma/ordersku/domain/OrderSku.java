package com.hanma.ordersku.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hanma.order.domain.Order;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by zhaoyumeng on 2019/7/15.
 * 订单sku表
 */
@Data
public class OrderSku {

    //订单sku主键
    private Long skuId;

    //订单主表外键
    private Long  orderId;

    //商品外键
    private Long  itemId;

    //商品同类总价格
    private Double  skuCountprice;

    //购买数量
    private Integer skuNum;

    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date skuCreateTime;

    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date skuUpdateTime;

    //状态
    private Integer skuYn;


}
