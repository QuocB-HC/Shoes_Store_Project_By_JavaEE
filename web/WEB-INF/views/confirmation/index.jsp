<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

<style>
    .confirmation-box {
        animation: fadeInUp 0.6s ease-in-out;
        background: #ffffff;
        border-radius: 12px;
        box-shadow: 0 0 25px rgba(0, 0, 0, 0.08);
        padding: 40px;
    }

    .confirmation-icon {
        font-size: 4rem;
        color: #28a745;
        animation: pop 0.4s ease;
    }

    @keyframes fadeInUp {
        from {
            opacity: 0;
            transform: translateY(20px);
        }
        to {
            opacity: 1;
            transform: translateY(0);
        }
    }

    @keyframes pop {
        0% {
            transform: scale(0.8);
        }
        100% {
            transform: scale(1);
        }
    }

    .btn-custom {
        padding: 12px 24px;
        font-size: 1.1rem;
        border-radius: 6px;
    }

    .btn-custom:hover {
        opacity: 0.9;
    }
</style>

<div class="container my-5">
    <div class="row justify-content-center">
        <div class="col-md-8 col-lg-6">
            <div class="confirmation-box text-center">
                <i class="bi bi-check-circle-fill confirmation-icon"></i>
                <h1 class="mt-4 mb-3">Order Placed Successfully!</h1>
                <p class="text-muted mb-4">
                    Thank you for shopping with us. Your order has been received and is currently being processed.
                </p>
                <hr class="my-4">
                <p class="mb-2">What would you like to do next?</p>
                <div class="d-grid gap-2 d-sm-flex justify-content-sm-center mt-3">
                    <a href="<c:url value='/products/products'/>" class="btn btn-success btn-custom">Continue Shopping</a>
                    <a href="<c:url value='/' />" class="btn btn-outline-secondary btn-custom">Back to Homepage</a>
                </div>
            </div>
        </div>
    </div>
</div>
