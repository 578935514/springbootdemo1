package com.cxp.sbt.bean;


public class MyUserBean {
	
    private Integer id;

    private String usernaem;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsernaem() {
        return usernaem;
    }

    public void setUsernaem(String usernaem) {
        this.usernaem = usernaem == null ? null : usernaem.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

	public MyUserBean(Integer id, String usernaem, String password) {
		
		this.id = id;
		this.usernaem = usernaem;
		this.password = password;
	}

	public MyUserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}