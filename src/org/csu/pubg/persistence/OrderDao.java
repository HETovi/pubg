package org.csu.pubg.persistence;

import org.csu.pubg.domain.Order;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Tovi on 2017/9/21.
 */
public interface OrderDao {
    //通过表单中相关信息，提交一个订单
    int addOrder(Order order);
    //查看订单
    List<Order> getOrderListByNickName(String name);
    List<Order> getOrderList();
    //通过orderID获取order对象
    Order getOrderByOrderId(int id);
    //删除订单
    boolean deleteOrderByOrderId(int id);
    //修改订单
    boolean modifyOrder(int id, Order order);
    //通过用户和订单时间得到order对象
    public Order getOrderByOrderTime(String name,Timestamp time);
}
