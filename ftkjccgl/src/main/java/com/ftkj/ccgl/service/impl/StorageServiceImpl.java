package com.ftkj.ccgl.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftkj.ccgl.mapper.OperateMapper;
import com.ftkj.ccgl.mapper.StockMapper;
import com.ftkj.ccgl.mapper.StorageMapper;
import com.ftkj.ccgl.model.Operate;
import com.ftkj.ccgl.model.Stock;
import com.ftkj.ccgl.model.Storage;
import com.ftkj.ccgl.model.User;
import com.ftkj.ccgl.service.StorageService;

@Service("storageService")
public class StorageServiceImpl implements StorageService {

	@Autowired
	StorageMapper storageMapper;
	
	@Autowired
	StockMapper stockMapper;
	
	@Autowired
	OperateMapper operateMapper;

	@Override
	public int saveStorage(Storage Storage,User user) throws Exception {
		// TODO Auto-generated method stub
		//保存入库信息
		storageMapper.insert(Storage);
		
		//保存操作历史
		Operate operate = new Operate();
		operate.setGoodid(Storage.getGoodid());
		operate.setUserid(user.getId());
		operate.setOperatetime(new Date());
		operate.setOperatetype(1);//1：入库2：出库
		operate.setRemark(Storage.getStoragenote());
		operateMapper.insert(operate);
		return 1;
	}

	@Override
	public int updateByPrimaryKey(Storage Storage,User user) throws Exception {
		// TODO Auto-generated method stub
		//更新入库信息
		storageMapper.updateByPrimaryKey(Storage);
		
		//保存操作历史
		Operate operate = new Operate();
		operate.setGoodid(Storage.getGoodid());
		operate.setUserid(user.getId());
		operate.setOperatetime(new Date());
		operate.setOperatetype(1);//1：入库2：出库
		operate.setRemark(Storage.getStoragenote());
		operateMapper.insert(operate);
		return 1;
	}

	@Override
	public void deleteByPrimaryKey(Integer id) throws Exception {
		storageMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteByPrimaryKeys(String ids) throws Exception {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		
		String[] strings = ids.split(",");
		for (String string : strings) {
			list.add(string);
		}
		storageMapper.deleteByPrimaryKeys(list);
	}

}
