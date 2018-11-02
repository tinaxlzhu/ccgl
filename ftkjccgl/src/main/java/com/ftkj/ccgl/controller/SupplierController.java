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
import com.ftkj.ccgl.mapper.SupplierMapper;
import com.ftkj.ccgl.model.Good;
import com.ftkj.ccgl.model.Supplier;
import com.ftkj.ccgl.service.SupplierService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
public class SupplierController extends CommonBean{
	
	@Autowired
	SupplierMapper supplierMapper;
	@Autowired
	SupplierService supplierService;
	/**
	 * 打开list页面
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/suppliers")
	public String listStock(Map map,HttpServletRequest request) throws Exception{
		return "supplier/list";
	}
	
	@RequestMapping(value = "/suppliers/list", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findAllByPage(@RequestParam("page") int currPage, @RequestParam("pageSize") int pageSize,
			@RequestParam("name") String name,HttpServletRequest request) {
		Supplier supplier = new Supplier();
		if (name != null && !"".equals(name)) {
			supplier.setName(name);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Page page =  PageHelper.startPage(currPage, pageSize, true);
		List<Supplier> list = supplierMapper.findSuppliersByPage(supplier);
		// 总条数
		resultMap.put("totalSize", page.getTotal());
		resultMap.put("totalPages", page.getPages());
		// 获取每页数据
		resultMap.put("rows", list);
		return resultMap;
	}
	
	//批量删除suppliers/1,2,3 DELETE
	@DeleteMapping("/suppliers/{id}")
	@ResponseBody
	public String deleteSuppliers(@PathVariable("id") String id,Map map) throws Exception {
		supplierService.deleteByPrimaryKeys(id);
		return "删除成功";
	}
	
	
	//批量删除supplier/1
	@DeleteMapping("/supplier/{id}")
	@ResponseBody
	public String deleteSupplierByKey(@PathVariable("id") Integer id,Map map) throws Exception {
		supplierService.deleteByPrimaryKey(id);
		return "删除成功";
	}
	
	

	//来到添加页面 supplier GET
	@GetMapping("/supplier")
	public String add(HttpServletRequest request) throws Exception{
		return "supplier/add";
	}
	/**
查询某个(来到修改页面)  supplier/1   GET
来到修改页面（查出进行信息回显） supplier/1 GET	 * @param request
	 * @param id
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/supplier/{id}")
	public String getSupplier(HttpServletRequest request,@PathVariable("id") Integer id, Map map) throws Exception{
		Supplier supplier = supplierMapper.selectByPrimaryKey(id);
		map.put("supplier", supplier);
		return "supplier/add";
	}
	
	/**
添加 supplier POST
	 * @param request
	 * @param id
	 * @param map
	 * @return
	 * @throws Exception
	 * @ModelAttribute Greeting greeting
	 */
	@PostMapping("/supplier")
	public String savesupplier(HttpServletRequest request,Supplier supplier, Map map) throws Exception{
		supplierService.saveSupplier(supplier);
		return "redirect:suppliers";
	}
	
	//修改supplier PUT
	@PutMapping("/supplier")
	public String updatesupplier(HttpServletRequest request,Supplier supplier, Map map) throws Exception{
		supplierService.updateByPrimaryKey(supplier);
		return "redirect:suppliers";
	}
}
