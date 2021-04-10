package com.cxp.sbt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cxp.sbt.bean.MyUserBean;
import com.cxp.sbt.util.Pager;


public interface LoginService {
	
	public List<MyUserBean> getAllUser();
	
	//分页查询
	public Pager<MyUserBean> fenYe(Integer page,int pageSize);

}
