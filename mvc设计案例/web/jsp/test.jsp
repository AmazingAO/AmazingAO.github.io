<%--
  Created by IntelliJ IDEA.
  User: 张傲
  Date: 2019/5/30
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <style>
         .link {
              list-style-type: none;
         }
         * {
              margin: 0;
              padding: 0;
         }
         .con {
              background-color: #eee;
              width: 100%;
              height: 100%;
              padding-top: 12%;
              text-align: center;
         }
         .contain {
              border-radius: 20px;
              box-shadow: 0 4px 20px #ddd;
              width: 20%;
              margin-left: 10%;
              height: 90%;
              background-color: #fff;
              float: left;
              text-align: center;
         }
         .left {
              box-shadow: 0 4px 20px #1e90ff;
         }
         .mid {
              box-shadow: 0 4px 20px green;
         }
         .right {
              box-shadow: 0 4px 20px red;
         }
         .span {
              font-size: 100px;
              margin-top: 100px;
              margin-bottom: 100px;
         }
         .one {
              color: #1e90ff;
         }
         .two {
              color: green;
         }
         .three {
              color: red;
         }
         .btn {
              width: 100px;
         }
         .header {
              margin-top: -100px;
              margin-bottom: 80px;
              font-weight: 600;
              letter-spacing: 20px;
              font-family: KaiTi;
         }
    </style>
</head>
<body>
 <%--<a href="customerServlet?method=add">Add</a>--%>
 <%--<br><br>--%>
 <%--<a href="customerServlet?method=query">Query</a>--%>
 <%--<br><br>--%>
 <%--<a href="customerServlet?method=delete">Delete</a>--%>
 <div class="con">
  <h1 class="header">图书管理系统</h1>
  <div class="contain left">
   <i class="fa fa-plus-square-o span one"></i>
   <br>
   <a class="link" href="add.do">
    <button type="submit" class="btn btn-outline-primary">添加</button>
   </a>
  </div>
  <div class="contain mid">
   <i class="fa fa-check-square-o span two"></i>
   <br>
   <a class="link" href="query.do">
    <button type="submit" class="btn btn-outline-success">提交</button>
   </a>
  </div>
  <div class="contain right">
   <i class="fa fa-minus-square-o span three"></i>
   <br>
   <a class="link" href="delete.do">
    <button type="submit" class="btn btn btn-outline-danger">删除</button>
   </a>
  </div>
 </div>

 <%--<a class="link" href="add.do">Add</a>--%>
 <%--<br><br>--%>
 <%--<a class="link" href="query.do">Query</a>--%>
 <%--<br><br>--%>
 <%--<a class="link" href="delete.do">Delete</a>--%>
</body>
</html>
