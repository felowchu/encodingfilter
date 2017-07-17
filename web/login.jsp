<%--
  Created by IntelliJ IDEA.
  User: bestchu
  Date: 2017/7/17
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
</head>

<body>
    <form name="frmLogin" action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text" name="userName"><br/>
        <input type="submit" value="POST提交">
    </form>
    <form name="frmLogin" action="${pageContext.request.contextPath}/login" method="get">
        用户名：<input type="text" name="userName"><br/>
        <input type="submit" value="GET提交">
    </form>
</body>
</html>
