package com.ftkj.ccgl.service;

import com.ftkj.ccgl.model.GoodCategories;

public interface GoodCategoriesService {
	
	public String deleteByPrimaryKey(Integer id) throws Exception;
	
	public String deleteByPrimaryKeys(String ids) throws Exception;
	
	public int saveGoodCategories(GoodCategories goodCategories) throws Exception;
	
	public int updateByPrimaryKey(GoodCategories goodCategories) throws Exception;

}
