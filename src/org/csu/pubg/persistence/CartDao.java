package org.csu.pubg.persistence;

import org.csu.pubg.domain.Cart;
import java.util.*;

/**
 * Created by Tovi on 2017/9/20.
 */
public interface CartDao {
    //通过三个参数，添加到数据库
    boolean addCart(String nickName, int itemId, int itemNumber);
    //通过用户昵称获取购物车信息
    List<Cart> getCartListByNickName(String nickName);
    //获取数量输入框中的值，修改购物车相关信息
    boolean modifyCartByNumber(int number, int cartId);
    //通过cartId删除购物车里面的信息
    boolean deleteCartByCartId(int cartId);
    public boolean deleteCartByNameAndItemId(String name,int itemid);


}
