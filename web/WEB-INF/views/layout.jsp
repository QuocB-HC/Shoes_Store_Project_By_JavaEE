<%-- 
    Document   : layout
    Created on : May 27, 2025, 3:03:09 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
    <a href="../../../../Basic/web/WEB-INF/jsp/index.jsp"></a>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Layout Demo</title>
    </head>
    <body>
        <!--Header-->
        <h1>Layout Demo</h1>
        <a href="<c:url value="/" />" >Home</a> | 
        <a href="<c:url value="/product/page1" />" >Page 1</a> | 
        <a href="<c:url value="/product/page2" />" >Page 2</a>
        <hr/>
        <!--View-->
        <jsp:include page="/WEB-INF/views/${folder}/${view}.jsp" />
        <!--Footer-->
        <hr/>
        &copy; 2025 HSU
    </body>
</html>
