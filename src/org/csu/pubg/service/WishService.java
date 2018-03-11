package org.csu.pubg.service;

import org.csu.pubg.domain.Wish;
import org.csu.pubg.domain.Item;
import org.csu.pubg.persistence.WishDao;
import org.csu.pubg.persistence.ItemDao;
import org.csu.pubg.persistence.impl.WishDaoImpl;
import org.csu.pubg.persistence.impl.ItemImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liulin on 2017/9/23.
 */
public class WishService {
    private WishDao wishDao;
    private ItemDao itemDao;
    private List<Item> itemList;
    private Item item;
    private List<Wish> wishList;


    public WishService(){
        wishDao=new WishDaoImpl();
        itemDao=new ItemImpl();
        itemList=new ArrayList<Item>();
        wishList=new ArrayList<>();
    }
    //得到用户的购物车
    public List<Wish> getWishListByNickName(String nickName){
        return wishDao.getWishListByNickName(nickName);
    }

    //得到用户购物车中物品的详细信息
    public List<Item> getWishItem(List<Wish> getWishListByNickName){
        for (Wish wish:getWishListByNickName){
            item=new Item();
            item=itemDao.getItemByItemId(wish.getItemId());
            item.setItemNumber(wish.getNumber());
            itemList.add(item);
        }

        return itemList;
    }

    //通过三个参数，添加到数据库
    public  boolean addWish(String nickName, int itemId, int itemNumber){
        boolean flag=false;
        int number=0;
        wishList=wishDao.getWishListByNickName(nickName);
        for(Wish wish:wishList){
            if(itemId==wish.getItemId()){
                number=itemNumber+wish.getNumber();
                wishDao.modifyWishByNumber(number,wish.getWishId());
                return true;
            }
        }
        return wishDao.addWish(nickName,itemId,itemNumber);
    }

    //刷新数据库
    public  boolean updateWish(String nickName, int itemId, int itemNumber){
        boolean flag=false;
        int number=0;
        wishList=wishDao.getWishListByNickName(nickName);
        for(Wish wish:wishList){
            if(itemId==wish.getItemId()){
                number=itemNumber;
                wishDao.modifyWishByNumber(number,wish.getWishId());
                return true;
            }
        }
        return wishDao.addWish(nickName,itemId,itemNumber);
    }

    //删除购物车中选中的物品
    public boolean deleteWish(String name,int itemId){
        return wishDao.deleteWishByNameAndItemId(name,itemId);
    }

    //删除购物车中的物品

}
