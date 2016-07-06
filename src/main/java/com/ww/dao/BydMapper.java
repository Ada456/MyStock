package com.ww.dao;

import com.ww.model.Byd;

public interface BydMapper {
    int deleteByPrimaryKey(String djid);

    int insert(Byd record);

    int insertSelective(Byd record);

    Byd selectByPrimaryKey(String djid);

    int updateByPrimaryKeySelective(Byd record);

    int updateByPrimaryKey(Byd record);
}