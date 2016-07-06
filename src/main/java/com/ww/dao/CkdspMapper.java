package com.ww.dao;

import com.ww.model.Ckdsp;

public interface CkdspMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ckdsp record);

    int insertSelective(Ckdsp record);

    Ckdsp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ckdsp record);

    int updateByPrimaryKey(Ckdsp record);
}