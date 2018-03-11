package org.csu.pubg.persistence;

import org.csu.pubg.domain.OrderDetail;

import java.util.List;

/**
 * Created by Tovi on 2017/9/21.
 */
public interface OrderDetailDao {
    //通过orderID获取细节信息，结果返回list
    List<OrderDetail> getOrderDetailByOrderId(int orderId);
    //添加订单详情
    boolean addOrderDetail(OrderDetail orderDetail);
    //删除订单详情
    boolean deleteOrderDetail(int orderId);
}
