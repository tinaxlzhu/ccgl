package com.ftkj.ccgl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftkj.ccgl.mapper.OperateMapper;
import com.ftkj.ccgl.service.OperateService;

@Service("operateService")
public class OperateServiceImpl implements OperateService {

	@Autowired
	OperateMapper operateMapper;
	@Override
	public void deleteByPrimaryKeys(String ids) throws Exception {
		// TODO Auto-generated method stub
		
		List<String> list = new ArrayList<String>();
		String[] idStrings = ids.split(",");
		for (String string : idStrings) {
			list.add(string);
		}
		operateMapper.deleteByPrimaryKeys(list);
	}

}
