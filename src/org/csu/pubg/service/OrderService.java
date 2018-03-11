package org.csu.pubg.service;

import org.csu.pubg.domain.Item;
import org.csu.pubg.domain.Order;
import org.csu.pubg.domain.OrderDetail;
import org.csu.pubg.domain.UserAddress;
import org.csu.pubg.persistence.ItemDao;
import org.csu.pubg.persistence.OrderDao;
import org.csu.pubg.persistence.OrderDetailDao;
import org.csu.pubg.persistence.UserAddressDao;
import org.csu.pubg.persistence.impl.ItemImpl;
import org.csu.pubg.persistence.impl.OrderDaoImpl;
import org.csu.pubg.persistence.impl.OrderDetailDaoImpl;
import org.csu.pubg.persistence.impl.UserAddressDaoImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liulin on 2017/9/24.
 */
public class OrderService {
    private OrderDao orderDao;
    private OrderDetailDao orderDetailDao;
    private Order order;
    private ItemDao itemDao;
    private OrderDetail orderDetail;
    private List<Order> orderList;
    private List<OrderDetail> orderDetailList;
    private UserAddressDao userAddressDao;

    public OrderService(){
        orderDao=new OrderDaoImpl();
        orderDetailDao=new OrderDetailDaoImpl();
        orderList=new ArrayList<>();
        orderDetailList=new ArrayList<>();
        itemDao=new ItemImpl();
        orderDetail=new OrderDetail();
        userAddressDao=new UserAddressDaoImpl();
    }


    //查询我的所有订单
    public List<Order> getAllOrder(String name){
        orderList=orderDao.getOrderListByNickName(name);
        for(Order order1:orderList){
            orderDetailList=orderDetailDao.getOrderDetailByOrderId(order1.getOrderId());
            order1.setOrderDetails(orderDetailList);
        }
        return orderList;
    }
    public List<Order> getAllOrders(){
        orderList=orderDao.getOrderList();
        for(Order order1:orderList){
            orderDetailList=orderDetailDao.getOrderDetailByOrderId(order1.getOrderId());
            order1.setOrderDetails(orderDetailList);
        }
        return orderList;
    }


    //删除订单
    public boolean deleteOrderByOrderId(int id){
        return orderDao.deleteOrderByOrderId(id);
    }

    //根据订单Id得到订单详情
    public Order getOrderByOrderId(int id){
        order=orderDao.getOrderByOrderId(id);
        orderDetailList=orderDetailDao.getOrderDetailByOrderId(order.getOrderId());
        for(OrderDetail orderDetail:orderDetailList){
            orderDetail.setItem(itemDao.getItemByItemId(orderDetail.getItemId()));
        }
        order.setOrderDetails(orderDetailList);
        return order;
    }

    //通过用户和订单时间得到order对象
    public Order getOrderByOrderTime(String name,Timestamp time){
        return orderDao.getOrderByOrderTime(name,time);
    }

    //查询常用地址
    public List<UserAddress> getUserAddressByNickName(String nickName){
        return userAddressDao.getUserAddressByNickName(nickName);
    }

    //添加订单
    public int addOrder(Order order){
        return orderDao.addOrder(order);
    }


    //添加orderDetail
    public boolean addOrderDetail(OrderDetail orderDetail){
        return orderDetailDao.addOrderDetail(orderDetail);
    }

    public boolean modifyOrderStatus(int id, Order order){
        return orderDao.modifyOrder(id,order);
    }

}
