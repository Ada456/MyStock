package com.ww.dao;

import com.ww.model.Tkdsp;

public interface TkdspMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tkdsp record);

    int insertSelective(Tkdsp record);

    Tkdsp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tkdsp record);

    int updateByPrimaryKey(Tkdsp record);
}