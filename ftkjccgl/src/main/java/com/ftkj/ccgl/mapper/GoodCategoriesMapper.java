package com.ftkj.ccgl.mapper;

import java.util.List;

import com.ftkj.ccgl.model.GoodCategories;

public interface GoodCategoriesMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(GoodCategories record);

    int insertSelective(GoodCategories record);


    GoodCategories selectByPrimaryKey(Integer id);
    
    List<GoodCategories> selectGoodCategories(GoodCategories goodCategories);

    int updateByPrimaryKeySelective(GoodCategories record);

    int updateByPrimaryKey(GoodCategories record);
    
    int deleteByPrimaryKeys(String ids);

}