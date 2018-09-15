package com.test.controller;

import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvWriter;
import com.test.model.User;
import com.test.service.UserService;
import com.test.utils.PoiExportExcel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Created by win on 2018/9/9.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 导出报表
     * @return
     */
    

    @RequestMapping(value = "/exportExcel")
    public void exportExcel (HttpServletRequest request, HttpServletResponse response) throws Exception{
    	response.reset();//清空reponse
    	List<User> formList=  userService.findUsers();
    	String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    	String filename = URLEncoder.encode("名字明细表" +currentTime,"UTF-8");
    	response.addHeader("Content-Disposition", "attachment;filename="+filename + ".xls");// 设置response的Header 
    	response.setContentType("application/octet-stream");
    	PoiExportExcel.PoiWriteExcel("工作薄",formList,request,response);

    }
    
	@RequestMapping(value = "/exportCSV")
    public void exportCSV (HttpServletRequest request, HttpServletResponse response) throws Exception{	
    	try {
    		//获取数据
    		List<User> formList=  userService.findUsers();
    		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    		File tFile = File.createTempFile("名字明细表", ".csv");
    		CsvWriter csvWriter = new CsvWriter(tFile.getCanonicalPath()+currentTime,',', Charset.forName("gbk"));
    		String [] headers ={"编号","姓名","年龄"};
    		csvWriter.writeRecord(headers);
    		for (User user : formList) {
				csvWriter.write(user.getId()+"");
				csvWriter.write(user.getUserName());
				csvWriter.write(user.getAge() + "");
				csvWriter.endRecord();
			}
    		csvWriter.close();
    		OutputStream out = response.getOutputStream();
 		   byte[] b = new byte[10240];
 		   File fileLoad = new File(tFile.getCanonicalPath()+currentTime);
 		   response.reset();
 		   String filename = URLEncoder.encode("名字明细表" +currentTime,"UTF-8");	  
 		   response.setContentType("application/csv");  
 		   response.setHeader("content-disposition", "attachment; filename=\"" + filename +".csv");   
 		   response.setHeader("Content_Length", String.valueOf(fileLoad.length()));  
 		   java.io.FileInputStream in = new java.io.FileInputStream(fileLoad);  
 		   int n;  
 		   while ((n = in.read(b)) != -1) {  
 		  	 out.write(b, 0, n); //每次写入out1024字节 
 		   }  
 		   in.close();  
 		   out.close();
		} catch (Exception e) {
			e.printStackTrace();
	 }	 
   }
	
}
