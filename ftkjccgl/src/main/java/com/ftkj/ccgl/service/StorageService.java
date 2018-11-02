package com.ftkj.ccgl.service;

import com.ftkj.ccgl.model.Storage;
import com.ftkj.ccgl.model.User;

public interface StorageService {
	
	public void deleteByPrimaryKey(Integer id) throws Exception;
	
	public void deleteByPrimaryKeys(String ids) throws Exception;
	
	public int saveStorage(Storage Storage,User user) throws Exception;
	
	public int updateByPrimaryKey(Storage Storage,User user) throws Exception;

}
