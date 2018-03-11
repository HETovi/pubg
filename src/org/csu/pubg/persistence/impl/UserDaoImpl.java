package org.csu.pubg.persistence.impl;

import org.csu.pubg.domain.UserInfo;
import org.csu.pubg.persistence.UserDao;
import org.csu.pubg.persistence.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tovi on 2017/9/19.
 */
public class UserDaoImpl implements UserDao {
    @Override
    //根据名字查询是否存在该用户
    public boolean isExistUser(String name) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "select * from user where NickName=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setString(1, name);
            rs = psst.executeQuery();
            if (rs.next()) {
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
    //注册用户
    public boolean registerUser(UserInfo userInfo) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        String sql="insert into user(NickName,Pass,RealName,Identity,Email,RoleId) values(?,?,?,?,?,?)";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setString(1, userInfo.getNickName());
            psst.setString(2, userInfo.getPass());
            psst.setString(3,userInfo.getRealName());
            psst.setString(4,userInfo.getIdentity());
            psst.setString(5,userInfo.getEmail());
            psst.setInt(6,3);
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
    //获取用户所有信息
    public UserInfo getAllfromnickName(String name) {
        UserInfo userInfo = null;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "select * from user where NickName=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setString(1, name);
            rs = psst.executeQuery();
            if (rs.next()) {
                userInfo=new UserInfo();
                userInfo.setId(rs.getInt("Id"));
                userInfo.setNickName(rs.getString("NickName"));
                userInfo.setPass(rs.getString("Pass"));
                userInfo.setRealName(rs.getString("RealName"));
                userInfo.setIdentity(rs.getString("Identity"));
                userInfo.setEmail(rs.getString("Email"));
                userInfo.setRoleId(rs.getInt("RoleId"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(rs, psst, conn);
        }
        return userInfo;
    }

    @Override
    //修改用户
    public boolean modifyUser(UserInfo userInfo,String name) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "update user "+" set RealName=?,Identity=?,Email=?"+" where NickName=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setString(1, userInfo.getRealName());
            psst.setString(2, userInfo.getIdentity());
            psst.setString(3, userInfo.getEmail());
            psst.setString(4,name);
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
    //修改密码
    public boolean modifyUserPass(String name,String pass) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "update user "+" set Pass=?"+" where NickName=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setString(1, pass);
            psst.setString(2,name);
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
    //登录
    public boolean isLoginUser(String name, String pass) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "select * from user where NickName=? and Pass=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setString(1,name);
            psst.setString(2,pass);
            rs = psst.executeQuery();
            if (rs.next()) {
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
    public List<UserInfo> getAllPage(int nowPage, int pageSize) {
        List<UserInfo> list = new ArrayList<UserInfo>();
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "select * from user limit ?,?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            int begin = (nowPage-1)*pageSize;
            psst.setInt(1, begin);
            psst.setInt(2,pageSize);
            rs = psst.executeQuery();
            UserInfo userInfo=null;
            while (rs.next()) {
                userInfo = new UserInfo();
                userInfo.setId(rs.getInt("Id"));
                userInfo.setIdentity(rs.getString("Identity"));
                userInfo.setNickName(rs.getString("NickName"));
                userInfo.setEmail(rs.getString("Email"));
                userInfo.setRealName(rs.getString("RealName"));
                int roleId = rs.getInt("RoleId");
                userInfo.setRole(new RoleDaoImpl().getRoleByid(roleId));
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
    public boolean modifyUserPower(String name, int roleId) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "update user "+" set RoleId=?"+" where NickName=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setInt(1, roleId);
            psst.setString(2,name);
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
    public int getAllPage(int pageSize) {
        int dataNumber = 0;
        int pageNumber =0;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "select * from user";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            rs = psst.executeQuery();
            while(rs.next()) {
                dataNumber++;
            }
            if(dataNumber<=pageSize){
                pageNumber =1;
            }
            else{
                if(dataNumber%pageSize==0){
                    pageNumber = dataNumber/pageSize;
                }
                else{
                    pageNumber = dataNumber/pageSize+1;
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(rs, psst, conn);
        }
        return pageNumber;
    }
}
