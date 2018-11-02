package com.ftkj.ccgl.service;

import com.ftkj.ccgl.model.OutStock;
import com.ftkj.ccgl.model.User;

public interface OutStockService {
	
	public int deleteByPrimaryKey(Integer id) throws Exception;
	
	public void deleteByPrimaryKeys(String ids) throws Exception ;
	
	public String saveOutStock(OutStock OutStock, User user) throws Exception;
	
	public int updateByPrimaryKey(OutStock OutStock, User user) throws Exception;

}
