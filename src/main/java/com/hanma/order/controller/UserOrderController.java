package com.hanma.order.controller;/**
 * Created by Administrator on 2019/7/16.
 */

import com.hanma.order.domain.Order;
import com.hanma.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: hanma-order-server
 * @description: 用户调用订单接口
 * @author: "Laugh Yan
 * @author: 申笑琰
 * @create: 2019-07-16 11:08
 */
@Controller
@RequestMapping("/merOrder")
@Api(description = "用户调用订单接口")
public class UserOrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 根据ID查询 此用户所有订单
     * @param userId
     */
    @ResponseBody
    @GetMapping("/getUserIdOrder")
    @ApiOperation(value = "根据ID查询此用户所有订单")
    public List<Order> getUserIdOrder(Long userId){
        List<Order> userIdOrder = orderService.getUserIdOrder(userId);
        return userIdOrder;
    }

}
