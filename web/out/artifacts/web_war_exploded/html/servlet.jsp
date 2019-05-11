<%@ page import="com.al.Person" %><%--
  Created by IntelliJ IDEA.
  User: 张傲
  Date: 2019/4/27
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <!--Java 代码-->
   <p>Servlet生命周期的方法：以下方法都是由Servlet容器负责调用。</p>
   1）：构造器：只被调用一次。只有第一次请求Servlet时，创建Servlet的实例。调用构造器。
    <br/>
    这说明Servlet的是单实例的！
    <br/>
    2）：init方法：只被调用一次，在创建好实例后立即被调用。用于初始化当前的Servlet.
  <br/>
  3):service：被多次调用，每次请求都会调用service方法。实际用于响应请求的。
  <br/>
  4):destroy:只被调用一次。在当前Servlet所在的WEB应用被卸载调用，用于释放当前Servlet所占用的资源。
  <br/>
  5.load-on-startup参数:
  1).配置在servlet节点中：
   <!-- <load-on-startup>1</load-on-startup>-->
  2).load-on-startup:可以指定Servlet被创建的时机，若为负数，则在第一次
  <br/>
  请求时被创建，若为0或者正数，则在当前WEB应用被Servlet容器加载时创建实例，
  <br/>
  且数值越小越早被创建。
  <br/>
  6.关于servlet-mapping：
  <p>1）.同一个Servlet可以被映射到多个URL上。即多个<!--<servlet-mapping>-->元素的<!--<servlet-name>-->
  <br/>子元素的设置值可以是同一个Servlet的注册名。
      <br/>
   2).在Servlet映射到的URL中也可以使用*通配符，但是只能有两种固定的格式：
      <br/>一种格式是“*.拓展名”,另一种格式是以（/）开头并以“/*”结尾。
      <br/>
      <!--<url-pattern/*</url-pattern>-->
      <br/>
      or
      <br>
      <!--<url-pattern>*.do</url-pattern>-->
      <br/>
      注意以下的既带/又带扩展名的不合法。
      <br/>
      <url-pattern>/*.action</url-pattern>-->
      7.ServletConfig:封装了Servlet的配置信息，并且可以获取到
      ServletContext对象
      <br/>
      1).配置Servlet的初始化参数
      <br/>

     <--<!--配置Servlet-->-->
      <!--<servlet>-->
          <!--Servlet 注册的名字-->
          <servlet-name>helloServlet1</servlet-name>
          <!--Servlet 的全类名-->
          <servlet-class>com.al.hello</servlet-class>
          <!--
          可以指定Servlet被创建的时机
          <load-on-startup>1</load-on-startup>
          -->
          <!--配置Servlet的初始化参数 且该节点必须在--load-on-startup节点的
          的前面>
          <init-param>
              <--参数名-->
              <!--<param-name>user</param-name>-->
              <!--参数值-->
              <!--<param-value>root</param-value>
          </init-param>
          <init-param>
              <param-name>password</param-name>
              <param-value>mysql123</param-value>
          </init-param>
      </servlet>-->
      <br/>
      2).获取初始化参数：
          <br/>
          >getInitParameter(String name):获取指定参数名的初始化参数
          <br/>
          >getInitParameterNames():获取参数名组成的Enumeration对象。
          <br/>
          System.out.println("init");
          <br/>
          String user = servletConfig.getInitParameter("user");
          <br/>
          String values = servletConfig.getInitParameter("value");
          <br/>
          System.out.println("user:"+user+"value:"+values);
          <br/>
          Enumeration "<"String">" names = servletConfig.getInitParameterNames();
      <br/>    while (names.hasMoreElements()){
      <br/>   String name = names.nextElement();
      <br/>   String value = servletConfig.getInitParameter(name);
      <br/>   System.out.println("name:"+name+"value:"+value);
      <br/>   }
      3).获取Servlet 的配置名称（了解）
      <br/>String servletName = servletConfig.getServletName();
      <br/>System.out.println(servletName);
      <br/>
      8.ServletContext
      <br/>
        1).可以由ServletConfig获取
        <br/>
        2).该对象代表当前WEB应用：可以认为ServletContext是当前WEB应用的一个
      <br/> 大管家。可以从中获取到当前WEB应用的各个方面的信息。
        <br/>
            ①.获取当前WEB应用的初始化参数
      <br/>     设置初始化参数：可以为所有的Servlet所获取，而Servlet的初始化参数只用那个
      <br/>     Servlet可以获取。
            <!--
              <context-param>
                  <param-name>tu shan hong hong</param-name>
                  <param-value>tu shan su su</param-value>
              </context-param>
              -->
      <br/>方法：
      <br/>   getInitParameter
      <br/>   getInitParameterNames
      <br/>       String servletName = servletConfig.getServletName();
      <br/>       System.out.println(servletName);
      <br/>       //获取ServletContext对象
      <br/>       ServletContext servletContext = servletConfig.getServletContext();
      <br/>       String tushan = servletContext.getInitParameter("tu shan hong hong");
      <br/>       String su = servletContext.getInitParameter("value");
      <br/>       System.out.println(tushan+"---->"+su);
      <br/>       System.out.println(11111);

      <br/>       Enumeration"<"String">" names2 = servletContext.getInitParameterNames();
      <br/>           while (names2.hasMoreElements()){

      <br/>           String name = names2.nextElement();
      <br/>           String value = servletContext.getInitParameter(name);
      <br/>           System.out.println(name+"----->"+value);
      <br/>           }
      <br/>           ②获取当前WEB应用的某一个文件在服务器上的绝对路径；（发布的绝对路径），而不是部署前的路径；
      <br/>           servletContext.getRealPath
      <br/>           3.获取当前WEB应用的名称：
      <br/>           servletContext.getContextPath()
      <br/>           4.获取当前WEB应用的某一个文件对应的输入流.
      <br/>           getResourceAsStream(String path):path 的/为当前WEB应用的根目录。
      <br/>           代码：InputStream is1 = servletContext.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
      <br/>           5.和attribute相关的几个方法：
      <br/>           如何在Servlet 的 service()方法用于应答请求：因为每次请求都会调用service()方法
      <br/>
      <br/>
  </p></body>
</html>
