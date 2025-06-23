<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>${product.name}</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            background: #fff;
        }

        .container {
            max-width: 1300px;
            margin: 40px auto;
            display: flex;
            gap: 30px;
            padding: 0 20px;
        }

        .image-gallery {
            flex: 1;
        }

        .main-image {
            width: 100%;
            border-radius: 8px;
        }

        .thumbnail-list {
            display: flex;
            flex-direction: column;
            gap: 10px;
            margin-top: 10px;
        }

        .thumbnail-list img {
            width: 80px;
            border: 1px solid #ccc;
            cursor: pointer;
        }

        .details {
            flex: 1.2;
        }

        .details h1 {
            margin-top: 0;
        }

        .price {
            font-size: 22px;
            font-weight: bold;
            margin: 15px 0;
        }

        .sizes {
            display: grid;
            grid-template-columns: repeat(4, 1fr);
            gap: 10px;
            margin: 20px 0;
        }

        .size-option {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
            border-radius: 6px;
            cursor: pointer;
        }

        .size-option:hover {
            background: #eee;
        }

        .add-to-cart {
            display: block;
            width: 100%;
            padding: 15px;
            background: #000;
            color: #fff;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            margin-top: 10px;
            cursor: pointer;
        }

        .description {
            margin-top: 40px;
            line-height: 1.6;
        }

        .back-link {
            margin: 30px 0;
            display: inline-block;
            color: #0056d2;
            text-decoration: none;
        }

        .back-link:hover {
            text-decoration: underline;
        }
    </style>
    <script>
        function changeMainImage(src) {
            document.getElementById('mainImage').src = src;
        }
    </script>
</head>
<body>

<div class="container">

    <!-- Hình ảnh sản phẩm -->
    <div class="image-gallery">
        <img id="mainImage" src="${pageContext.request.contextPath}/images/product-images/${product.images}" class="main-image" alt="${product.name}">
        
        <!-- Ảnh phụ (nếu có) -->
        <div class="thumbnail-list">
            <img src="${pageContext.request.contextPath}/images/product-images/${product.images}" onclick="changeMainImage(this.src)" />
            <img src="${pageContext.request.contextPath}/images/product-images/${product.images}" onclick="changeMainImage(this.src)" />
            <img src="${pageContext.request.contextPath}/images/product-images/${product.images}" onclick="changeMainImage(this.src)" />
        </div>
    </div>

    <!-- Thông tin sản phẩm -->
    <div class="details">
        <h1>${product.name}</h1>
        <p><strong>
            <c:choose>
                <c:when test="${product.forGender == 'male'}">Men's Shoes</c:when>
                <c:when test="${product.forGender == 'female'}">Women's Shoes</c:when>
                <c:otherwise>Unisex Shoes</c:otherwise>
            </c:choose>
        </strong></p>
        <p class="price"><fmt:formatNumber value="${product.price}" type="currency" currencySymbol="" />₫</p>

        <!-- Size -->
        <div>
            <p><strong>Select Size</strong></p>
            <div class="sizes">
                <c:forEach var="size" items="${['EU 38.5', 'EU 39', 'EU 40', 'EU 40.5', 'EU 41', 'EU 42', 'EU 43', 'EU 44']}">
                    <div class="size-option">${size}</div>
                </c:forEach>
            </div>
        </div>

        <!-- Nút -->
        <button class="add-to-cart">Add to Bag</button>

        <!-- Mô tả -->
        <div class="description">
            <p>
                Đây là sản phẩm <strong>${product.name}</strong> thuộc danh mục <strong>${product.category.name}</strong> của thương hiệu <strong>${product.brand.name}</strong>.
                Giày được thiết kế cho nhu cầu thể thao, thời trang và phong cách năng động.
            </p>
            <p>
                Màu sắc, chất liệu và kiểu dáng hiện đại, phù hợp với mọi đối tượng. Sản phẩm có thể được giao hàng nhanh và đổi trả miễn phí trong 7 ngày.
            </p>
        </div>

        <a href="${pageContext.request.contextPath}/products/products" class="back-link">← Quay lại danh sách</a>
    </div>

</div>

</body>
</html>
