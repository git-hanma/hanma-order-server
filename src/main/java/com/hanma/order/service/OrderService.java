package com.hanma.order.service;

import com.hanma.order.domain.Order;

import java.util.List;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
public interface OrderService {

    //根据ID查询 此用户所有订单
    List<Order> getUserIdOrder(Long userId);

    //查询所有订单
    List<Order> queryOrderList(String orderNumber);

    //根据商家ID查询 此商家所有订单
    List<Order> getMerchantIdOrder(Long merchantId);

    //新增订单信息
    Integer saveOrder(Order order);

}
