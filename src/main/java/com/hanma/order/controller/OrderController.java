package com.hanma.order.controller;

import com.hanma.order.domain.Order;
import com.hanma.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by shenxiaoyan on 2019/7/15.
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
