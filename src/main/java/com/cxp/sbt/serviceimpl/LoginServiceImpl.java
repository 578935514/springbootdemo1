package com.cxp.sbt.serviceimpl;

import java.util.List;

import com.cxp.sbt.bean.SysUserBean;
import com.cxp.sbt.mapper.SysUserBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cxp.sbt.service.LoginService;
import com.cxp.sbt.util.Pager;
import com.github.pagehelper.PageHelper;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SysUserBeanMapper sysUserBeanMapper;

    @Override
    public List<SysUserBean> getAllUser() {
        return sysUserBeanMapper.selectAll();

    }

    @Override
    public Pager<SysUserBean> fenYe(Integer page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<SysUserBean> users = sysUserBeanMapper.selectAll();
        Pager<SysUserBean> userpager = new Pager<SysUserBean>();
        userpager.setContens(users);
        userpager.setPage(page);
        userpager.setSize(pageSize);
        userpager.setTotal(100);
        return userpager;
    }


}
