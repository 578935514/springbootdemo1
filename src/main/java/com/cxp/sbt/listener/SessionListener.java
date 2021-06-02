package com.cxp.sbt.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.time.LocalDateTime;
import java.util.Date;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(se.getSession().getId());
        System.out.println(new Date(se.getSession().getCreationTime()));
        System.out.println("session create");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        se.getSession().getId();
        se.getSession().getCreationTime();
        System.out.println("session destroyed");
    }
}
