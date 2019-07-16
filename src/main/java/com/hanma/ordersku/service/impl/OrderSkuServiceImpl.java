package com.hanma.ordersku.service.impl;

import com.hanma.ordersku.mapper.OrderSkuMapper;
import com.hanma.ordersku.service.OrderSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
@Service
public class OrderSkuServiceImpl implements OrderSkuService {

    /**
     * 注入 订单sku mapper
     */
    @Autowired
    private OrderSkuMapper orderSkuMapper;

}
