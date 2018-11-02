package com.ftkj.ccgl.component;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

/**
 * 国际化控制转换器
 * @author Administrator
 *
 */
public class MyLocaleResolver implements LocaleResolver {

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String l = request.getParameter("l");
		Locale locale = Locale.getDefault();
		if (!StringUtils.isEmpty(l)) {
			String[] strings = l.split("_");
			locale = new Locale(strings[0], strings[1]);
		}
		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		// TODO Auto-generated method stub
		
	}

}
