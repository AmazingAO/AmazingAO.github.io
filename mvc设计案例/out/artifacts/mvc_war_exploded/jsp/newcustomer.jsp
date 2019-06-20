<%--
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
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        body {
            background-color: #eee;
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
        .main {
            width: 30%;
            margin-top: 8%;
            margin-left: 35%;
            box-shadow: 0 4px 20px #ddd;
            background-color: #fff;
            padding: 30px;
            border-radius: 20px;
            display: flex;
            flex-direction: row;
        }
        .form {
            width: 100%;
            padding: 20px 12%;
        }
        .header {
            text-align: center;
            font-size: 40px;
            letter-spacing: 5px;
            margin-bottom: 20px;
        }
        .lab {
            font-size: 22px;
            margin-top: 10px;
            font-weight: 600;
            font-family: KaiTi;
            letter-spacing: 5px;
        }
        .btt {
            width: 80px;
            height: 40px;
        }
    </style>
</head>
<body>
<%
    Object msg = request.getAttribute("massage");
    if (msg!=null){
        String s = (String) msg;
       %>
<script>
    alert('<%=s%>')
    console.log('<%=s%>')
</script>
<%
    }
%>
<span class="back">
              <a href="query.do">
                  <i class="fa fa-angle-double-left back-icon"></i>
              </a>
</span>
<div class="main">
<form class="form" action="add.do" method="post">
    <h1 class="header">图书管理系统</h1>
    <hr>
    <label class="lab">书名</label>
    <br>
    <input class="form-control bto" type="text" name="name" value="<%=request.getParameter("name")==null ? "": new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8")%>"/>
    <br>
    <label class="lab">作者</label>
    <br>
    <input class="form-control bto" type="text" name="location"value="<%=request.getParameter("location")==null ? "": new String(request.getParameter("location").getBytes("ISO-8859-1"),"UTF-8")%>"/>
    <br>
    <label class="lab">图片地址</label>
    <br>
    <input class="form-control bto" type="text" name="QQ"value="<%=request.getParameter("QQ")==null ? "": new String(request.getParameter("QQ").getBytes("ISO-8859-1"),"utf-8")%>"/>
    <br>
    <label class="lab">数量</label>
    <br>
    <input class="form-control bto" type="text" name="number"value="<%=request.getParameter("number")==null ? "": new String(request.getParameter("number").getBytes("ISO-8859-1"),"utf-8")%>"/>
    <br>
    <button type="submit" class="btn btn-outline-success btt">提交</button>
</form>
</div>
</body>
</html>
