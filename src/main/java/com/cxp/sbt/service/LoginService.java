package com.cxp.sbt.service;

import java.util.List;

import com.cxp.sbt.bean.SysUserBean;
import org.springframework.stereotype.Service;

import com.cxp.sbt.bean.MyUserBean;
import com.cxp.sbt.util.Pager;


public interface LoginService {

    public List<SysUserBean> getAllUser();

    //分页查询
    public Pager<SysUserBean> fenYe(Integer page, int pageSize);

}
