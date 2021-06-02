package com.cxp.sbt.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if (session.getAttribute("test").equals("") || session.getAttribute("test") == null) {
            Map<String, String> mess = new HashMap();
            mess.put("code", "505");
            mess.put("message", "userinfo destroy");
            PrintWriter out = response.getWriter();
            out.print(mess);

        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
