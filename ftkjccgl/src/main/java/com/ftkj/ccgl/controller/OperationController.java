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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftkj.ccgl.mapper.OperateMapper;
import com.ftkj.ccgl.model.Operate;
import com.ftkj.ccgl.model.Supplier;
import com.ftkj.ccgl.service.OperateService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
public class OperationController {

	@Autowired
	OperateMapper operateMapper;
	@Autowired
	OperateService operateService;
	
	@GetMapping("/operations")
	public String listStock(Map map,HttpServletRequest request) throws Exception{
		return "operation/list";
	}
	

	@RequestMapping(value = "/operations/list", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findAllByPage(@RequestParam("page") int currPage, @RequestParam("pageSize") int pageSize,
			@RequestParam("goodName") String name,HttpServletRequest request) {
		Operate operate = new Operate();
		if (name != null && !"".equals(name)) {
			operate.setGoodname(name);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Page page =  PageHelper.startPage(currPage, pageSize, true);
		List<Operate> list = operateMapper.selectByOperate(operate);
		// 总条数
		resultMap.put("totalSize", page.getTotal());
		resultMap.put("totalPages", page.getPages());
		// 获取每页数据
		resultMap.put("rows", list);
		return resultMap;
	}
	
	//批量删除storages/1,2,3 DELETE
	@DeleteMapping("/operations/{id}")
	@ResponseBody
	public String deleteOperations(@PathVariable("id") String id,Map map) throws Exception {
		operateService.deleteByPrimaryKeys(id);
		return "删除成功";
	}

}
