package com.nqs.common;

import ch.qos.logback.core.net.SyslogOutputStream;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ProjectStartListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("APP_PATH","/ssm");
        System.out.println("项目启动了！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
