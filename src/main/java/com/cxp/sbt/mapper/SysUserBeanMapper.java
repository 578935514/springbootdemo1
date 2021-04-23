package com.cxp.sbt.mapper;

import com.cxp.sbt.bean.SysUserBean;
import java.util.List;

public interface SysUserBeanMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(SysUserBean record);

    SysUserBean selectByPrimaryKey(Integer uid);

    List<SysUserBean> selectAll();

    int updateByPrimaryKey(SysUserBean record);
}