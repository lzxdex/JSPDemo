<%@ page import="com.sxs.LoginDao" %><%--
  Created by IntelliJ IDEA.
  User: server
  Date: 2019/4/12
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String name = request.getParameter("name");
        String pwd = request.getParameter("password");
        LoginDao loginDao = new LoginDao();
        int result = loginDao.login(name,pwd);
        if(result == 1){
//            out.print("登录成功");
            request.setAttribute("tips","登录成功");
           request.getRequestDispatcher("index.jsp").forward(request,response);
        }else if (result == 0){
//            out.print("登录失败");
            request.setAttribute("tips","用户名或密码输入错误！");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else{
            out.print("系统异常");
        }
    %>
</body>
</html>
