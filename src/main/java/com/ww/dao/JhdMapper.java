package com.ww.dao;

import com.ww.model.Jhd;

public interface JhdMapper {
    int deleteByPrimaryKey(String djid);

    int insert(Jhd record);

    int insertSelective(Jhd record);

    Jhd selectByPrimaryKey(String djid);

    int updateByPrimaryKeySelective(Jhd record);

    int updateByPrimaryKey(Jhd record);
}