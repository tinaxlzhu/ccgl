package com.ftkj.ccgl.mapper;

import java.util.List;

import com.ftkj.ccgl.model.Good;

public interface GoodMapper {

    int deleteByPrimaryKey(Integer id);
    
    int deleteByPrimaryKeys(List<Integer> id);

    int insert(Good record);

    int insertSelective(Good record);


    Good selectByPrimaryKey(Integer id);
    
    List<Good> selectGoods(Good good);

    List<Good> getGoodByGoodcategoriesId(Good good);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);
    
    
}