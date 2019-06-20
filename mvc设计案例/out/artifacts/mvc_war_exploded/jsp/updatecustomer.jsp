<%@ page import="domain.Customer" %><%--
  Created by IntelliJ IDEA.
  User: 张傲
  Date: 2019/6/4
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <title>添加</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <style>
        body {
            background-color: #eee;
        }
        * {
            margin: 0;
            padding: 0;
        }
        .form {
            width: 26%;
            margin-top: 10%;
            margin-left: 37%;
            text-align: center;
            border-radius: 20px;
            box-shadow: 0 4px 20px #ddd;
            background-color: #fff;
            padding: 30px 50px;
        }
        .header {
            letter-spacing: 5px;
        }
        .lab {
            float: left;
            margin: 10px;
        }
        .btn {
            float: left;
        }
        .back {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 60px;
            background-color: #fff;
            box-shadow: 0 4px 20px #ddd;
        }
        .back-icon {
            font-size: 40px;
            margin: 10px 50px;
        }
    </style>
</head>
<body>
<%
    Object msg = request.getAttribute("massage");
    Object error = request.getAttribute("error");
    if (msg!=null){
        String s = (String)msg;
%>
<script>
    alert('<%=s%>')
    console.log('<%=s%>')
</script>
<%
    }
    if (error!=null){
          String e = (String)error;
%>
<script>
    alert('<%=e%>')
    console.log('<%=e%>')
</script>
<%
    }
%>
<%
    String id = null;
    String oldName = null;
    String name = null;
    String location =null;
    String QQ = null;
    String number = null;
    Customer customer = (Customer)request.getAttribute("customer");
    if (customer!=null)
    {
        id = customer.getId()+"";
        oldName = customer.getName();
        name = customer.getName();
        location = customer.getLocation();
        QQ = customer.getQQ();
        number = Integer.toString(customer.getNumber());
    }else {
        id = new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
        oldName = new String(request.getParameter("oldName").getBytes("ISO-8859-1"),"UTF-8");
        name = new String(request.getParameter("oldName").getBytes("ISO-8859-1"),"UTF-8");
        location = new String(request.getParameter("location").getBytes("ISO-8859-1"),"UTF-8");
        QQ = new String(request.getParameter("QQ").getBytes("ISO-8859-1"),"UTF-8");
        number = new String(request.getParameter("number").getBytes("ISO-8859-1"),"UTF-8");
    }
%>
<div class="main">
<form class="form" action="update.do" method="post">
    <input type="hidden" name="id" value="<%=id%>"/>
    <input type="hidden" name="oldName" value="<%=oldName%>"/>
    <h1 class="header">图书管理系统</h1>
    <hr>
    <label class="lab">书名</label>
    <input class="form-control bto" type="text" name="name" value="<%=name%>"/>
    <label class="lab">作者</label>
    <input class="form-control bto" type="text" name="location"value="<%=location%>"/>
    <label class="lab">图片路径地址</label>
    <input class="form-control bto" type="text" name="QQ"value="<%=QQ%>"/>
    <label class="lab">数量</label>
    <input class="form-control bto" type="text" name="number"value="<%=number%>"/>
    <br>
    <button type="submit" class="btn btn-outline-success">提交</button>
    <br>
</form>
</div>
<span class="back">
              <a href="query.do">
                  <i class="fa fa-angle-double-left back-icon"></i>
              </a>
</span>
</body>
</html>
