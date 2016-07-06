package com.ww.dao;

import com.ww.model.Ckd;

public interface CkdMapper {
    int deleteByPrimaryKey(String djid);

    int insert(Ckd record);

    int insertSelective(Ckd record);

    Ckd selectByPrimaryKey(String djid);

    int updateByPrimaryKeySelective(Ckd record);

    int updateByPrimaryKey(Ckd record);
}