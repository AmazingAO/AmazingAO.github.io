<%--
  Created by IntelliJ IDEA.
  User: 张傲
  Date: 2019/6/10
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登陆</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
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
            margin-left: 36%;
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
        .link {
            list-style-type: none;
        }
        .question {
            font-size: 14px;
            color: dodgerblue;
            font-weight: 600;
            font-family: KaiTi;
            text-decoration: none;
        }
    </style>
</head>
<body>
<%
    Object msg = request.getAttribute("massage");
    if (msg!=null){
%>
<script>
    alert('用户名或密码错误')
</script>
<%
    }
%>
<div class="con">
    <form class="form" action="landing.user" method="post">
        <h1 class="header">图书管理系统</h1>
        <hr>
        <table>
            <tr>
                <label class="user">账号</label>
                <input class="form-control bto" type="text" name="phone"value="<%=request.getParameter("phone")==null ? "": new String(request.getParameter("phone").getBytes("ISO-8859-1"),"UTF-8")%>"/>
            </tr>
            <tr>
                <label class="pwd">密码</label>
                <input class="form-control" type="password" name="password" value="<%=request.getParameter("password")==null ? "": new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8")%>"/>
            </tr>
            <br>
            <button type="submit" class="btn btn-outline-primary">登陆</button>
            &nbsp;&nbsp;&nbsp;&nbsp;<a class="link" href="userupdate.jsp"><button type="button" class="btn btn-outline-success">修改密码</button></a>
            <br><br>
            <a class="link question" href="userregistered.jsp">注册</a>
            <br><br>
            <a class="link question" href="admin.jsp">管理员登陆</a>
        </table>
    </form>
</div>
<%--<a href="adminupdate.jsp">修改密码</a>--%>
</body>
</html>
