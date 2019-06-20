<%--
  Created by IntelliJ IDEA.
  User: 张傲
  Date: 2019/6/11
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户修改密码</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <style>
        .con {
            width: 100%;
            background-color: #eee;
            height: 100%;
            padding-top: 7%;
        }
        .form {
            width: 32%;
            margin-left: 35%;
            border-radius: 20px;
            box-shadow: 0 4px 20px #ddd;
            padding: 50px 7%;
            background-color: #fff;
        }
        .user, .pwd {
            margin-bottom: 10px;
        }
        .bto {
            margin-bottom: 25px;
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
    if (msg!=null){
        String s = (String)msg;
%>
<script>
    alert('<%=s%>')
</script>
<%
    }
%>
<div class="con">
    <form class="form" action="update.user" method="post">
        <h1 class="header">图书管理系统</h1>
        <hr>
        <table>
            <tr>
                <label class="user">账号</label>
                <input class="form-control bto" type="text" name="phone" value="<%=request.getParameter("phone")==null ? "": new String(request.getParameter("phone").getBytes("ISO-8859-1"),"UTF-8")%>"/>
            </tr>
            <tr>
                <label class="pwd">旧密码</label>
                <input class="form-control bto" type="password" name="password" value="<%=request.getParameter("password")==null ? "": new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8")%>"/>
            </tr>
            <tr>
                <label class="pwd">新密码</label>
                <input class="form-control bto" type="password" name="password1"/>
            </tr>
            <br>
            <button type="submit" class="btn btn-outline-primary">提交</button>
        </table>
    </form>
    <span class="back">
              <a href="user.jsp">
                  <i class="fa fa-angle-double-left back-icon"></i>
              </a>
    </span>
</div>
</body>
</html>
