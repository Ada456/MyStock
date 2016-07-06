package com.ww.dao;

import com.ww.model.Bydsp;

public interface BydspMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bydsp record);

    int insertSelective(Bydsp record);

    Bydsp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bydsp record);

    int updateByPrimaryKey(Bydsp record);
}