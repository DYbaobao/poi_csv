package com.test.model;
/**
 * Created by win on 2018/9/8.
 */
public class User {
    //@CsvBindByName(column = "编号")
    private int id;
    //@CsvBindByName(column = "姓名")
    private String userName;
    private int age;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
    
	
}
