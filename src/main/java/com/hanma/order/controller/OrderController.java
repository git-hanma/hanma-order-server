package com.hanma.order.controller;

import com.hanma.order.domain.Order;
import com.hanma.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
@Controller
@RequestMapping("/order")
@Api(description = "订单主表接口")
public class OrderController {

    /**
     * 注入service接口
     */
    @Autowired
    private OrderService orderService;


    /**
     * 根据ID查询 此用户所有订单
     * @param userId
     */
    @ResponseBody
    @GetMapping("/getUserIdOrder")
    @ApiOperation(value = "根据ID查询此用户所有订单")
    public Order getUserIdOrder(Long userId){
        Order userIdOrder = orderService.getUserIdOrder(userId);
        return userIdOrder;
    }

    /**
     * 查询所有订单
     */
    @ResponseBody
    @GetMapping("/queryOrderList")
    @ApiOperation(value = "查询所有订单")
    public List<Order> queryOrderList(){
        List<Order> orderList = orderService.queryOrderList();
        return orderList;
    }


    /**
     * 根据商家ID查询 此商家所有订单
     * @param merchantId
     */
    @GetMapping("/getMerchantIdOrder")
    @ResponseBody
    @ApiOperation(value = "根据商家ID查询此商家所有订单")
    public Order getMerchantIdOrder(Long merchantId){
        Order idOrder = orderService.getMerchantIdOrder(merchantId);
        return idOrder;
    }

    /**
     * 新增订单信息
     * @param order
     */
    @PostMapping("/saveOrder")
    @ResponseBody
    @ApiOperation(value = "新增订单信息")
    public Integer saveOrder(Order order){
        Integer integer = orderService.saveOrder(order);
        return integer;
    }




}
