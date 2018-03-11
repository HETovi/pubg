package org.csu.pubg.persistence.impl;

import org.csu.pubg.domain.RoleInfo;
import org.csu.pubg.persistence.RoleDao;
import org.csu.pubg.persistence.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tovi on 2017/9/19.
 */
public class RoleDaoImpl implements RoleDao {
    @Override
    public RoleInfo getRoleByid(int id) {
        RoleInfo ri=null;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "select * from role where Id=?";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            psst.setInt(1,id);
            rs = psst.executeQuery();

            if (rs.next()) {
                ri=new RoleInfo();
                ri.setId(rs.getInt("Id"));
                ri.setName(rs.getString("RoleName"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(rs, psst, conn);
        }
        return ri;
    }

    @Override
    public List<RoleInfo> getAll() {
        List<RoleInfo>list = new ArrayList<RoleInfo>();
        RoleInfo ri=null;
        Connection conn = null;
        PreparedStatement psst = null;
        ResultSet rs = null;
        String sql = "select * from role ";
        try {
            conn = BaseDao.openConnection();
            psst = conn.prepareStatement(sql);
            rs = psst.executeQuery();

            while (rs.next()) {
                ri=new RoleInfo();
                ri.setId(rs.getInt("Id"));
                ri.setName(rs.getString("RoleName"));
                list.add(ri);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeAll(rs, psst, conn);
        }
        return list;

    }
}
