package com.al;

import javax.servlet.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

public class hello implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
        String user = servletConfig.getInitParameter("user");
        String values = servletConfig.getInitParameter("value");
        System.out.println("user:"+user+"value:"+values);
        Enumeration<String> names = servletConfig.getInitParameterNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            String value = servletConfig.getInitParameter(name);
            System.out.println("name:"+name+"value:"+value);
        }
        String servletName = servletConfig.getServletName();
        System.out.println(servletName);
        //获取ServletContext对象
        ServletContext servletContext = servletConfig.getServletContext();
        String tushan = servletContext.getInitParameter("tu shan hong hong");
        String su = servletContext.getInitParameter("value");
        System.out.println(tushan+"---->"+su);
        System.out.println(11111);

        Enumeration<String> names2 = servletContext.getInitParameterNames();
        while (names2.hasMoreElements()){

            String name = names2.nextElement();
            String value = servletContext.getInitParameter(name);
            System.out.println(name+"----->"+value);
        }
        String realPath = servletContext.getRealPath("/涂山苏苏.PNG");
        System.out.println(realPath);
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
        try{
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream is = classLoader.getResourceAsStream("jdbc.properties");
            System.out.println("1:"+is);
            InputStream is1 = servletContext.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
            System.out.println("2:"+is1);
         }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service");
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
