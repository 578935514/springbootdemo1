package com.cxp.sbt.controller;

import java.util.List;

import com.cxp.sbt.bean.SysUserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;


import com.cxp.sbt.bean.PersonTest;

import com.cxp.sbt.service.LoginService;
import com.cxp.sbt.util.Pager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/system")
public class LoginController {

    @Autowired
    private PersonTest pt;

    @Autowired
    private LoginService ls;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;

    /**
     * @param map
     * @return
     */
    @RequestMapping("/login")
    public String doLogin(ModelMap map) {

        pt.setName("草案");
        map.addAttribute("name", "你好thymeleaf");
        map.addAttribute("user", pt);
        System.out.println();
        System.out.println(pt.getAge());
        ModelAndView mav = new ModelAndView();
        int i = 1 / 0;

        return "/index";
    }

    @RequestMapping("/getuser")
    @ResponseBody
    public List<SysUserBean> getUser() {
        return ls.getAllUser();
    }


    @RequestMapping("/fenye")
    @ResponseBody
    public Pager<SysUserBean> fenYe(Integer page) {

        session.setMaxInactiveInterval(30);
        session.setAttribute("test", "nihaozhongwen");

        if (page == null) {
            page = 1;
        }
        int pageSize = 2;

        return ls.fenYe(page, pageSize);
    }

    //保存数据
    @RequestMapping("/baocun")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public String baoCun() {
        return null;
    }


}
