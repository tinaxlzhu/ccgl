package com.ftkj.ccgl.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftkj.ccgl.mapper.OperateMapper;
import com.ftkj.ccgl.mapper.OutStockMapper;
import com.ftkj.ccgl.mapper.StockMapper;
import com.ftkj.ccgl.model.Operate;
import com.ftkj.ccgl.model.OutStock;
import com.ftkj.ccgl.model.Stock;
import com.ftkj.ccgl.model.User;
import com.ftkj.ccgl.service.OutStockService;

@Service("outStockService")
public class OutStockServiceImpl implements OutStockService {
	@Autowired
	OutStockMapper outStockMapper;
	@Autowired
	OperateMapper operateMapper;
	@Autowired
	StockMapper stockMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return outStockMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public void deleteByPrimaryKeys(String ids) throws Exception {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		
		String[] strings = ids.split(",");
		for (String string : strings) {
			list.add(string);
		}
		outStockMapper.deleteByPrimaryKeys(list);
	}

	@Override
	public String saveOutStock(OutStock OutStock, User user) throws Exception {
		// TODO Auto-generated method stub
		
		//保存出货单
		outStockMapper.insert(OutStock);

		// 保存操作历史
		Operate operate = new Operate();
		operate.setGoodid(OutStock.getGoodid());
		operate.setUserid(user.getId());
		operate.setOperatetime(new Date());
		operate.setOperatetype(2);
		operate.setRemark(OutStock.getOutstocknote());
		operateMapper.insert(operate);
		
		return "1";
	}

	@Override
	public int updateByPrimaryKey(OutStock OutStock,User user) throws Exception {
		// TODO Auto-generated method stub
		//更新出库信息
		OutStock.setOutstocknumber(OutStock.getOutstocknumber());
		outStockMapper.updateByPrimaryKey(OutStock);
		
		//保存操作历史
		Operate operate = new Operate();
		operate.setGoodid(OutStock.getGoodid());
		operate.setUserid(user.getId());
		operate.setOperatetime(new Date());
		operate.setOperatetype(2);//1：入库2：出库
		operate.setRemark(OutStock.getOutstocknote());
		operateMapper.insert(operate);
		
		return 1;
	}

	
}
