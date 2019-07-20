package com.hanma.order.controller;

import com.hanma.order.domain.Order;
import com.hanma.order.service.OrderService;
import com.hanma.ordersku.domain.OrderSku;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    /**
    *@Description: OrderController java类作用描述:根据主订单ID查询sku表信息
    *@Param: * @param null
    *@return: 
    *@Author: 申笑琰
    *@CreateDate: 2019/7/20 上午 10:09
    */
    @ApiOperation(value = "根据主订单ID查询sku表信息")
    @ResponseBody
    @GetMapping("orderSku")
    public List<OrderSku> orderSku(Long orderid){
        List<Order> orderList = orderService.queryOrderList(null);
        if (orderid!=null) {
            for (int i = 0; i < orderList.size(); i++) {
                for (int j=0;j<orderList.get(i).getOrderSkus().size();i++){
                    if (orderList.get(i).getOrderSkus().get(j).getOrderId().equals(orderid)){
                        System.out.println(orderList.get(i).getOrderSkus());
                        return orderList.get(i).getOrderSkus();
                    }
                }
            }
        }
        return null;
    }


}
