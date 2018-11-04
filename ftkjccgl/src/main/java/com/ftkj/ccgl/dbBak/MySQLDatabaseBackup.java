package com.ftkj.ccgl.dbBak;

import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;  
import java.io.OutputStreamWriter;  
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;  
  
/** 
 * MySQL数据库备份 
 *  
 * @author GaoHuanjie 
 */  
public class MySQLDatabaseBackup {  
	
	Logger logger = LoggerFactory.getLogger(getClass());

	
	public static void backup() {
        try {
            Runtime rt = Runtime.getRuntime();
 
            // 调用 调用mysql的安装目录的命令
            Process child = rt
                    .exec("mysqldump -h localhost -uroot -p123456 ccgl");
            // 设置导出编码为utf-8。这里必须是utf-8
            // 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行
            InputStream in = child.getInputStream();// 控制台的输出信息作为输入流
 
            InputStreamReader xx = new InputStreamReader(in, "utf-8");
            // 设置输出流编码为utf-8。这里必须是utf-8，否则从流中读入的是乱码
 
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            // 组合控制台输出信息字符串
            BufferedReader br = new BufferedReader(xx);
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();
 
            // 要用来做导入用的sql目标文件：
            FileOutputStream fout = new FileOutputStream("d:\\test1111.sql");
            OutputStreamWriter writer = new OutputStreamWriter(fout, "utf-8");
            writer.write(outStr);
            writer.flush();
            in.close();
            xx.close();
            br.close();
            writer.close();
            fout.close();
 
            System.out.println("");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
	
  
    /** 
     * Java代码实现MySQL数据库导出 
     *  
     * @author GaoHuanjie 
     * @param hostIP MySQL数据库所在服务器地址IP 
     * @param userName 进入数据库所需要的用户名 
     * @param password 进入数据库所需要的密码 
     * @param savePath 数据库导出文件保存路径 
     * @param fileName 数据库导出文件文件名 
     * @param databaseName 要导出的数据库名 
     * @return 返回true表示导出成功，否则返回false。 
     */  
	public static boolean exportDatabaseTool(String hostIP, String userName, String password, String savePath,
			String fileName, String databaseName) throws InterruptedException {
        File saveFile = new File(savePath);  
        if (!saveFile.exists()) {// 如果目录不存在  
            saveFile.mkdirs();// 创建文件夹  
        }  
        if(!savePath.endsWith(File.separator)){  
            savePath = savePath + File.separator;  
        }  
          
        PrintWriter printWriter = null;  
        BufferedReader bufferedReader = null;  
        try {  
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(savePath + fileName), "utf8"));  
            //mysqldump -u root -p --single-transaction database1 > backup.sql;
            Process process = Runtime.getRuntime().exec(
            		"mysqldump -h" + hostIP + " -u" + userName + " -p" + password + " --set-charset=UTF8 --single-transaction " + databaseName);  
            InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), "utf8");  
            bufferedReader = new BufferedReader(inputStreamReader);  
            String line;  
            while((line = bufferedReader.readLine())!= null){  
                printWriter.println(line);  
            }  
            printWriter.flush();  
            if(process.waitFor() == 0){//0 表示线程正常终止。  
                return true;  
            }  
        }catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (bufferedReader != null) {  
                    bufferedReader.close();  
                }  
                if (printWriter != null) {  
                    printWriter.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return false;  
    }  
      
    public static void main(String[] args){  
    	
    	
        try {  
        	Date date = new Date();
        	SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        	String currTime = format.format(date)+"-ccgl.sql";
            if (exportDatabaseTool("127.0.0.1", "root", "123456", "D:/backupDatabase", currTime, "ccgl")) {  
                System.out.println("数据库成功备份！！！");  
            } else {  
                System.out.println("数据库备份失败！！！");  
            }  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }  
}  