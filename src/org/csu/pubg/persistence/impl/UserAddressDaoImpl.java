package org.csu.pubg.persistence.impl;

import org.csu.pubg.domain.UserAddress;
import org.csu.pubg.persistence.BaseDao;
import org.csu.pubg.persistence.UserAddressDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tovi on 2017/9/20.
 */
public class UserAddressDaoImpl implements UserAddressDao {
    @Override
    //获取用户地址
    public List<UserAddress> getUserAddressByNickName(String nickName) {
        List<UserAddress> list = new ArrayList<UserAddress>();

        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;

        String sql = "select * from useraddress where NickName=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setString(1,nickName);
            rs = psst.executeQuery();
            UserAddress userInfo=null;
            while (rs.next()) {
                userInfo=new UserAddress();
                userInfo.setPostCode(rs.getInt("PostCode"));
                userInfo.setPostPlace(rs.getString("PostPlace"));
                userInfo.setTelephone(rs.getString("Telephone"));
                userInfo.setNickName(rs.getString("NickName"));
                userInfo.setUserAddressId(rs.getInt("Id"));
                list.add(userInfo);
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
    public boolean modifyAddress(int id, UserAddress userAddress) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "update useraddress "+" set PostCode=?,PostPlace=?,Telephone=?"+" where Id=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setInt(1,userAddress.getPostCode());
            psst.setString(2,userAddress.getPostPlace());
            psst.setString(3, userAddress.getTelephone());
            psst.setInt(4,id);
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
    public boolean addAddress(UserAddress userAddress) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "insert into useraddress(NickName,PostCode,PostPlace,Telephone) values(?,?,?,?)";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setString(1,userAddress.getNickName());
            psst.setInt(2,userAddress.getPostCode());
            psst.setString(3, userAddress.getPostPlace());
            psst.setString(4,userAddress.getTelephone());
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
}
