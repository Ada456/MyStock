package com.ww.dao;

import com.ww.model.Spdw;

public interface SpdwMapper {
    int deleteByPrimaryKey(Integer dwid);

    int insert(Spdw record);

    int insertSelective(Spdw record);

    Spdw selectByPrimaryKey(Integer dwid);

    int updateByPrimaryKeySelective(Spdw record);

    int updateByPrimaryKey(Spdw record);
}