package com.hanma.order.service.impl;

import com.hanma.order.domain.Order;
import com.hanma.order.mapper.OrderMapper;
import com.hanma.order.service.OrderService;
import com.hanma.ordersku.domain.OrderSku;
import com.hanma.ordersku.mapper.OrderSkuMapper;
import com.hanma.ordersku.service.OrderSkuService;
import com.hanma.util.OrderCodeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
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
    @Autowired
    private OrderSkuService orderSkuService;


    /**
     * 根据用户ID查询此用户所有订单
     * @param userId
     */
    @Transactional(readOnly = true)
    @Override
    public List<Order> getUserIdOrder(Long userId) {
        /*根据用户ID查询订单主表*/
        List<Order> order = orderMapper.selectByPrimaryKey(userId);
        /*根据主表ID查询sku表*/
        /*循环订单的数据*/
        for(int i=0;i<order.size();i++) {
            List<OrderSku> orderSku = orderSkuService.getMerchantIdOrder(order.get(i).getOrderId());
        /*再放入order实体的list中*/
            order.get(i).setOrderSkus(orderSku);
        }
        return order;
    }

    /**
     * 查询所有订单
     */
    @Transactional(readOnly = true)
    @Override
    public List<Order> queryOrderList() {
        /*查询主订单的数据*/
        List<Order> orderList= orderMapper.queryOrderList();
        /*循环订单的数据*/
        for(int i=0;i<orderList.size();i++){
            /*使用主订单的ID查询出与之对应的sku附属表中的数据*/
            List<OrderSku> merchantIdOrder = orderSkuService.getMerchantIdOrder(orderList.get(i).getOrderId());
            /*放入主订单中的list中*/
            orderList.get(i).setOrderSkus(merchantIdOrder);
        }
        return orderList;
    }

    /**
     * 根据商家ID查询 此商家所有订单
     * @param merchantId
     */
    @Transactional(readOnly = true)
    @Override
    public List<Order> getMerchantIdOrder(Long merchantId) {
        /*查询订单主表*/
        List<Order> merchantIdOrder = orderMapper.getMerchantIdOrder(merchantId);
        /*查询sku表*/
        /*循环订单的数据*/
        for(int i=0;i<merchantIdOrder.size();i++) {
            List<OrderSku> orderSku = orderSkuService.getMerchantIdOrder(merchantIdOrder.get(i).getOrderId());
        /*再放入order实体的list中*/
            merchantIdOrder.get(i).setOrderSkus(orderSku);
        }
        return merchantIdOrder;
    }

    /**
     * 新增订单信息
     * @param order
     */
    @Override
    public Integer saveOrder(Order order) {
        /*创建主订单时间2019-7-15 21:03:19*/
        Date date = new Date();
        order.setOrderCreateTime(date);
        /*循环sku数据操作*/
        for (int i=0; i<order.getOrderSkus().size();i++){
            /*把主订单的ID赋值给sku附表中的外键*/
            order.getOrderSkus().get(i).setOrderId(order.getOrderId());
            /*sku的创建时间*/
            order.getOrderSkus().get(i).setSkuCreateTime(date);
            /*状态*/
            order.getOrderSkus().get(i).setSkuYn(1);
        }
        /*order状态*/
        order.setOrderYn(1);
        /*生成订单单号*/
        System.out.print(OrderCodeFactory.getOrderCode(order.getUserId()));
        order.setOrderNumber(OrderCodeFactory.getOrderCode(order.getUserId()));
        /*返回1成功*/
        int i = orderMapper.insertSelective(order);
        return 1;
    }



}
