<%-- 
    Document   : layout
    Created on : May 27, 2025, 3:03:09 PM
    Author     : ASUS
--%>

<%@ page import="entities.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
    <a href="../../../../Basic/web/WEB-INF/jsp/index.jsp"></a>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!--<link rel="StyleSheet" href="<c:url value="/css/layout.css" />" />-->
    <title>Shoes Store</title>

    <!-- Style -->
    <style>
        body {
            font-family: Arial, sans-serif;
            font-size: 16px;
            padding: 0;
            margin: 0;
            overflow-y: auto;
            overflow-x: hidden;
            min-height: 100%;
        }

        .header-bar {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            align-items: center;
            padding: 0 10px;
        }

        .header-bar .navbar a,
        .header-bar .auth-button a {
            color: black;
            text-decoration: none;
        }

        .user-info {
            display: flex;
            align-items: center;
            gap: 10px;
            cursor: pointer;
        }

        .user-avatar {
            height: 40px;
            width: 40px;
            border-radius: 50%;
        }

        .user {
            position: relative;
            display: inline-block;
        }

        .user-menu {
            display: none;
            position: absolute;
            top: 100%;       /* ngay bên dưới */
            right: 0;         /* căn trái với cha .user */
            left: auto;
            background-color: white;
            min-width: 160px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            border: 1px solid #ccc;
            z-index: 100;
            list-style: none;
            padding: 0;
            margin: 0;
        }

        .user-menu li {
            padding: 10px;
            cursor: pointer;
        }

        .user-menu li:hover {
            background-color: #f0f0f0;
        }

        .login-btn {
            background-color: white;
            color: #007bff;
            padding: 10px 20px;
            font-size: 16px;
            border: 2px solid #007bff;
            border-radius: 6px;
            cursor: pointer;
            transition: all 0.3s ease;
        }

        .login-btn:hover {
            background-color: #007bff;
            color: white;
        }
        
        .main-container {
            min-height: 70vh;
        }
    </style>

</head>
<body>
    <!--Header-->
    <h1 class="title">Shoes Store</h1>
    <div class="header-bar">
        <div class="navbar">
            <a href="<c:url value="/" />" >Home</a> | 
        </div>

        <div class="auth-button" id="auth-btn">
            <!--<a href="<c:url value="/login" />">Log In</a>-->
            <%
                User user = (User) session.getAttribute("currentUser");
                if (user != null) {
            %>
            <div class="user">
                <div class="user-info">
                    <%= user.getFullName()%>
                    <img src="<c:url value='/imgs/avatars' />/<%= user.getAvatar()%>" alt="Avatar" class="user-avatar"/>
                </div>

                <ul class="user-menu">
                    <li class="menu-item">
                        <a>Information</a>
                    </li>

                    <%
                        if ("admin".equals(user.getRole())) {
                    %>

                    <li class="menu-item">
                        <a href="<c:url value="/admin/product" />" >Product Management</a>
                    </li>
                    
                    <li class="menu-item">
                        <a >User Management</a>
                    </li>

                    <%
                        }
                    %>

                    <li class="menu-item">
                        <a href="<c:url value='/logout' />">Logout</a>
                    </li>
                </ul>
            </div>

            <%
            } else {
            %>
            <button class="login-btn"><a href="<c:url value="/login" />">Login</a></button>
            <%
                }
            %>
        </div>
    </div>

    <hr/>
    <!--View-->
    <div class="main-container">
        <jsp:include page="/WEB-INF/views/${folder}/${view}.jsp" />
    </div>
    
    <!--Footer-->
    <hr/>
    &copy; 2025 HSU

    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <!--<script src="<c:url value="/js/layout.js" />"></script>-->

    <!-- Script -->
    <script>
        // Toggle dropdown
        $('.user-info').click(function (e) {
            e.stopPropagation();
            $('.user-menu').slideToggle(200);
        });

        // Đóng menu nếu click ra ngoài
        $(document).click(function (e) {
            if (!$(e.target).closest('.user').length) {
                $('.user-menu').slideUp(200);
            }
        });

        $(document).ready(function () {
            $('.menu-item').click(function () {
                $(this).find('a')[0].click();
            });
        });

        $(document).ready(function () {
            $('.login-btn').click(function () {
                $(this).find('a')[0].click();
            });
        });
    </script>
</body>
</html>
