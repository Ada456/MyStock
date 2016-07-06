package com.ww.dao;

import com.ww.model.Jhdsp;

public interface JhdspMapper {
    int deleteByPrimaryKey(String djid);

    int insert(Jhdsp record);

    int insertSelective(Jhdsp record);

    Jhdsp selectByPrimaryKey(String djid);

    int updateByPrimaryKeySelective(Jhdsp record);

    int updateByPrimaryKey(Jhdsp record);
}