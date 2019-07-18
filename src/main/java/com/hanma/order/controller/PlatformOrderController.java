package com.hanma.order.controller;/**
 * Created by Administrator on 2019/7/16.
 */

import com.google.gson.Gson;
import com.hanma.order.domain.Order;
import com.hanma.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: hanma-order-server
 * @description:平台调用的订单接口
 * @author: "Laugh Yan
 * @author: 申笑琰
 * @create: 2019-07-16 11:00
 */
@Controller
@RequestMapping("/plat")
@Api(description = "平台调用的订单接口")
public class PlatformOrderController {
    @Autowired
    private OrderService orderService;
    /**
     * 查询所有订单
     */
    @ResponseBody
    @GetMapping("/queryOrderList")
    @ApiOperation(value = "查询所有订单")
    public List<Order> queryOrderList(@RequestParam String orderNumber){
        return orderService.queryOrderList(orderNumber);
    }
}
