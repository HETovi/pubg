package org.csu.pubg.service;


import org.csu.pubg.domain.UserAddress;
import org.csu.pubg.domain.UserInfo;
import org.csu.pubg.persistence.UserAddressDao;
import org.csu.pubg.persistence.UserDao;
import org.csu.pubg.persistence.impl.UserAddressDaoImpl;
import org.csu.pubg.persistence.impl.UserDaoImpl;

import java.util.List;

/**
 * Created by liulin on 2017/9/13.
 */
public class UserService {
    private UserDao userDAO;
    private UserAddressDao userAddressDao;

    public UserService(){
        userDAO=new UserDaoImpl();
        userAddressDao = new UserAddressDaoImpl();
    }

    public boolean islogin(String username,String password){
       return userDAO.isLoginUser(username,password);
    }
    public UserInfo getUser(String username){
        return userDAO.getAllfromnickName(username);
    }

    public boolean register(UserInfo userInfo){
        return userDAO.registerUser(userInfo);
    }
    public boolean isExist(String name){
        return userDAO.isExistUser(name);
    }
    public List<UserAddress> getUserAddressByName(String name){
        return userAddressDao.getUserAddressByNickName(name);
    }
    public boolean modifyUser(UserInfo userInfo,String name){
        return userDAO.modifyUser(userInfo,name);
    }
    public boolean modifyAddress(int id,UserAddress userAddress){
        return userAddressDao.modifyAddress(id,userAddress);
    }
    public boolean modifyUserPassword(String name,String pass){
        return userDAO.modifyUserPass(name,pass);
    }
    public boolean addUserAddress(UserAddress userAddress){
        return userAddressDao.addAddress(userAddress);
    }
}
