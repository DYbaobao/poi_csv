package com.test.utils;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.csvreader.CsvWriter;
import com.test.model.User;


public class CSVTest {

	@Test
	public void test() {
		try {
			List<User> ls=new ArrayList<User>();
            for (int i = 0; i <10; i++) {
                 User u=new User();
                 u.setId(i);
                 u.setUserName("小帅"+i);
                 ls.add(u);
            }
			File tFile = File.createTempFile("vehicle", ".csv");
			CsvWriter csvWriter = new CsvWriter(tFile.getCanonicalPath(), ',',Charset.forName("gbk"));
			long s = System.currentTimeMillis();
			System.err.println(s);
			String [] headers ={"编号","姓名"};
			csvWriter.writeRecord(headers);
			for (User user : ls) {
				csvWriter.write(user.getId()+"");
				csvWriter.write(user.getUserName());
				csvWriter.endRecord();
			}
			csvWriter.close();
			long e = System.currentTimeMillis();
			System.err.println(e-s);
			System.err.println(tFile.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

 }
}
