package com.hanma.ordersku.controller;

import com.hanma.ordersku.service.OrderSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
@Controller
public class OrderSkuController {

    /**
     * 注入订单sku service
     */
    @Autowired
    private OrderSkuService orderSkuService;



}
