package com.cxp.sbt.mapper;

import com.cxp.sbt.bean.MyUserBean;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@Mapper
public interface MyUserBeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MyUserBean record);

    MyUserBean selectByPrimaryKey(Integer id);

    List<MyUserBean> selectAll();

    int updateByPrimaryKey(MyUserBean record);
}