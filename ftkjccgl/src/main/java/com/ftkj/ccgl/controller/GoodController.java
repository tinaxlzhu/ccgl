package com.ftkj.ccgl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.ftkj.ccgl.mapper.GoodCategoriesMapper;
import com.ftkj.ccgl.mapper.GoodMapper;
import com.ftkj.ccgl.model.Good;
import com.ftkj.ccgl.model.GoodCategories;
import com.ftkj.ccgl.model.Supplier;
import com.ftkj.ccgl.service.GoodService;
import com.ftkj.ccgl.util.ResponseUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
public class GoodController {
	
	@Autowired
	GoodMapper goodMapper;
	@Autowired
	GoodCategoriesMapper goodCategoriesMapper;
	
	@Autowired
	GoodService goodService;
	
	@GetMapping("/goods")
	public String listStock(Map map,HttpServletRequest request) throws Exception{
		return "good/list";
	}
	
	@RequestMapping(value = "/goods/list", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findAllByPage(@RequestParam("page") int currPage, @RequestParam("pageSize") int pageSize,
			@RequestParam("goodname") String name,HttpServletRequest request) {
		Good good = new Good();
		if (name != null && !"".equals(name)) {
			good.setGoodname(name);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Page page =  PageHelper.startPage(currPage, pageSize, true);
		List<Good> list = goodMapper.selectGoods(good);
		// 总条数
		resultMap.put("totalSize", page.getTotal());
		resultMap.put("totalPages", page.getPages());
		// 获取每页数据
		resultMap.put("rows", list);
		return resultMap;
	}
	
	//来到添加页面 goods GET
	@GetMapping("/good")
	public String add(HttpServletRequest request) throws Exception{
		GoodCategories goodCategories = new GoodCategories();
		List<GoodCategories>  list = goodCategoriesMapper.selectGoodCategories(goodCategories);
		request.setAttribute("goodCategories", list);
		return "good/add";
	}
		/**
	查询某个(来到修改页面)  good/1   GET
	来到修改页面（查出进行信息回显） good/1 GET	 * @param request
		 * @param id
		 * @param map
		 * @return
		 * @throws Exception
		 */
	@GetMapping("/good/{id}")
	public String getGood(HttpServletRequest request,@PathVariable("id") Integer id, Map map) throws Exception{
		Good good = goodMapper.selectByPrimaryKey(id);
		GoodCategories goodCategories = new GoodCategories();
		List<GoodCategories>  list = goodCategoriesMapper.selectGoodCategories(goodCategories);
		request.setAttribute("goodCategories", list);
		map.put("good", good);
		return "good/add";
	}
		
		/**
	添加 good POST
		 * @param request
		 * @param id
		 * @param map
		 * @return
		 * @throws Exception
		 */
	@PostMapping("/good")
	public String saveGood(HttpServletRequest request,Good good, Map map) throws Exception{
		goodService.saveGood(good);
		map.put("msg", "保存成功");
		return "redirect:/goods";
	}
		
	//修改good PUT
	@PutMapping("/good")
	public String updateGood(HttpServletRequest request,Good good, Map map) throws Exception{
		goodService.updateByPrimaryKey(good);
		map.put("msg", "保存成功");
		return "redirect:/goods";
	}
		
	//删除good/1 DELETE
	@DeleteMapping("/good/{id}")
	@ResponseBody
	public String deleteGood(@PathVariable("id") Integer id,Map map) throws Exception {
		goodService.deleteByPrimaryKey(id);
		return "删除成功";
	}
	
	//删除good/1 DELETE
	@DeleteMapping("/goods/{id}")
	@ResponseBody
	public String deleteGoods(@PathVariable("id") String id,Map map) throws Exception {
		goodService.deleteByPrimaryKeys(id);
		return "删除成功";
	}
	
	@RequestMapping(value="/getListGoods", method = RequestMethod.GET)
	@ResponseBody
	public List<Good> getListGoods(HttpServletResponse rep) throws Exception{
		Good good = new Good();
		List<Good> list = goodMapper.selectGoods(good);
//		ResponseUtil.repJsonListRows(rep, list);
		return list;
	}
	
}
