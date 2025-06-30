<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f5f5f5;
            padding: 20px;
        }
        .order-box {
            background: white;
            max-width: 900px;
            margin: auto;
            padding: 20px 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px #ddd;
        }
        .section-title {
            font-weight: bold;
            margin-bottom: 10px;
            font-size: 18px;
            color: black;
        }
        .user-info, .product-info, .summary {
            margin-bottom: 25px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background: #fff;
        }
        th, td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
        }
        .total {
            font-size: 18px;
            font-weight: bold;
            text-align: right;
            color: #d0021b;
        }
        .form-group {
            margin-top: 10px;
        }
        .btn {
            background: #ee4d2d;
            color: white;
            padding: 12px 24px;
            border: none;
            cursor: pointer;
            border-radius: 4px;
        }
        .btn:hover {
            background: #d93c1d;
        }
        .error {
            color: red;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <form action="placeOrder" method="post">
        <div class="order-box">
            <div class="user-info">
                <div class="section-title">📍 Địa Chỉ Nhận Hàng</div>
                <div style="color: black"><strong>${user.fullName}</strong> (${user.phoneNumber})</div>
                <input type="text" name="address" placeholder="Nhập địa chỉ nhận hàng" required style="width: 100%; padding: 8px; margin-top: 10px;" />
            </div>

            <div class="product-info">
                <div class="section-title">🛍️ Sản phẩm</div>
                <table>
                    <thead>
                        <tr>
                            <th>Tên sản phẩm</th>
                            <th>Loại</th>
                            <th>Đơn giá</th>
                            <th>Số lượng</th>
                            <th>Thành tiền</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="total" value="0" />
                        <c:forEach var="entry" items="${cart}">
                            <c:set var="item" value="${entry.value}" />
                            <c:set var="subtotal" value="${item.product.price * item.quantity}" />
                            <tr>
                                <td>${item.product.name}</td>
                                <td>Size ${item.size} - ${item.color}</td>
                                <td>₫${item.product.price}</td>
                                <td>${item.quantity}</td>
                                <td>₫${subtotal}</td>
                            </tr>
                            <c:set var="total" value="${total + subtotal}" />
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="summary">
                <div class="section-title">💳 Phương thức thanh toán</div>
                <select name="paymentType" required style="padding: 6px; width: 200px;">
                    <option value="cash">Thanh toán khi nhận hàng (Cash)</option>
                    <option value="bank transfer">Chuyển khoản ngân hàng</option>
                </select>

                <div class="total">Tổng cộng: ₫<c:out value="${total}" /></div>
            </div>

            <div class="form-group">
                <c:if test="${not empty error}">
                    <div class="error">${error}</div>
                </c:if>
                    <a href="<c:url value="/order/confirmation" />"><button class="btn" type="submit">Đặt Hàng</button></a>
            </div>
        </div>
    </form>
</body>
</html>
