package com.cxp.sbt;

import javax.annotation.security.RunAs;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cxp.sbt.bean.PersonTest;

@SpringBootTest
class Springboottest1ApplicationTests {

    @Autowired
    private PersonTest pt;

    @Test
    void contextLoads() {
        System.out.println(pt.toString());

    }

}
