<%@ page import="java.awt.*" %>
<%@ page import="domain.Customer" %><%--
  Created by IntelliJ IDEA.
  User: 张傲
  Date: 2019/6/2
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="utf-8" language="java" %>
<html>
<head>
    <title>查询</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
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
        .main {
            width: 24%;
            margin-left: 8%;
            padding: 20px;
            border-radius: 20px;
            box-shadow: 0 4px 20px #ddd;
            background-color: #fff;
            float: left;
            margin-bottom: 50px;
            display: flex;
            flex-direction: column;
        }
        .info {
            display: flex;
            flex-direction: row;
        }
        .left img {
            width: 110px;
            height: 165px;
            margin-right: 20px;
        }
        .middle {
            display: flex;
            flex-direction: column;
            font-size: 18px;
            font-family: KaiTi;
            font-weight: bold;
            margin-top: -13px;
            margin-left: 20px;
        }
        .right {
            margin-top: 20px;
            display: flex;
            flex-direction: row;
            justify-content: space-around;
        }
        .mid-p {
            margin-top: -5px;
            margin-bottom: -10px;
            text-indent: 2em;
            font-size: 14px;
            color: #888;
        }
        .mid-pid {
            font-size: 14px;
            color: #888;
            margin-top: 16px;
            margin-left: 10px;
            margin-bottom: -10px;
        }
        .link {
            list-style-type: none;
        }
        .form {
            list-style-type: none;
            display: flex;
            flex-direction: row;
        }
        .header {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            background-color: #fff;
            padding: 20px 0px 20px 20%;
            box-shadow: 0 4px 20px #ddd;
            display: flex;
            flex-direction: row;
        }
        .select {
            width: 250px;
            margin-right: 40px;
        }
        .link {
            list-style-type: none;
        }
        .name {
            font-size: 25px;
            font-family: KaiTi;
            font-weight: bold;
            margin-right: 40px;
        }
        .btn {
            height: 42px;
            margin-right: 40px;
        }
        .lab {
            margin-top: 15px;
        }
        .back-icon {
            font-size: 40px;
            margin: 0 50px 0 -80px;
        }
        .mid-info {
            display: flex;
            flex-direction: row;
            margin-bottom: -10px;
        }
    </style>
</head>
<script type="text/javascript" src="D:\新建文件夹 (4)\mvc设计案例\web\js"></script>
<script type="text/javascript">
    $(function () {
        $(".delete").click(function () {
            var content =$(this).parent().parent().find("td:eq(1)").text();
            var flag = confirm("确定要删除"+content+"信息吗？");
            return flag;
        });
    });
</script>
<body>
<%
    request.setCharacterEncoding("utf-8");
%>
   <br><br><br><br>
       <%
           java.util.List<Customer> customerList = (java.util.List<Customer>)request.getAttribute("customers");
           if (customerList!=null&&customerList.size()>0)
       %>

          <%
              if (customerList!=null){
              for (Customer customer:customerList){
          %>
              <div class="main">
                  <div class="info">
                      <div class="left">
                          <img src="<%=customer.getQQ()%>">
                      </div>
                      <div class="middle">
                          <label class="lab">书名</label>
                          <p class="mid-p"><%=customer.getName()%></p>
                          <label class="lab">作者</label>
                          <p class="mid-p"><%=customer.getLocation()%></p>
                          <div class="mid-info">
                              <label class="lab">数量</label>
                              <span class="mid-pid"><%=customer.getNumber()%></span>
                          </div>
                      </div>
                  </div>
                  <div class="right">
                      <a class="link" href="edit.do?id=<%=customer.getId()%>">
                          <button type="submit" class="btn btn-outline-primary">修改</button>
                      </a>
                      <a class="link" href="delete.do?id=<%=customer.getId() %>" class="delete">
                          <button type="submit" class="btn btn-outline-success">删除</button>
                      </a>
                  </div>
              </div>
          <%
              }
              }
          %>
<div class="header">
    <a href="user.jsp">
        <i class="fa fa-angle-double-left back-icon"></i>
    </a>
<form class="form" action="query1.do" method="post">
    <label class="name">书名</label>
    <input class="form-control select" type="text" name="name"/>
    <label class="name">作家</label>
    <input class="form-control select" type="text" name="location"/>
    <button class="btn btn-outline-success" type="submit">query</button>
    <a class="link" href="newcustomer.jsp"><button type="button" class="btn btn-outline-primary">添加书籍</button></a>
</form>

</div>
</body>
</html>