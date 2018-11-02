package com.ftkj.ccgl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftkj.ccgl.mapper.SupplierMapper;
import com.ftkj.ccgl.model.Supplier;
import com.ftkj.ccgl.service.SupplierService;

@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	SupplierMapper supplierMapper;

	@Override
	public void deleteByPrimaryKey(Integer id) throws Exception {
		// TODO Auto-generated method stub
		supplierMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteByPrimaryKeys(String ids) throws Exception {
		// TODO Auto-generated method stub
		List<Integer> idList = new ArrayList<Integer>();
		String[] strings = ids.split(",");	
		for (String string : strings) {
			idList.add(Integer.parseInt(string));
		}
		supplierMapper.deleteByPrimaryKeys(idList);
	}

	@Override
	public int saveSupplier(Supplier supplier) throws Exception {
		// TODO Auto-generated method stub
		return supplierMapper.insert(supplier);
	}

	@Override
	public int updateByPrimaryKey(Supplier supplier) throws Exception {
		// TODO Auto-generated method stub
		return supplierMapper.updateByPrimaryKey(supplier);
	}

}
