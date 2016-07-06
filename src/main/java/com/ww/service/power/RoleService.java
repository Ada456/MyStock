package com.ww.service.power;

import com.ww.dao.RoleMapper;
import com.ww.dao.RoleMenuMapper;
import com.ww.model.Role;
import com.ww.model.RolemenuId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedProperties;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleList;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/3 0003.
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    /**
     * 从session中取值，不存在去数据库取
     * @param session
     * @return
     */
    public List<Role> getRoles(HttpSession session){
        List<Role> roles = (List<Role>) session.getAttribute("roles");
        if (roles == null || roles.size() == 0) {
            roles = getRoles();
            session.setAttribute("roles", roles);
        }
        return roles;
    }

    /**
     * 去数据库取值
     * @return
     */
    public List<Role> getRoles(){
        return roleMapper.selectAll();
    }

    public int addRole(Role role){
        return roleMapper.insertSelective(role);
    }


    public Role getRoleById(int roleid) {
        return roleMapper.selectByPrimaryKey(roleid);
    }

    public void updateRoleById(Role role) {
        roleMapper.updateByPrimaryKeySelective(role);
    }

    /**
     * 更新rolemenu表
     */
    public void updateRoleMenu(int roleid,Integer[] menuids) {
        deleteRoleMenuByRoleId(roleid);
        insertIntoRoleMenu(roleid,menuids);
    }

    public void insertIntoRoleMenu(int roleid , Integer[] menuids) {
        List<RolemenuId> rolemenuIds = new ArrayList<>();
        for (int menuid : menuids) {
            rolemenuIds.add(new RolemenuId(roleid, menuid));
        }
        roleMenuMapper.insert(rolemenuIds);
    }

    public void deleteRoleMenuByRoleId(int roleid){
        roleMenuMapper.deleteByRoleId(roleid);
    }

    public void deleteRoleById(int roleid){
        roleMapper.deleteByPrimaryKey(roleid);
    }

}
