package com.cxp.sbt.mapper;

import com.cxp.sbt.bean.SysUserBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper   //如果采用注解开发注释
public interface SysUserBeanMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(SysUserBean record);

    SysUserBean selectByPrimaryKey(Integer uid);

    List<SysUserBean> selectAll();

    int updateByPrimaryKey(SysUserBean record);
}