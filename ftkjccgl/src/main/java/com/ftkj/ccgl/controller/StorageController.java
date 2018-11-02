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

import com.ftkj.ccgl.common.CommonBean;
import com.ftkj.ccgl.mapper.GoodMapper;
import com.ftkj.ccgl.mapper.StorageMapper;
import com.ftkj.ccgl.model.Good;
import com.ftkj.ccgl.model.Storage;
import com.ftkj.ccgl.model.Supplier;
import com.ftkj.ccgl.model.User;
import com.ftkj.ccgl.service.StorageService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;


@Controller // 除了标志这是一个controller外，还起到@ResponseBody这个作用即将结果返回到响应体中
public class StorageController extends CommonBean{

	@Autowired
	StorageMapper storageMapper;
	
	@Autowired
	StorageService storageService;
	
	@Autowired
	GoodMapper goodMapper;
	
	
	//查询所有 storageStocks GET
	@GetMapping("/storageStocks")
	public String listStock(Map map,HttpServletRequest request) throws Exception{
		return "storagestock/list";
	}
	
	@RequestMapping(value = "/storages/list", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findAllByPage(@RequestParam("page") int currPage, @RequestParam("pageSize") int pageSize,
			@RequestParam("goodName") String name,HttpServletRequest request) {
		Storage storage = new Storage();
		if (name != null && !"".equals(name)) {
			storage.setGoodname(name);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Page page =  PageHelper.startPage(currPage, pageSize, true);
		List<Storage> list = storageMapper.selectByStorage(storage);
		// 总条数
		resultMap.put("totalSize", page.getTotal());
		resultMap.put("totalPages", page.getPages());
		// 获取每页数据
		resultMap.put("rows", list);
		return resultMap;
	}
	
	//来到添加页面 storage GET
	@GetMapping("/storage")
	public String add(HttpServletRequest request) throws Exception{
		return "storagestock/add";
	}
	/**
查询某个(来到修改页面)  storage/1   GET
来到修改页面（查出进行信息回显） storage/1 GET	 * @param request
	 * @param id
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/storage/{id}")
	public String getStorage(HttpServletRequest request,@PathVariable("id") Integer id, Map map) throws Exception{
		Storage storage = storageMapper.selectByPrimaryKey(id);
		Integer goodid = storage.getGoodid();
		Good good = goodMapper.selectByPrimaryKey(goodid);
		storage.setGoodname(good.getGoodname());
		map.put("storage", storage);
		return "storagestock/add";
	}
	
	/**
添加 storage POST
	 * @param request
	 * @param id
	 * @param map
	 * @return
	 * @throws Exception
	 * @ModelAttribute Greeting greeting
	 */
	@PostMapping("/storage")
	public String saveStorage(HttpServletRequest request,Storage storage, Map map) throws Exception{
		User user = getUser(request);
		storageService.saveStorage(storage, user);
		map.put("msg", "保存成功");
		return "redirect:storageStocks";
	}
	
	
	
	//修改storage PUT
	@PutMapping("/storage")
	public String updateStorage(HttpServletRequest request,Storage storage, Map map) throws Exception{
		User user = getUser(request);
		storageService.updateByPrimaryKey(storage, user);
		map.put("msg", "保存成功");
		return "redirect:storageStocks";
	}
	
	//删除storage/1 DELETE
	@DeleteMapping("/storage/{id}")
	@ResponseBody
	public String deleteStorage(@PathVariable("id") Integer id,Map map) throws Exception {
		storageService.deleteByPrimaryKey(id);
		return "删除成功";
	}
	
	//批量删除storages/1,2,3 DELETE
	@DeleteMapping("/storages/{id}")
	@ResponseBody
	public String deleteStorages(@PathVariable("id") String id,Map map) throws Exception {
		storageService.deleteByPrimaryKeys(id);
		return "删除成功";
	}
	
	
	@RequestMapping(value="/getListStorages", method = RequestMethod.GET)
	@ResponseBody
	public List<Storage> getListStorages(HttpServletResponse rep) throws Exception{
		Storage record = new Storage();
		List<Storage> list = storageMapper.selectByStorage(record);
//		ResponseUtil.repJsonListRows(rep, list);
		return list;
	}
	
	
	
	

}
