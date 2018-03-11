package org.csu.pubg.persistence;

import org.csu.pubg.domain.RoleInfo;

import java.util.List;

/**
 * Created by Tovi on 2017/9/19.
 */
public interface RoleDao {
    //通过ID 获取权限
    RoleInfo getRoleByid(int id);
    List<RoleInfo> getAll();
}
