package com.ww.dao;

import com.ww.model.Kh;

public interface KhMapper {
    int deleteByPrimaryKey(Integer khid);

    int insert(Kh record);

    int insertSelective(Kh record);

    Kh selectByPrimaryKey(Integer khid);

    int updateByPrimaryKeySelective(Kh record);

    int updateByPrimaryKey(Kh record);
}