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
    <%
      Person person = new Person();
      System.out.println(person.getPersonInfo());
    %>
  </body>
</html>
