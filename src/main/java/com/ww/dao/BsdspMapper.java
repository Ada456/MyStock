package com.ww.dao;

import com.ww.model.Bsdsp;

public interface BsdspMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bsdsp record);

    int insertSelective(Bsdsp record);

    Bsdsp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bsdsp record);

    int updateByPrimaryKey(Bsdsp record);
}