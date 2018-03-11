package org.csu.pubg.service;

import org.csu.pubg.domain.Category;
import org.csu.pubg.domain.Classification;
import org.csu.pubg.domain.Item;
import org.csu.pubg.persistence.CategoryDao;
import org.csu.pubg.persistence.ClassificationDao;
import org.csu.pubg.persistence.ItemDao;
import org.csu.pubg.persistence.UserDao;
import org.csu.pubg.persistence.impl.CategoryDaoImpl;
import org.csu.pubg.persistence.impl.ClassificationDaoImpl;
import org.csu.pubg.persistence.impl.ItemImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liulin on 2017/9/20.
 */
public class ProductService {
    private ItemDao itemDao;
    private ClassificationDao classificationDao;
    private Item item;
    private List<Item> itemList;
    private CategoryDao categoryDao;

    public  ProductService(){
        item=new Item();
        itemDao=new ItemImpl();
        classificationDao=new ClassificationDaoImpl();
        itemList=new ArrayList<Item>();
        categoryDao=new CategoryDaoImpl();
    }

    //得到所有物品(分页查询)
    public List<Item> getAllItem(int nowPag){
        return itemDao.getAllItem(nowPag);
    }


    //根据类别得到所有同类别物品的信息（分页查询）
    public List<Item> getAllItembByCategoryId(int categoryid,int nowPag){
        itemList=itemDao.getAllPageByCategoryId(nowPag,categoryid);
        return  itemList;
    }

    public  List<Classification> getCategoryIdbyItemId(int itemId){
         return classificationDao.getClassByItemId(itemId);
    }

    //根据itemid得到item
    public Item getItemByItemId(int itemId){
        return itemDao.getItemByItemId(itemId);
    }

    //得到全部物品的总页数
    public int getPageNumber(){
        return itemDao.getPageNumber();
    }

    public int getPageNumber(int categoryId){
        return itemDao.getPageNumber(categoryId);
    }

    public int getPageNumber(String serchname){
        return itemDao.getPageNumber(serchname);
    }

    //根据categoryId得到category
    public Category getCategoryBycategoryId(int id){
        return categoryDao.getCategoryBycategoryId(id);
    }

    //模糊查询（分页查询）
    public List<Item> fuzzySearch(int nowPag,String name){
        return itemDao.fuzzySearch(nowPag,name);
    }

    public boolean isFuzzySearch(String name){
        return itemDao.isFuzzySearch(name);
    }
}
