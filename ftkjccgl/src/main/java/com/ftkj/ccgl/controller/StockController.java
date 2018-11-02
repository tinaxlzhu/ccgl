package com.ftkj.ccgl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftkj.ccgl.mapper.StockMapper;
import com.ftkj.ccgl.model.Stock;
import com.ftkj.ccgl.model.Supplier;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller // 除了标志这是一个controller外，还起到@ResponseBody这个作用即将结果返回到响应体中
public class StockController {

	@Autowired
	StockMapper stockMapper;
	
	@GetMapping("/stocks")
	public String listStock(Map map,HttpServletRequest request) throws Exception{
		return "stock/list";
	}
	

	@RequestMapping(value = "/stocks/list", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findAllByPage(@RequestParam("page") int currPage, @RequestParam("pageSize") int pageSize,
			@RequestParam("goodName") String name,HttpServletRequest request) {
		Stock stock = new Stock();
		if (name != null && !"".equals(name)) {
			stock.setGoodname(name);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Page page =  PageHelper.startPage(currPage, pageSize, true);
		List<Stock> list = stockMapper.selectByStock(stock);
		// 总条数
		resultMap.put("totalSize", page.getTotal());
		resultMap.put("totalPages", page.getPages());
		// 获取每页数据
		resultMap.put("rows", list);
		return resultMap;
	}

}
