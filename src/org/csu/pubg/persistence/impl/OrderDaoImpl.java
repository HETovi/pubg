package org.csu.pubg.persistence.impl;

import org.csu.pubg.domain.Order;
import org.csu.pubg.persistence.BaseDao;
import org.csu.pubg.persistence.OrderDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tovi on 2017/9/21.
 */
public class OrderDaoImpl implements OrderDao {

    @Override
    //提交一个order类型的对象给数据库(提交订单)
    public int addOrder(Order order) {
        int k=0;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql="insert into orders(NickName,Status,Telephone,PostCode,PostPlace,OrderTime) values(?,?,?,?,?,?)";
        String sql2="select last_insert_id()";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setString(1,order.getNickName());
            psst.setString(2,order.getStatus());
            psst.setString(3,order.getTelephone());
            psst.setInt(4,order.getPostCode());
            psst.setString(5,order.getPostPlace());
            psst.setTimestamp(6,order.getTime());
            int i=psst.executeUpdate();
            if (i>0) {
                psst=conn.prepareStatement(sql2);
                rs = psst.executeQuery();
                if(rs.next()){
                    k=rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(null, psst, conn);
        }

        return k;
    }

    @Override
    //查看订单，结果返回list
    public List<Order> getOrderListByNickName(String name) {
        Order order = null;
        List<Order> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql ="SELECT * FROM orders WHERE NickName=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setString(1,name);
            rs = psst.executeQuery();
            while (rs.next()) {
                order = new Order();
                order.setPostPlace(rs.getString("PostPlace"));
                order.setNickName(rs.getString("NickName"));
                order.setOrderId(rs.getInt("OrderId"));
                order.setPostCode(rs.getInt("PostCode"));
                order.setStatus(rs.getString("Status"));
                order.setTelephone(rs.getString("Telephone"));
                order.setTime(rs.getTimestamp("OrderTime"));
                list.add(order);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(rs, psst, conn);
        }
        return list;
    }

    @Override
    //通过orderID获取order对象
    public Order getOrderByOrderId(int id) {
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        Order order = null;
        String sql = "select *  from orders where OrderId=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setInt(1, id);
            rs = psst.executeQuery();
            if (rs.next()) {
                order = new Order();

                order.setPostPlace(rs.getString("PostPlace"));
                order.setTelephone(rs.getString("Telephone"));
                order.setStatus(rs.getString("Status"));
                order.setPostCode(rs.getInt("PostCode"));
                order.setNickName(rs.getString("NickName"));
                order.setOrderId(rs.getInt("OrderId"));
                order.setTime(rs.getTimestamp("OrderTime"));

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(rs, psst, conn);
        }
        return order;
    }

    //通过用户和订单时间得到order对象
    public Order getOrderByOrderTime(String name,Timestamp time) {
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        Order order = null;
        String sql = "select *  from orders where NickName=? and OrderTime=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setString(1,name);
            psst.setTimestamp(2,time);
            rs = psst.executeQuery();
            if(rs.next()) {
                order = new Order();

                order.setPostPlace(rs.getString("PostPlace"));
                order.setTelephone(rs.getString("Telephone"));
                order.setStatus(rs.getString("Status"));
                order.setPostCode(rs.getInt("PostCode"));
                order.setNickName(rs.getString("NickName"));
                order.setOrderId(rs.getInt("OrderId"));
                order.setTime(rs.getTimestamp("OrderTime"));

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(rs, psst, conn);
        }
        return order;
    }


    @Override
    //删除订单
    public boolean deleteOrderByOrderId(int id) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        String sql = "delete from orders where OrderId=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setInt(1, id);
            int i=psst.executeUpdate();
            if(i>0){
                flag = true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(null, psst, conn);
        }
        return flag;
    }

    @Override
    //修改订单状态信息
    public boolean modifyOrder(int id, Order order) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "update orders "+" set Status=?"+" where OrderId=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setString(1,order.getStatus());
            psst.setInt(2,id);
            int i = psst.executeUpdate();
            if(i>0) {
                flag = true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(rs, psst, conn);
        }
        return flag;
    }

    @Override
    public List<Order> getOrderList() {
        Order order = null;
        List<Order> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql ="SELECT * FROM orders";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            rs = psst.executeQuery();
            while (rs.next()) {
                order = new Order();
                order.setPostPlace(rs.getString("PostPlace"));
                order.setNickName(rs.getString("NickName"));
                order.setOrderId(rs.getInt("OrderId"));
                order.setPostCode(rs.getInt("PostCode"));
                order.setStatus(rs.getString("Status"));
                order.setTelephone(rs.getString("Telephone"));
                order.setTime(rs.getTimestamp("OrderTime"));
                list.add(order);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(rs, psst, conn);
        }
        return list;

    }
}
