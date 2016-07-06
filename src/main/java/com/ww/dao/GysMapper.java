package com.ww.dao;

import com.ww.model.Gys;

public interface GysMapper {
    int deleteByPrimaryKey(Integer gysid);

    int insert(Gys record);

    int insertSelective(Gys record);

    Gys selectByPrimaryKey(Integer gysid);

    int updateByPrimaryKeySelective(Gys record);

    int updateByPrimaryKey(Gys record);
}