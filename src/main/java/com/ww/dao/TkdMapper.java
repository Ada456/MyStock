package com.ww.dao;

import com.ww.model.Tkd;

public interface TkdMapper {
    int deleteByPrimaryKey(String djid);

    int insert(Tkd record);

    int insertSelective(Tkd record);

    Tkd selectByPrimaryKey(String djid);

    int updateByPrimaryKeySelective(Tkd record);

    int updateByPrimaryKey(Tkd record);
}