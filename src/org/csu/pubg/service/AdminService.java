package org.csu.pubg.service;

import org.csu.pubg.domain.*;
import org.csu.pubg.persistence.*;
import org.csu.pubg.persistence.impl.*;

import java.util.List;

/**
 * Created by Tovi on 2017/9/23.
 */
public class AdminService {
    private UserDao userDAO;
    private UserAddressDao userAddressDao;
    private ItemDao itemDao;
    private CategoryDao categoryDao;
    private ClassificationDao classificationDao;
    public AdminService(){
        userDAO=new UserDaoImpl();
        userAddressDao = new UserAddressDaoImpl();
        itemDao = new ItemImpl();
        categoryDao = new CategoryDaoImpl();
        classificationDao = new ClassificationDaoImpl();
    }
    public boolean loginAdmin(String name,String pass){
        return userDAO.isLoginUser(name,pass);
    }
    public boolean isExistAdmin(String name){
        return userDAO.isExistUser(name);
    }
    public UserInfo getAdminByNickName(String name){
        return userDAO.getAllfromnickName(name);
    }
    public boolean modifyUser(UserInfo userInfo,String name){
        return userDAO.modifyUser(userInfo,name);
    }
    public boolean modifyPassword(String name,String pass){
        return userDAO.modifyUserPass(name,pass);
    }

    public List<UserAddress> getAdminAddressByName(String name){
        return userAddressDao.getUserAddressByNickName(name);
    }
    public List<UserInfo> getAllPage(int nowPage ,int pageSize){
        return userDAO.getAllPage(nowPage,pageSize);
    }

    public boolean modifyUserPower(String name,int roleId){
        return userDAO.modifyUserPower(name,roleId);
    }
    public int getAllPageNumber(int pageSize){
        return userDAO.getAllPage(pageSize);
    }
//item
    public List<Item> getAllPage(int nowPage){
        return itemDao.getAllItem(nowPage);
    }
    public int getPageNumber(){
        return itemDao.getPageNumber();
    }
    public boolean deleteItem(int id){
        return itemDao.deleteItem(id);
    }
    public boolean modifyItem(Item item, int id){
        return itemDao.modifyItem(item,id);
    }
    public Item getItemById(int id){
        return itemDao.getItemByItemId(id);
    }
    public boolean isExistItemId(int id){
        return itemDao.isExistItemId(id);
    }
    public boolean addItem(Item item){
        return itemDao.addItem(item);
    }

    //category
    public List<Category> getBigCategory(){
        return categoryDao.getCategoryList();
    }


    //classification
    public boolean addClassification(Classification classification){
        return classificationDao.addClassification(classification);
    }

}
