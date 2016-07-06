package com.ww.dao;

import com.ww.model.Thdsp;

public interface ThdspMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Thdsp record);

    int insertSelective(Thdsp record);

    Thdsp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Thdsp record);

    int updateByPrimaryKey(Thdsp record);
}