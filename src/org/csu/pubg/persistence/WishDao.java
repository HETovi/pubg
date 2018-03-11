package org.csu.pubg.persistence;

import org.csu.pubg.domain.Cart;
import org.csu.pubg.domain.Wish;

import java.util.List;

/**
 * Created by Tovi on 2017/9/20.
 */
public interface WishDao {
    //通过三个参数，添加到数据库
    boolean addWish(String nickName, int itemId, int itemNumber);
    //通过用户昵称获取购物车信息
    List<Wish> getWishListByNickName(String nickName);
    //获取数量输入框中的值，修改购物车相关信息
    boolean modifyWishByNumber(int number, int wishId);
    //通过wishId删除购物车里面的信息
    boolean deleteWishByWishId(int wishId);
    public boolean deleteWishByNameAndItemId(String name,int itemid);
}
