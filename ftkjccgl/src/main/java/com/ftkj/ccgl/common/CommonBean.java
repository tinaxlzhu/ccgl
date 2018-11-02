package com.ftkj.ccgl.common;

import javax.servlet.http.HttpServletRequest;

import com.ftkj.ccgl.model.User;

public class CommonBean {
	
	public User getUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute("user");
	}

}
