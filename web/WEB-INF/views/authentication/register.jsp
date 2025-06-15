<%-- 
    Document   : register
    Created on : Jun 16, 2025, 1:29:51 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h2>Register</h2>
        <form method="post" action="${pageContext.request.contextPath}/doRegister">
            <input type="text" name="fullName" placeholder="Họ tên" required />
            <input type="email" name="email" placeholder="Email" required />
            <input type="password" name="password" placeholder="Mật khẩu" required />
            <input type="text" name="phone" placeholder="Số điện thoại" />
            <input type="date" name="dob" placeholder="Ngày sinh" required />
            <select name="gender">
                <option value="male">Male</option>
                <option value="female">Female</option>
                <option value="other">Other</option>
            </select>
            <button type="submit">Register</button>
        </form>

        <a href="<c:url value="/login" />">I already have account</a>
    </body>
</html>
