package com.ww.dao;

import com.ww.model.Role;
import com.ww.model.RolemenuId;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectAll();

    /** 更新rolemenu表中对应关系*/
    int updateRoleMenuid(List<RolemenuId> rolemenuIds);

}