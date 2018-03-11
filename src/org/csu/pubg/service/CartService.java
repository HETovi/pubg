package org.csu.pubg.service;

import org.csu.pubg.domain.Cart;
import org.csu.pubg.domain.Item;
import org.csu.pubg.persistence.CartDao;
import org.csu.pubg.persistence.ItemDao;
import org.csu.pubg.persistence.impl.CartDaoImpl;
import org.csu.pubg.persistence.impl.ItemImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liulin on 2017/9/21.
 */
public class CartService {
    private CartDao cartDao;
    private ItemDao itemDao;
    private List<Item> itemList;
    private Item item;
    private List<Cart> cartList;


    public CartService(){
        cartDao=new CartDaoImpl();
        itemDao=new ItemImpl();
        itemList=new ArrayList<Item>();
        cartList=new ArrayList<>();
    }
    //得到用户的购物车
    public List<Cart> getCartListByNickName(String nickName){
        return cartDao.getCartListByNickName(nickName);
    }

    //得到用户购物车中物品的详细信息
    public List<Item> getCartItem(List<Cart> getCartListByNickName){
        for (Cart cart:getCartListByNickName){
             item=new Item();
             item=itemDao.getItemByItemId(cart.getItemId());
             item.setItemNumber(cart.getNumber());
             itemList.add(item);
        }

        return itemList;
    }

    //通过三个参数，添加到数据库
     public  boolean addCart(String nickName, int itemId, int itemNumber){
        boolean flag=false;
        int number=0;
        cartList=cartDao.getCartListByNickName(nickName);
        for(Cart cart:cartList){
            if(itemId==cart.getItemId()){
                number=itemNumber+cart.getNumber();
                cartDao.modifyCartByNumber(number,cart.getCartId());
                return true;
            }
        }
        return cartDao.addCart(nickName,itemId,itemNumber);
    }

    //刷新数据库
    public  boolean updateCart(String nickName, int itemId, int itemNumber){
        boolean flag=false;
        int number=0;
        cartList=cartDao.getCartListByNickName(nickName);
        for(Cart cart:cartList){
            if(itemId==cart.getItemId()){
                number=itemNumber;
                cartDao.modifyCartByNumber(number,cart.getCartId());
                return true;
            }
        }
        return cartDao.addCart(nickName,itemId,itemNumber);
    }

    //删除购物车中选中的物品
    public boolean deleteCart(String name,int itemId){
        return cartDao.deleteCartByNameAndItemId(name,itemId);
    }

    //删除购物车中的物品

}
