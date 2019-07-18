package com.hanma.order.mapper;

import com.hanma.order.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);
    //新增订单信息
    int insertSelective(Order record);
    //根据ID查询 此用户所有订单
    List<Order> selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKeyWithBLOBs(Order record);

    int updateByPrimaryKey(Order record);

    //查询所有订单
    List<Order> queryOrderList(String orderNumber);

    //根据商家ID查询 此商家所有订单
    List<Order> getMerchantIdOrder(Long merchantId);


}