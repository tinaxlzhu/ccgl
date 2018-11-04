package com.ftkj.ccgl.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftkj.ccgl.dbBak.MySQLDatabaseBackup;
@Controller
public class BackupDBController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/dbbackup")
	public String openPage() {
		return "system/dbbackup";
	}

	@RequestMapping(value="/mysql/dbbackup",method=RequestMethod.POST)
	@ResponseBody
	public String dbBackup() {
		String msg = "";
		logger.info(new Date() + " 备份数据");
		try {
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			String currTime = format.format(date) + "-ccgl.sql";
			if (MySQLDatabaseBackup.exportDatabaseTool("127.0.0.1", "root", "123456", "D:/backupDatabase", currTime,
					"ccgl")) {
				logger.info("数据库成功备份！！！");
				msg =  "数据库成功备份！！！";
			} else {
				msg = "数据库备份失败！！！";
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			msg = "数据库备份失败！！！";
		}
		return msg;
	}

}
