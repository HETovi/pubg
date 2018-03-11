package org.csu.pubg.persistence;

import org.csu.pubg.domain.UserInfo;

import java.util.List;

/**
 * Created by Tovi on 2017/9/19.
 */
public interface UserDao {
    //根据名字查询是否存在该用户
    boolean isExistUser(String name);
    //注册用户
    boolean registerUser(UserInfo userInfo);
    //查询个人信息(通过昵称获取该用户名所有信息)
    UserInfo getAllfromnickName(String name);
    //修改个人信息
    boolean modifyUser(UserInfo userInfo, String name);
    //修改个人密码
    boolean modifyUserPass(String name, String pass);
    //登录
    boolean isLoginUser(String name, String pass);
    //通过当前页和页大小获取所有用户
    List<UserInfo> getAllPage(int nowPage, int pageSize);
    //修改用户权限
    boolean modifyUserPower(String name,int roleId);
    //获得页数
    int getAllPage(int pageSize);

}
