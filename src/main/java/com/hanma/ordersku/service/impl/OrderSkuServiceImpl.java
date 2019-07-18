package com.hanma.ordersku.service.impl;

import com.hanma.ordersku.domain.OrderSku;
import com.hanma.ordersku.mapper.OrderSkuMapper;
import com.hanma.ordersku.service.OrderSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
@Transactional
@Service
public class OrderSkuServiceImpl implements OrderSkuService {

    /**
     * 注入 订单sku mapper
     */
    @Autowired
    private OrderSkuMapper orderSkuMapper;
    /**
    *@Description: OrderSkuServiceImpl java类作用描述:根据商家ID查询 此商家所有订单
    *@Param: * @param null
    *@return: 
    *@Author: 申笑琰
    *@CreateDate: 2019/7/17 下午 08:38
    */
    @Transactional(readOnly = true)
    @Override
    public List<OrderSku> getMerchantIdOrder(Long orderId) {
        return orderSkuMapper.getMerchantIdOrder(orderId);
    }
}
