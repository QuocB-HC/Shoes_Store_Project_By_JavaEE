<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    .main-container {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }
    
    .header {
        width: 80%;
        display: flex;
        justify-content: space-between;
        align-items: center
    }

    .product-image {
        width: 100px;
        height: 100px;
    }
</style>

<main class="main-container">
    <div class="header">
        <p></p>
        <h1>Product List</h1>
        <a href="<c:url value="/admin/product/create" />">Create</a>
    </div>

    <table border="1" cellspacing="0" cellpadding="4">
        <tr>
            <th>No.</th>
            <th>Id</th>
            <th>Image</th>
            <th>Name</th>
            <th>Size</th>
            <th>Category</th>
            <th>Brand</th>
            <th>Stock</th>
            <th>Second Hand</th>
            <th>For Gender</th>
            <th>Price</th>
            <th>Operations</th>
            <th>Variants</th>
        </tr>
        <c:forEach var="product" items="${productList}" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${product.id}</td>
                <td>
                    <img src="<c:url value="/imgs/product-images/${product.images}" />" class="product-image" />
                </td>
                <td>${product.name}</td>
                <td>
                    <c:forEach var="size" items="${product.allSize}" varStatus="loop">
                        ${size}<c:if test="${!loop.last}">, </c:if>
                    </c:forEach>
                </td>
                <td>${product.categoryId.name}</td>
                <td>${product.brandId.name}</td>
                <td>${product.totalStock}</td>
                <td>${product.isSecondHand ? 'Yes' : 'No'}</td>
                <td>${product.forGenderCapitalized}</td>
                <td><fmt:formatNumber value="${product.price}" type="number" groupingUsed="true" /></td>
                <td>
                    <a href="<c:url value="/admin/product/edit?id=${product.id}" />">Edit</a> | 
                    <a href="<c:url value="/admin/product/delete?id=${product.id}" />">Delete</a> 
                </td>
                <td>
                    <a href="<c:url value="/admin/product_variant?productId=${product.id}" />">Show</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</main>