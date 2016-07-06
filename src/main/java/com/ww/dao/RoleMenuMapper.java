package com.ww.dao;

import com.ww.model.Role;
import com.ww.model.RolemenuId;

import java.util.List;

public interface RoleMenuMapper {
    int deleteByPrimaryKey(RolemenuId key);

    int insert(List<RolemenuId> rolemenuIds);


    int insertSelective(RolemenuId record);

    int deleteByRoleId(int roleid);
}