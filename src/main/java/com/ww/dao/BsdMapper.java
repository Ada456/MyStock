package com.ww.dao;

import com.ww.model.Bsd;

public interface BsdMapper {
    int deleteByPrimaryKey(String djid);

    int insert(Bsd record);

    int insertSelective(Bsd record);

    Bsd selectByPrimaryKey(String djid);

    int updateByPrimaryKeySelective(Bsd record);

    int updateByPrimaryKey(Bsd record);
}