package com.ww.dao;

import com.ww.model.Thd;

public interface ThdMapper {
    int deleteByPrimaryKey(String djid);

    int insert(Thd record);

    int insertSelective(Thd record);

    Thd selectByPrimaryKey(String djid);

    int updateByPrimaryKeySelective(Thd record);

    int updateByPrimaryKey(Thd record);
}