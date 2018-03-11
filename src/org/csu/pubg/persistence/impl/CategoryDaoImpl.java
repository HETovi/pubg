package org.csu.pubg.persistence.impl;


import org.csu.pubg.domain.Category;
import org.csu.pubg.persistence.CategoryDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.csu.pubg.persistence.BaseDao;

/**
 * Created by Tovi on 2017/9/19.
 */
public class CategoryDaoImpl implements CategoryDao {
    @Override
    //查询出所有最大分类的Id
    public List<String> findAllCategoriesId() {
        List<String> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "select CategoryId  from category where ParentId=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setString(1,"");
            rs = psst.executeQuery();
            if (rs.next()) {
                list.add(String.valueOf(rs.getInt("categoryId")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(rs, psst, conn);
        }
        return list;


    }

    @Override
    //查询出所有的最大分类
    public List<Category> getCategoryList() {

        List<Category> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "select *  from category where ParentId=0";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            rs = psst.executeQuery();
            Category category = null;
            while (rs.next()) {
                category = new Category();
                category.setCategoryId(rs.getInt("CategoryId"));
                category.setCategoryName(rs.getString("CategoryName"));
                category.setDescn(rs.getString("Descn"));
                list.add(category);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(rs, psst, conn);
        }
        return list;
    }

    @Override
    //通过 categoryID获取category
    public Category getCategoryBycategoryId(int categoryId) {
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "select *  from category where CategoryId=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setInt(1, categoryId);
            rs = psst.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCategoryId(rs.getInt("CategoryId"));
                category.setCategoryName(rs.getString("CategoryName"));
                category.setDescn(rs.getString("Descn"));
                category.setParentId(rs.getString("ParentId"));

                return category;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(rs, psst, conn);
        }
        return null;
    }

    @Override
    //通过 parentID获取category，以list形式返回
    public List<Category> getCategoryListByParentId(String parentId) {
        List<Category> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "select *  from category where ParentId=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setString(1,parentId);
            rs = psst.executeQuery();
            Category category = null;
            if (rs.next()) {
                category = new Category();
                category.setCategoryId(rs.getInt("CategoryId"));
                category.setCategoryName(rs.getString("CategoryName"));
                category.setDescn(rs.getString("Descn"));
                category.setParentId(rs.getString("ParentId"));
                list.add(category);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(rs, psst, conn);
        }
        return list;
    }
}

