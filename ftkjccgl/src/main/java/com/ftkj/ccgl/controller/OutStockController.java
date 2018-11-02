package com.ftkj.ccgl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftkj.ccgl.common.CommonBean;
import com.ftkj.ccgl.mapper.GoodMapper;
import com.ftkj.ccgl.mapper.OutStockMapper;
import com.ftkj.ccgl.mapper.StorageMapper;
import com.ftkj.ccgl.model.Good;
import com.ftkj.ccgl.model.OutStock;
import com.ftkj.ccgl.model.Supplier;
import com.ftkj.ccgl.model.User;
import com.ftkj.ccgl.service.OutStockService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller // 除了标志这是一个controller外，还起到@ResponseBody这个作用即将结果返回到响应体中
public class OutStockController extends CommonBean{

	@Autowired
	OutStockMapper outStockMapper;
	@Autowired
	StorageMapper storageMapper;
	@Autowired
	OutStockService outStockService;
	@Autowired
	GoodMapper goodMapper;
	
	@GetMapping("/outStocks")
	public String listStock(Map map,HttpServletRequest request) throws Exception{
		return "outstock/list";
	}
	

	@RequestMapping(value = "/outStocks/list", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findAllByPage(@RequestParam("page") int currPage, @RequestParam("pageSize") int pageSize,
			@RequestParam("goodName") String name,HttpServletRequest request) {
		OutStock outStock = new OutStock();
		if (name != null && !"".equals(name)) {
			outStock.setGoodname(name);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Page page =  PageHelper.startPage(currPage, pageSize, true);
		List<OutStock> list = outStockMapper.selectByOutStock(outStock);
		// 总条数
		resultMap.put("totalSize", page.getTotal());
		resultMap.put("totalPages", page.getPages());
		// 获取每页数据
		resultMap.put("rows", list);
		return resultMap;
	}
	
	//来到添加页面 outstock GET
	@GetMapping("/outstock")
	public String add(HttpServletRequest request) throws Exception{
		return "outstock/add";
	}
	/**
	查询某个(来到修改页面)  outstock/1   GET
	来到修改页面（查出进行信息回显） outstock/1 GET	 * @param request
	 * @param id
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/outstock/{id}")
	public String getOutstock(HttpServletRequest request,@PathVariable("id") Integer id, Map map) throws Exception{
		OutStock outStock = outStockMapper.selectByPrimaryKey(id);
		Integer goodid = outStock.getGoodid();
		Good g = goodMapper.selectByPrimaryKey(goodid);
		outStock.setGoodname(g.getGoodname());
		map.put("outStock", outStock);
		return "outstock/add";
	}
	
	/**
	添加 storage POST
	 * @param request
	 * @param id
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/outstock")
	public String saveOutstock(HttpServletRequest request,OutStock outStock, Map map) throws Exception{
		User user = getUser(request);
		outStockService.saveOutStock(outStock, user);
		map.put("msg", "保存成功");
		return "redirect:outStocks";
	}
	
	//修改outstock PUT
	@PutMapping("/outstock")
	public String updateOutstock(HttpServletRequest request,OutStock outStock, Map map) throws Exception{
		User user = getUser(request);
		outStockService.updateByPrimaryKey(outStock, user);
		map.put("msg", "保存成功");
		return "redirect:outStocks";
	}
	
	//删除outstock/1 DELETE
	@DeleteMapping("/outstock/{id}")
	@ResponseBody
	public String deleteOutstock(@PathVariable("id") Integer id,Map map) throws Exception {
		outStockService.deleteByPrimaryKey(id);
		return "删除成功";
	}
	
	@DeleteMapping("/outstocks/{id}")
	@ResponseBody
	public String deleteOutstocks(@PathVariable("id") String id,Map map) throws Exception {
		outStockService.deleteByPrimaryKeys(id);
		return "删除成功";
	}

}
