<%--
  Created by IntelliJ IDEA.
  User: 张傲
  Date: 2019/6/12
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="domain.Customer" %>
<%@ page import="domain.PageResult" %>
<html>
<head>
    <title>分页</title>
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
            margin-left: 20px;
        }
        .right {
            margin-top: 20px;
            margin-left: 50px;
        }
        .mid-p {
            text-indent: 2em;
            font-size: 14px;
            color: #888;
            margin-bottom: -5px;
        }
        .link {
            list-style-type: none;
        }
        .bottom {
            position: fixed;
            bottom: 0;
            background-color: #fff;
            padding: 20px 100px;
            box-shadow: 0 4px 20px #ddd;
            width: 100%;
            text-align: center;
        }
        .page {
            font-weight: 600;
            font-family: KaiTi;
            margin: 0 40px;
        }
        .middle label {
            margin-top: 15px;
        }
        .bar {
            margin-bottom: 1250px;
        }
    </style>
</head>
<body>
<%
    java.util.List<Customer> customerList = (java.util.List<Customer>)request.getAttribute("customers");
    String phone = (String) request.getAttribute("phone");
    if (customerList!=null&&customerList.size()>0)
%>
<br>
<div class="bar">
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
                    <label>书名</label>
                    <p class="mid-p"><%=customer.getName()%></p>
                    <label>作者</label>
                    <p class="mid-p"><%=customer.getLocation()%></p>
                </div>
            </div>
            <div class="right">
                <a class="link" href="borrow.page?id=<%=customer.getId()%>&name=<%=customer.getName()%>&QQ=<%=customer.getQQ()%>&phone=<%=phone%>&action=<%=customer.getLocation()%>"><button type="button" class="btn btn-outline-success">借阅</button></a>
            </div>
        </div>
        <%--<td><%=customer.getName()%></td>--%>
        <%--<td><%=customer.getLocation()%></td>--%>
        <%--<td><%=customer.getQQ()%></td>--%>
        <%--<td><a href="borrow.page?id=<%=customer.getId()%>&name=<%=customer.getName()%>&QQ=<%=customer.getQQ()%>&phone=<%=phone%>">借阅</a></td>--%>

            <%--<a href="edit.do?id=<%=customer.getId()%>"> UPDATE</a>--%>
            <%--<a href="delete.do?id=<%=customer.getId() %>" class="delete"> DELETE</a>--%>
    <%
            }
        }
    %>
</div>
    <div class="bottom">
        <a class="link" href="select.page?currentPage=<%=request.getAttribute("prevPage")%>&phone=<%=phone%>"><button type="button" class="btn btn-outline-success">上页</button></a>
        <a class="link" href="select.page?currentPage=<%=request.getAttribute("nextPage")%>&phone=<%=phone%>"><button type="button" class="btn btn-outline-success">下页</button></a>
        <span class="page">当前第<%= request.getAttribute("currentPage")%>/<%=request.getAttribute("totalPage")%>页&nbsp;&nbsp;&nbsp;&nbsp;一共<%=request.getAttribute("TotalCount")%>条数据</span>
        <a class="link" href="get.page?phone=<%=phone%>"><button type="button" class="btn btn-outline-primary">查看所借书籍</button></a>
        <a class="link" href="user.jsp"><button type="button" class="btn btn-outline-primary">注销</button></a>
    </div>

</table>
</body>
</html>
