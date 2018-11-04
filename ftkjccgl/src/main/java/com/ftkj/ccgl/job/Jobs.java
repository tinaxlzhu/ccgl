package com.ftkj.ccgl.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ftkj.ccgl.dbBak.MySQLDatabaseBackup;


@Component
public class Jobs {
	
	Logger logger = LoggerFactory.getLogger(getClass());
			
    /**
     * 第一位，表示秒，取值0-59
* 第二位，表示分，取值0-59
* 第三位，表示小时，取值0-23
* 第四位，日期天/日，取值1-31
* 第五位，日期月份，取值1-12
* 第六位，星期，取值1-7，星期一，星期二...，注：不是第1周，第二周的意思
          另外：1表示星期天，2表示星期一。
* 第7为，年份，可以留空，取值1970-2099
* 
0 0 3 * * ?     每天3点执行
0 5 3 * * ?     每天3点5分执行
0 5 3 ? * *     每天3点5分执行，与上面作用相同
0 5/10 3 * * ?  每天3点的 5分，15分，25分，35分，45分，55分这几个时间点执行
0 10 3 ? * 1    每周星期天，3点10分 执行，注：1表示星期天    
0 10 3 ? * 1#3  每个月的第三个星期，星期天 执行，#号只能出现在星期的位置
* 
* (*)星号：可以理解为每的意思，每秒，每分，每天，每月，每年...
(?)问号：问号只能出现在日期和星期这两个位置。
(-)减号：表达一个范围，如在小时字段中使用“10-12”，则表示从10到12点，即10,11,12
(,)逗号：表达一个列表值，如在星期字段中使用“1,2,4”，则表示星期一，星期二，星期四
(/)斜杠：如：x/y，x是开始值，y是步长，比如在第一位（秒） 0/15就是，从0秒开始，每15秒，最后就是0，15，30，45，60    另：* / y，等同于0/y
     **/
    //表示每月最后一天号12点执行一次
    @Scheduled(cron="0 15 11 28 * ?")
	public void cronJob() {
		logger.info(new Date() + " ...>>cron....开启定时任务备份数据");
		try {
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			String currTime = format.format(date) + "-ccgl.sql";
			if (MySQLDatabaseBackup.exportDatabaseTool("127.0.0.1", "root", "123456", "D:/backupDatabase", currTime,
					"ccgl")) {
				logger.info("数据库成功备份！！！");
			} else {
				logger.info("数据库备份失败！！！");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
