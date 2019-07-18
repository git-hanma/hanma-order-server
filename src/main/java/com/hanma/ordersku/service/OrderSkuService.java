package com.hanma.ordersku.service;

import com.hanma.ordersku.domain.OrderSku;

import java.util.List;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
public interface OrderSkuService {
    //根据商家ID查询 此商家所有订单
    List<OrderSku> getMerchantIdOrder(Long orderId);
}
