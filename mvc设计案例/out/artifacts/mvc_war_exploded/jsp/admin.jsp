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
    <title>管理员登陆</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <style>
        .con {
            width: 100%;
            background-color: #eee;
            height: 100%;
            padding-top: 7%;
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
        .link {
            list-style-type: none;
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
        <form class="form" action="landing.admin" method="post">
            <h1 class="header">图书管理系统</h1>
            <hr>
            <table>
                <tr>
                    <label class="user">账号</label>
                    <input type="text" class="form-control bto" name="user"value="<%=request.getParameter("user")==null ? "": new String(request.getParameter("user").getBytes("ISO-8859-1"),"UTF-8")%>"/>
                </tr>
                <tr>
                    <label class="pwd">密码</label>
                    <input type="password" class="form-control bto" name="password" value="<%=request.getParameter("password")==null ? "": new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8")%>"/>
                </tr>
                <button type="submit" class="btn btn-outline-primary">提交</button><br><br>
                <a class="link" href="adminupdate.jsp"><button type="button" class="btn btn-outline-success">修改密码</button></a>
            </table>
        </form>
</div>
<span class="back">
              <a href="user.jsp">
                  <i class="fa fa-angle-double-left back-icon"></i>
              </a>
</span>
</body>
</html>
