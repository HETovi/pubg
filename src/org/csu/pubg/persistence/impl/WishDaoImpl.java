package org.csu.pubg.persistence.impl;

import org.csu.pubg.domain.Cart;
import org.csu.pubg.domain.Wish;
import org.csu.pubg.persistence.BaseDao;
import org.csu.pubg.persistence.WishDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tovi on 2017/9/20.
 */
public class WishDaoImpl implements WishDao {
    @Override


    public boolean addWish(String nickName, int itemId, int Number) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        String sql="insert into wish(NickName,ItemId,Number) values(?,?,?)";
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
    public List<Wish> getWishListByNickName(String nickName) {
        List<Wish> list = new ArrayList<>();
        Wish wish;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "select * from wish where NickName=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setString(1, nickName);
            rs = psst.executeQuery();
            while (rs.next()) {
                wish = new Wish();
                wish.setItemId(rs.getInt("ItemId"));
                wish.setWishId(rs.getInt("WishId"));
                wish.setNickName(rs.getString("NickName"));
                wish.setNumber(rs.getInt("Number"));

                list.add(wish);


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
    public boolean modifyWishByNumber(int number,int wishId) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "update wish "+" set Number=?"+" where WishId=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setInt(1, number);
            psst.setInt(2, wishId);

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
    //通过wishId删除wish相关信息
    public boolean deleteWishByWishId(int wishId) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        String sql = "delete from wish where WishId=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setInt(1, wishId);
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
    //通过NickName,ItemId删除wish相关信息
    public boolean deleteWishByNameAndItemId(String name,int itemid) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        String sql = "delete from wish where NickName=? and ItemId=?";
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
