<%--
  Created by IntelliJ IDEA.
  User: server
  Date: 2019/4/13
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <link href="css/Login.css" rel="stylesheet" type="text/css">
    <script src="js/Login.js"></script>
</head>
<body>
<%
    String t= (String) request.getAttribute("tips");
    if(t==null){
        t="";
    }
%>
<div class="content">

    <div class="content_title">
        <h5>登录</h5>
    </div>
    <div class="content_bottom">
        <form action="check.jsp" method="post" name="form" onsubmit="return check(form)">
            <input type="text" name="name" placeholder="    用户名" onkeydown="nameCheck(form)"><br/>
            <label id="ptips" class="tips"><%=t%></label><br/>
            <input id="pwd" type="password" name="password" placeholder="    密码" onkeydown="pcheck(form)"><p>
            <input class="login" type="submit" value="登录">
        </form>
    </div>
</div>

</body>
</html>
