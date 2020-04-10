<%@ page import="com.netdisk.dao.IUserDao" %>
<%@ page import="com.netdisk.dao.DaoFactory" %>
<%@ page import="com.netdisk.model.User" %><%--
  Created by IntelliJ IDEA.
  User: lishaoteng
  Date: 2020-3-30
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    try {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        IUserDao userDao= DaoFactory.getUserDao();
        User u=userDao.login(username,password);
        session.setAttribute("loginUser",u);
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
</body>
</html>
