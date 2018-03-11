package org.csu.pubg.persistence.impl;

import org.csu.pubg.domain.OrderDetail;
import org.csu.pubg.persistence.BaseDao;
import org.csu.pubg.persistence.OrderDetailDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tovi on 2017/9/21.
 */
public class OrderDetailDaoImpl implements OrderDetailDao {
    @Override
    //通过orderID获取细节
    public List<OrderDetail> getOrderDetailByOrderId(int orderId) {
        List<OrderDetail> list = new ArrayList<OrderDetail>();

        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;

        String sql = "select * from orderdetail where OrderId=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setInt(1,orderId);
            rs = psst.executeQuery();
            OrderDetail orderDetail=null;
            while (rs.next()) {
                orderDetail = new OrderDetail();
                orderDetail.setItemNumber(rs.getInt("ItemNumber"));
                orderDetail.setDetailId(rs.getInt("DetailId"));
                orderDetail.setItemId(rs.getInt("ItemId"));
                orderDetail.setItemPrice(rs.getDouble("ItemPrice"));
                orderDetail.setOrderId(rs.getInt("OrderId"));
                list.add(orderDetail);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(rs, psst, conn);
        }
        return list;
    }

    @Override
    //添加orderDetail
    public boolean addOrderDetail(OrderDetail orderDetail) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        String sql="insert into orderdetail(OrderId,ItemId,ItemNumber,ItemPrice) values(?,?,?,?)";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setInt(1,orderDetail.getOrderId());
            psst.setInt(2,orderDetail.getItemId());
            psst.setInt(3,orderDetail.getItemNumber());
            psst.setDouble(4,orderDetail.getItemPrice());
            int i=psst.executeUpdate();
            if (i>0) {
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
    //删除订单详情
    public boolean deleteOrderDetail(int orderId) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        String sql = "delete from orderdetail where OrderId=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setInt(1, orderId);
            psst.execute();
            flag = true;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(null, psst, conn);
        }
        return flag;
    }
}
