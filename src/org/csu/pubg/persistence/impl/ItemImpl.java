package org.csu.pubg.persistence.impl;

import org.csu.pubg.domain.Item;
import org.csu.pubg.persistence.ItemDao;
import org.csu.pubg.persistence.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tovi on 2017/9/20.
 */
public class ItemImpl implements ItemDao {
    @Override
    //模糊搜索
    public List<Item> fuzzySearch(int nowPag,String name) {
        List<Item> list = new ArrayList<Item>();

        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;

        String sql = "select * from item where ItemName like '%"+name+"%' limit ?,8";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            int page = (nowPag-1)*8;
            psst.setInt(1,page);
            rs = psst.executeQuery();
            Item item=null;
            while (rs.next()) {
                item = new Item();
                item.setItemId(rs.getInt("ItemId"));
                item.setItemName(rs.getString("ItemName"));
                item.setDescn(rs.getString("Descn"));
                item.setPrice(rs.getDouble("Price"));
                item.setItemNumber(rs.getInt("ItemNumber"));
                item.setImgurl(rs.getString("ImgUrl"));
                list.add(item);
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
    //模糊查询是否有结果
    public boolean isFuzzySearch(String name) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;

        String sql = "select * from item where ItemName like '%"+name+"%'";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
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
    //通过itemID获取item信息
    public Item getItemByItemId(int itemId) {
        Item item = null;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "select * from item where ItemId=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setInt(1, itemId);
            rs = psst.executeQuery();
            if (rs.next()) {
                item = new Item();
                item.setItemId(rs.getInt("ItemId"));
                item.setItemName(rs.getString("ItemName"));
                item.setDescn(rs.getString("Descn"));
                item.setPrice(rs.getDouble("Price"));
                item.setItemNumber(rs.getInt("ItemNumber"));
                item.setImgurl(rs.getString("ImgUrl"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(rs, psst, conn);
        }
        return item;
    }

    @Override
    public List<Item> getAllItem(int nowPage) {
        List<Item> list = new ArrayList<Item>();
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "select * from item limit ?,8";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            int begin = (nowPage-1)*8;
            psst.setInt(1, begin);
            rs = psst.executeQuery();
            Item item=null;
            while (rs.next()) {
                item=new Item();
                item.setItemId(rs.getInt("ItemId"));
                item.setDescn(rs.getString("Descn"));
                item.setPrice(rs.getDouble("Price"));
                item.setItemName(rs.getString("ItemName"));
                item.setItemNumber(rs.getInt("ItemNumber"));
                item.setImgurl(rs.getString("ImgUrl"));
                list.add(item);
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
    public List<Item> getAllPageByCategoryId(int nowPage, int categoryId) {
        List<Item> list = new ArrayList<Item>();
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "select * from item,classification where item.ItemId=classification.ItemId and classification.CategoryId=? limit ?,8 ";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            int page = (nowPage-1)*8;
            psst.setInt(1, categoryId);
            psst.setInt(2,page);
            rs = psst.executeQuery();
            Item item=null;
            while (rs.next()) {
                item=new Item();
                item.setItemId(rs.getInt("ItemId"));
                item.setDescn(rs.getString("Descn"));
                item.setPrice(rs.getDouble("Price"));
                item.setItemName(rs.getString("ItemName"));
                item.setItemNumber(rs.getInt("ItemNumber"));
                item.setImgurl(rs.getString("ImgUrl"));
                list.add(item);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(rs, psst, conn);
        }
        return list;
    }

    //获得总页数
    public int getPageNumber() {
        int dataNumber = 0;
        int pageNumber =0;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "select * from item ";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            rs = psst.executeQuery();
            while(rs.next()) {
                dataNumber++;
            }
            if(dataNumber<=8){
                pageNumber =1;
            }
            else{
                if(dataNumber%8==0){
                    pageNumber = dataNumber/8;
                }
                else{
                    pageNumber = dataNumber/8+1;
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

    @Override
    public int getPageNumber(int categoryId) {
        int dataNumber=0;
        int allPag=1;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "select * from item,classification where item.ItemId=classification.ItemId and classification.CategoryId=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setInt(1, categoryId);
            rs = psst.executeQuery();
            while (rs.next()) {
                dataNumber++;
            }
            if (dataNumber % 8 == 0) {
                allPag = dataNumber / 8;
            } else {
                allPag = dataNumber / 8 + 1;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(rs, psst, conn);
        }
        return allPag;
    }

    //
    @Override
    public int getPageNumber(String name) {
        int dataNumber=0;
        int allPag=1;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "select * from item where ItemName like '%"+name+"%'";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            rs = psst.executeQuery();
            while (rs.next()) {
                dataNumber++;
            }
            if (dataNumber % 8 == 0) {
                allPag = dataNumber / 8;
            } else {
                allPag = dataNumber / 8 + 1;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(rs, psst, conn);
        }
        return allPag;
    }

    @Override
    public boolean addItem(Item item) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        String sql="insert into item(ItemId,ItemName,Price,Descn,ItemNumber,ImgUrl) values(?,?,?,?,?,?)";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setInt(1,item.getItemId());
            psst.setString(2,item.getItemName());
            psst.setDouble(3,item.getPrice());
            psst.setString(4,item.getDescn());
            psst.setInt(5,item.getItemNumber());
            psst.setString(6,item.getImgurl());
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
    public boolean deleteItem(int id) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        String sql = "delete from item where ItemId=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setInt(1,id);
            psst.execute();
            flag = true;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(null, psst, conn);
        }
        return flag;

    }

    @Override
    public boolean modifyItem(Item item, int id) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "update item "+" set ItemName=?,Price=?,Descn=?,ItemNumber=?"+" where ItemId=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setString(1,item.getItemName());
            psst.setDouble(2,item.getPrice());
            psst.setString(3,item.getDescn());
            psst.setInt(4,item.getItemNumber());
            psst.setInt(5,id);
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
    public boolean isExistItemId(int id) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;

        String sql = "select * from item where ItemId=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setInt(1,id);
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
}
