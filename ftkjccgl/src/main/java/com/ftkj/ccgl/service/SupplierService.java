package com.ftkj.ccgl.service;

import org.springframework.stereotype.Service;

import com.ftkj.ccgl.model.Supplier;

@Service
public interface SupplierService {
	
	public void deleteByPrimaryKey(Integer id) throws Exception;
	
	public void deleteByPrimaryKeys(String ids) throws Exception;
	
	public int saveSupplier(Supplier supplier) throws Exception;
	
	public int updateByPrimaryKey(Supplier supplier) throws Exception;

}
