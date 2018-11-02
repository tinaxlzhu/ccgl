package com.ftkj.ccgl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftkj.ccgl.mapper.GoodMapper;
import com.ftkj.ccgl.model.Good;
import com.ftkj.ccgl.service.GoodService;

@Service("goodService")
public class GoodServiceImpl implements GoodService{

	@Autowired
	GoodMapper goodMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return goodMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int saveGood(Good good) throws Exception {
		// TODO Auto-gednerated method stub
		return goodMapper.insert(good);
	}

	@Override
	public int updateByPrimaryKey(Good good) throws Exception {
		// TODO Auto-generated method stub
		return goodMapper.updateByPrimaryKey(good);
	}

	@Override
	public int deleteByPrimaryKeys(String id) throws Exception {
		// TODO Auto-generated method stub
		String[] strings = id.split(",");
		List<Integer> list = new ArrayList<Integer>();
		for (String string : strings) {
			list.add(Integer.parseInt(string));
		}
		return goodMapper.deleteByPrimaryKeys(list);
	}
	

}
