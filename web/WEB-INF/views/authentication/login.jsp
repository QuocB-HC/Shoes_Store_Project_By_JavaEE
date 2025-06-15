<%-- 
    Document   : index
    Created on : Jun 15, 2025, 3:51:52 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h2>Login</h2>
        <form method="post" action="${pageContext.request.contextPath}/doLogin">
            <input type="email" name="email" placeholder="Email" required />
            <input type="password" name="password" placeholder="Mật khẩu" required />
            <button type="submit">Login</button>
            <c:if test="${not empty error}">
                <p style="color: red">${error}</p>
            </c:if>
        </form>

        <a href="<c:url value="/register" />">Go to Register</a>
    </body>
</html>
