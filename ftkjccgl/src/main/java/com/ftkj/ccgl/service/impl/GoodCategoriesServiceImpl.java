package com.ftkj.ccgl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftkj.ccgl.mapper.GoodCategoriesMapper;
import com.ftkj.ccgl.mapper.GoodMapper;
import com.ftkj.ccgl.model.Good;
import com.ftkj.ccgl.model.GoodCategories;
import com.ftkj.ccgl.service.GoodCategoriesService;

@Service("goodCategoriesService")
public class GoodCategoriesServiceImpl implements GoodCategoriesService {
	
	@Autowired
	GoodMapper goodMapper;
	@Autowired
	GoodCategoriesMapper goodCategoriesMapper;

	@Override
	public String deleteByPrimaryKey(Integer id) throws Exception {
		// TODO Auto-generated method stub
		String resultCode="";
		//检查该类产品是否有添加产品信息
		Good good = new Good();
		good.setGoodcategoriesid(id);
	    List<Good> goods = goodMapper.getGoodByGoodcategoriesId(good);
	    if (goods != null && goods.size() > 0) {
	    	resultCode = "2";
	    	return resultCode;
		}else {
			
			 int delNums = goodCategoriesMapper.deleteByPrimaryKey(id);
		      if (delNums > 0) {
		        resultCode = "1";
		      } else {
			        resultCode = "0";
		      }
	    	return resultCode;
		}
	}

	@Override
	public int saveGoodCategories(GoodCategories goodCategories) throws Exception {
		// TODO Auto-generated method stub
		return goodCategoriesMapper.insert(goodCategories);
	}

	@Override
	public int updateByPrimaryKey(GoodCategories goodCategories) throws Exception {
		// TODO Auto-generated method stub
		
		return goodCategoriesMapper.updateByPrimaryKey(goodCategories);
	}

	@Override
	public String deleteByPrimaryKeys(String ids) throws Exception {
		// TODO Auto-generated method stub
		return goodCategoriesMapper.deleteByPrimaryKeys(ids)+"";
	}

}
