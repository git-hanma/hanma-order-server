package com.hanma.order.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hanma.ordersku.domain.OrderSku;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
public class Order implements Serializable {
    /**
     * 序列化
     */
    private static final long serialVersionUID = -4312930734780706350L;
    //订单主键
    private Long orderId;

    //用户外键
    private Long userId;

    //商家外键
    private Long merchantId;

    //配送费
    private Double orderCost;

    //优惠信息
    private String  orderOnsale;

    //总金额
    private Double  orderCountprice;

    //实际支付
    private String orderActual;

    //支付方式
    private String orderPay;

    //收货人
    private String  addressName;

    //收货地址
    private String addressShipping;

    //联系方式
    private String addressPhone;

    //订单状态
    private Integer orderStatus;

    //订单单号
    private String  orderNumber;

    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date  orderCreateTime;

    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderPayentTime;

    //预送时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderSendTime;

    //送达时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderGainTime;

    //备注
    private String orderText;

    //状态
    private Integer orderYn;
    //注入附表
    private List<OrderSku> orderSkus;

}