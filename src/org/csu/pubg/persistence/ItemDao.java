package org.csu.pubg.persistence;

import org.csu.pubg.domain.Item;
import java.util.*;

/**
 * Created by Tovi on 2017/9/20.
 */
public interface ItemDao {
    //模糊搜索
    List<Item> fuzzySearch(int nowPag,String name);
    //模糊查询是否有结果
    boolean isFuzzySearch(String name);
    //通过itemId获取item信息
    Item getItemByItemId(int itemId);
    //分页查询
    public List<Item> getAllItem(int nowPag);
    public List<Item> getAllPageByCategoryId(int nowPage, int categoryId);
    public int getPageNumber();
    public int getPageNumber(int categoryId);
    public int getPageNumber(String name);
    boolean addItem(Item item);
    boolean deleteItem(int id);
    boolean modifyItem(Item item,int id);
    boolean isExistItemId(int id);


}
