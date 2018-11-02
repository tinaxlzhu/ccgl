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

import com.ftkj.ccgl.mapper.GoodCategoriesMapper;
import com.ftkj.ccgl.model.GoodCategories;
import com.ftkj.ccgl.model.Supplier;
import com.ftkj.ccgl.service.GoodCategoriesService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
public class GoodCategoriesController {
	
	@Autowired
	GoodCategoriesMapper goodCategoriesMapper;
	
	@Autowired
	GoodCategoriesService goodCategoriesService;
	
	@GetMapping("/goodcategories")
	public String listStock(Map map,HttpServletRequest request) throws Exception{
		return "goodCategorie/list";
	}
	
	@RequestMapping(value = "/goodcategories/list", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findAllByPage(@RequestParam("page") int currPage, @RequestParam("pageSize") int pageSize,
			@RequestParam("goodname") String name,HttpServletRequest request) {
		GoodCategories goodCategories = new GoodCategories();
		if (name != null && !"".equals(name)) {
			goodCategories.setGoodname(name);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Page page =  PageHelper.startPage(currPage, pageSize, true);
		List<GoodCategories> list = goodCategoriesMapper.selectGoodCategories(goodCategories);		// 总条数
		resultMap.put("totalSize", page.getTotal());
		resultMap.put("totalPages", page.getPages());
		// 获取每页数据
		resultMap.put("rows", list);
		return resultMap;
	}
	
	//来到添加页面 goodcategorie GET
	@GetMapping("/goodcategorie")
	public String add(HttpServletRequest request) throws Exception{
		
		return "goodCategorie/add";
	}
		/**
	查询某个(来到修改页面)  goodcategorie/1   GET
	来到修改页面（查出进行信息回显） goodcategorie/1 GET	 * @param request
		 * @param id
		 * @param map
		 * @return
		 * @throws Exception
		 */
	@GetMapping("/goodcategorie/{id}")
	public String getGoodCategories(HttpServletRequest request,@PathVariable("id") Integer id, Map map) throws Exception{
		GoodCategories goodcategorie = goodCategoriesMapper.selectByPrimaryKey(id);
		map.put("goodcategorie", goodcategorie);
		return "goodCategorie/add";
	}
		
		/**
	添加 goodcategorie POST
		 * @param request
		 * @param id
		 * @param map
		 * @return
		 * @throws Exception
		 */
	@PostMapping("/goodcategorie")
	public String saveGoodCategories(HttpServletRequest request,GoodCategories goodcategorie, Map map) throws Exception{
		goodCategoriesService.saveGoodCategories(goodcategorie);
		map.put("msg", "保存成功");
		return "redirect:goodcategories";
	}
		
		//修改goodcategorie PUT
	@PutMapping("/goodcategorie")
	public String updateGoodCategories(HttpServletRequest request,GoodCategories goodcategorie, Map map) throws Exception{
		goodCategoriesService.updateByPrimaryKey(goodcategorie);
		map.put("msg", "保存成功");
		return "redirect:goodcategories";
	}
		
		//删除goodcategorie/1 DELETE
	@DeleteMapping("/goodcategorie/{id}")
	@ResponseBody
	public String deleteGoodCategories(@PathVariable("id") Integer id,Map map) throws Exception {
		String string = goodCategoriesService.deleteByPrimaryKey(id);
		
		if (string.equals("2")) {//该类产品下已添加产品信息，不能删除
			return "删除失败，该类别下面有商品，不能删除!";
		}else if(string.equals("0")) {//删除失败
			return "删除失败，请联系管理员";
		}else {
			return "删除成功";
		}
	}
	
	@DeleteMapping("/goodcategories/{ids}")
	@ResponseBody
	public String deleteGoodCategories(@PathVariable("ids") String ids,Map map) throws Exception {
		String string = goodCategoriesService.deleteByPrimaryKeys(ids);
//		if (string.equals("2")) {//该类产品下已添加产品信息，不能删除
//			return "删除失败，该类别下面有商品，不能删除!";
//		}else if(string.equals("0")) {//删除失败
//			return "删除失败，请联系管理员";
//		}else {
			return "删除成功";
//		}
	}
	
}
