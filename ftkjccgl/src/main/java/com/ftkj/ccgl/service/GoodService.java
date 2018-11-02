package com.ftkj.ccgl.service;


import java.util.List;

import com.ftkj.ccgl.model.Good;

public interface GoodService {
	
	public int deleteByPrimaryKey(Integer id) throws Exception;
	
	public int deleteByPrimaryKeys(String id) throws Exception;
	
	public int saveGood(Good good) throws Exception;
	
	public int updateByPrimaryKey(Good good) throws Exception;
}
