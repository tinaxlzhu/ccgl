package com.ftkj.ccgl.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ftkj.ccgl.mapper.UserMapper;
import com.ftkj.ccgl.model.User;

@Controller // 除了标志这是一个controller外，还起到@ResponseBody这个作用即将结果返回到响应体中
public class LoginController {

	@Autowired
	UserMapper userMapper;
	
	@PostMapping("/user/login")
	public String getUser(@RequestParam("username") String username,@RequestParam("password") String pwd,HttpServletRequest
			request,Map map) {
		User user = userMapper.getUserByNamePwd(username,pwd);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			return "redirect:/main";
		}else {
			map.put("msg", "账号密码不正确，请检查");
			return "login";
		}
	}
	
	@GetMapping("/user/loginOut")
	public String loginOut(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "login";
	}
	
	

}
