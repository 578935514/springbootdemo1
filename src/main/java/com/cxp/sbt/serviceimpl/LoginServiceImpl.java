package com.cxp.sbt.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxp.sbt.bean.MyUserBean;
import com.cxp.sbt.mapper.MyUserBeanMapper;
import com.cxp.sbt.service.LoginService;
import com.cxp.sbt.util.Pager;
import com.github.pagehelper.PageHelper;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private MyUserBeanMapper usermapper;

	@Override
	public List<MyUserBean> getAllUser() {
		return usermapper.selectAll();
		
	}

	@Override
	public Pager<MyUserBean> fenYe(Integer page, int pageSize) {
		PageHelper.startPage(page,pageSize);
		List<MyUserBean> users= usermapper.selectAll();
		Pager<MyUserBean> userpager= new Pager<MyUserBean>();
		userpager.setRows(users);
		userpager.setPage(page);
		userpager.setSize(pageSize);
		userpager.setTotal(100);
		return userpager;
	}

	

}
