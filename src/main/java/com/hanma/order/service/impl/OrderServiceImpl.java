package com.hanma.order.service.impl;

import com.hanma.order.domain.Order;
import com.hanma.order.mapper.OrderMapper;
import com.hanma.order.service.OrderService;
import com.hanma.ordersku.domain.OrderSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;


    /**
     * 根据用户ID查询此用户所有订单
     * @param userId
     */
    @Override
    public Order getUserIdOrder(Long userId) {
        Order order = orderMapper.selectByPrimaryKey(userId);
        return order;
    }

    /**
     * 查询所有订单
     */
    @Override
    public List<Order> queryOrderList() {
        List<Order> orderList= orderMapper.queryOrderList();
        return orderList;
    }

    /**
     * 根据商家ID查询 此商家所有订单
     * @param merchantId
     */
    @Override
    public Order getMerchantIdOrder(Long merchantId) {
        Order merchantIdOrder = orderMapper.getMerchantIdOrder(merchantId);
        return merchantIdOrder;
    }

    /**
     * 新增订单信息
     * @param order
     */
    @Override
    public Integer saveOrder(Order order) {
        /*创建时间2019-7-15 21:03:19*/
        order.setOrderCreateTime(new Date());
        /*sku创建时间*/
        /*order.setOrderSkus();*/
        /*生成订单单号*/
        order.setOrderNumber(""+new Date()+order.getOrderId());
        int i = orderMapper.insertSelective(order);
        return i;
    }



}
