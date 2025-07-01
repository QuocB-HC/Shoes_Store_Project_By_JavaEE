<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!--<link rel="StyleSheet" href="<c:url value="/css/home.css" />" />-->

<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f5f5f5;
        margin: 0;
        padding: 0;
    }

    .content {
        width: 100%;
        padding-bottom: 30px;
    }

    .banner {
        width: 100%;
    }
    
    .banner img {
        object-fit: contain;
        height: auto;
        width: 100%;
    }

    .brand-section {
        margin-top: 30px;
        display: flex;
        justify-content: center;
        gap: 10px;
    }
    
    .brand-item {
        cursor: pointer;
    }
</style>

<div class="content">
    <div class="banner">
        <img src="<c:url value='/imgs/banner.webp' /> " alt="Banner khuyến mãi"/>
    </div>

    <h2 style="margin-left: 20px;">Brands we have</h2>
    
    <div class="brand-section">
        <c:forEach var="brand" items="${brandList}" >
            <a href="<c:url value="/products/products?brand=${brand.id}" />" class="brand-item"><img src="<c:url value="/imgs/brand-logo/${brand.logo}" />" alt="${brand.name}" width=235 height=125 /></a>
        </c:forEach>
    </div>
</div>
