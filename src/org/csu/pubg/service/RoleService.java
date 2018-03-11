package org.csu.pubg.service;

import org.csu.pubg.domain.RoleInfo;
import org.csu.pubg.persistence.RoleDao;
import org.csu.pubg.persistence.impl.RoleDaoImpl;

import java.util.List;

/**
 * Created by Tovi on 2017/9/23.
 */
public class RoleService {
    private RoleDao roleDao;
    public RoleService(){
        roleDao = new RoleDaoImpl();
    }
    public List<RoleInfo> getAll(){
        return roleDao.getAll();
    }
    public RoleInfo getRoleById(int id){
        return roleDao.getRoleByid(id);
    }
}
