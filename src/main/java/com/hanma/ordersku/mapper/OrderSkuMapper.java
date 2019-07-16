package com.hanma.ordersku.mapper;

import com.hanma.ordersku.domain.OrderSku;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhaoyumeng on 2019/7/15.
 */
@Mapper
@Repository
public interface OrderSkuMapper {
    //根据商家ID查询 此商家所有订单
    List<OrderSku> getMerchantIdOrder(Long orderId);
}
