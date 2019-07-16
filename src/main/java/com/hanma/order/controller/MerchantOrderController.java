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
 * @description: 商家调用的订单接口
 * @author: "Laugh Yan
 * @author: 申笑琰
 * @create: 2019-07-16 11:05
 */
@Controller
@RequestMapping("/merOrder")
@Api(description = "商家调用的订单接口")
public class MerchantOrderController {
    @Autowired
    private OrderService orderService;
    /**
     * 根据商家ID查询 此商家所有订单
     * @param merchantId
     */
    @GetMapping("/getMerchantIdOrder")
    @ResponseBody
    @ApiOperation(value = "根据商家ID查询此商家所有订单")
    public List<Order> getMerchantIdOrder(Long merchantId){
        List<Order> idOrder = orderService.getMerchantIdOrder(merchantId);
        return idOrder;
    }
}
