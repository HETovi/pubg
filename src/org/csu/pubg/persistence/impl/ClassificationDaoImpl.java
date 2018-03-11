package org.csu.pubg.persistence.impl;

import org.csu.pubg.domain.Classification;
import org.csu.pubg.persistence.BaseDao;
import org.csu.pubg.persistence.ClassificationDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liulin on 2017/9/21.
 */
public class ClassificationDaoImpl implements ClassificationDao {

    @Override
    public List<Integer> getItemIdByCategoryId(int categoryid) {
        List<Integer> list = new ArrayList<Integer>();

        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "select * from classification where CategoryId=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setInt(1, categoryid);
            rs = psst.executeQuery();
            while (rs.next()) {
             int itemid=rs.getInt("ItemId");
             list.add(itemid);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(rs, psst, conn);
        }
        return list;
    }

    public List<Classification> getClassByItemId(int id){
        List<Classification> list = new ArrayList<Classification>();
        Classification classification;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;

        String sql = "select * from Classification where ItemId=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setInt(1,id);
            rs = psst.executeQuery();
            int categoryId;
            while (rs.next()) {
                classification=new Classification();
                classification.setId(rs.getInt("Id"));
                classification.setItemId(rs.getInt("ItemId"));
                classification.setCategoryId(rs.getInt("CategoryId"));
                list.add(classification);
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
    public boolean addClassification(Classification classification) {

        boolean flag = false;
        Connection conn = null;
        PreparedStatement psst = null;
        String sql="insert into classification(ItemId,CategoryId) values(?,?)";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setInt(1,classification.getItemId());
            psst.setInt(2,classification.getCategoryId());
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
}
