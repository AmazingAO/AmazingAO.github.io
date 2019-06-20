<%@ page import="java.awt.*" %>
<%@ page import="domain.Customer" %>
<%@ page import="domain.borr" %><%--
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
        .main {
            width: 24%;
            margin-left: 8%;
            background-color: #fff;
            box-shadow: 0 4px 20px #ddd;
            float: left;
            border-radius: 20px;
            display: flex;
            flex-direction: column;
            padding: 20px;
            margin-top: 50px;
        }
        .left img {
            width: 100px;
            height: 150px;
            margin-right: 20px;
        }
        .middle {
            display: flex;
            flex-direction: column;
            font-size: 18px;
            font-family: KaiTi;
            font-weight: bold;
        }
        .right {
            margin-top: 20px;
            margin-left: 50px;
        }
        .info {
            display: flex;
            flex-direction: row;
        }
        .mid-p {
            text-indent: 2em;
            font-size: 14px;
            color: #888;
        }
        .link {
            list-style-type: none;
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
        button {
            width: 60px;
            height: 30px;
            font-size: 20px;
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
       <%
           java.util.List<borr> borrList = (java.util.List<borr>)request.getAttribute("borr");
           if (borrList!=null&&borrList.size()>0)
       %>
          <br>
          <%
              String phone = (String) request.getAttribute("phone");
              borr borr1 = null;
              if (borrList!=null){
              for (borr borr:borrList){
                  borr1 = borr;
          %>
          <div class="main">
              <div class="info">
                  <div class="left">
                      <img src="<%=borr.getImg()%>">
                  </div>
                  <div class="middle">
                      <label>作者</label>
                      <p class="mid-p"><%=borr.getAction()%></p>
                      <label>书名</label>
                      <p class="mid-p"><%=borr.getBook()%></p>
                  </div>
              </div>
              <div class="right">
                  <a class="link" href="returnB.page?id=<%=borr.getId()%>&phone=<%=borr.getPhone()%>">
                      <button type="button" class="btn btn-outline-primary">还书</button>
                  </a>
              </div>
          </div>
          <%
              }
              }
          %>
          <span class="back">
              <a href="select.page?phone=<%=phone%>">
                  <i class="fa fa-angle-double-left back-icon"></i>
              </a>
          </span>
</body>
</html>
