package org.csu.pubg.persistence.impl;

import org.csu.pubg.domain.Cart;
import org.csu.pubg.persistence.BaseDao;
import org.csu.pubg.persistence.CartDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tovi on 2017/9/20.
 */
public class CartDaoImpl implements CartDao {
    @Override
    //通过三个参数，添加到数据库(添加)
    public boolean addCart(String nickName, int itemId, int Number) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        String sql="insert into cart(NickName,ItemId,Number) values(?,?,?)";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setString(1, nickName);
            psst.setInt(2, itemId);
            psst.setInt(3,Number);

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
    //通过用户昵称获取购物车信息
    public List<Cart> getCartListByNickName(String nickName) {
        List<Cart> list = new ArrayList<>();
        Cart cart;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "select * from cart where NickName=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setString(1, nickName);
            rs = psst.executeQuery();
            while (rs.next()) {
                cart = new Cart();
                cart.setItemId(rs.getInt("ItemId"));
                cart.setCartId(rs.getInt("CartId"));
                cart.setNickName(rs.getString("NickName"));
                cart.setNumber(rs.getInt("Number"));

                list.add(cart);


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
    //获取数量输入框中的值，修改购物车相关信息
    public boolean modifyCartByNumber(int number,int cartId) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "update cart "+" set Number=?"+" where CartId=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setInt(1, number);
            psst.setInt(2, cartId);

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
    //通过cartId删除cart相关信息
    public boolean deleteCartByCartId(int cartId) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        String sql = "delete from cart where CartId=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setInt(1, cartId);
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
    //通过NickName,ItemId删除cart相关信息
    public boolean deleteCartByNameAndItemId(String name,int itemid) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        String sql = "delete from cart where NickName=? and ItemId=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setString(1, name);
            psst.setInt(2,itemid);
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
}
