<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!--<link rel="StyleSheet" href="<c:url value="/css/home.css" />" />-->

<style>
    .main-container {
        margin: 0;
        padding: 0;
        display: flex;
        gap: 5%;

    }
    .filter-container {
        width: 15%
    }


    .product-list-container {
        width: 80%;
        display: flex;
        flex-direction: row;
        gap: 1.5%;
        flex-wrap: wrap;
    }

    .card-container {
        width: 30%;
        height: auto;
    }

    .product-image {
        width: 100%;
        height: 400px;
        cursor: pointer;
    }

    .product-name {
        font-weight: bold;
        cursor: pointer;
    }
</style>

<!--<h2>Home Page</h2>-->
<main class="main-container">
    <div class="filter-container">

    </div>

    <div class="product-list-container">
        <c:forEach var="product" items="${productList}">
            <div class="card-container">
                <img src="<c:url value="/imgs/product-images/${product.images}" />" class="product-image" />
                <p class="product-name">${product.name}</p>
                <p class="product-price"><fmt:formatNumber value="${product.price}" /><sup>đ</sup></p>
            </div>
        </c:forEach>
    </div>
</main>
