package com.ww.dao;

import com.ww.model.Spxx;

public interface SpxxMapper {
    int deleteByPrimaryKey(String spid);

    int insert(Spxx record);

    int insertSelective(Spxx record);

    Spxx selectByPrimaryKey(String spid);

    int updateByPrimaryKeySelective(Spxx record);

    int updateByPrimaryKey(Spxx record);
}