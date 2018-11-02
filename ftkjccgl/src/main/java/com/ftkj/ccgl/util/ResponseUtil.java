package com.ftkj.ccgl.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;

public class ResponseUtil {
	
	public static void repJsonListRows(HttpServletResponse rep,List list) throws IOException{
		rep.setHeader("Pragma", "no-cache");
		rep.setHeader("Cache-Control", "no-cache, must-revalidate");
		rep.setHeader("Pragma", "no-cache");
        Map map = new HashMap();
        map.put("data", list);	
		JSONArray jsonArray = JSONArray.fromObject(map);
		String str = jsonArray.toString();
		String modifyed_str = str.substring(1,str.length()-1);
		rep.setContentType("text/json;charset=UTF-8");
		PrintWriter out = rep.getWriter();
		out.print(modifyed_str);
		rep.getWriter().flush();
		rep.getWriter().close();
	}
}
