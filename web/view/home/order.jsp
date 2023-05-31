<%-- 
    Document   : order
    Created on : Feb 17, 2023, 3:17:12 PM
    Author     : Admin
--%>

<%@page import="model.CartItem"%>
<%@page import="java.util.List"%>
<%@page import="model.Cart"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Order</title>
    <style>
        img{
            height: 80px;
            width: 80px;
        }
    </style>
</head>
<body>
    <h1>Order</h1>
    <button >
        <a style="text-decoration: none; color: red" href="/SE161557/home/index"> Home </a>
    </button>
    <c:if test="${sessionScope.listItem != null}" >
        <button >
            <a style="text-decoration: none; color: red" href="/SE161557/home/Payment"> Payment </a>
        </button>
    </c:if>
    <c:if test="${sessionScope.listItem != null}" >
        <table border="1">
            <thead>
                <tr>
                    <th>San Pham</th>
                    <th>Hinh Anh</th>
                    <th>Don Gia</th>
                    <th>So Luong Da Chon</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cartItem" items="${sessionScope.listItem}">
                    <tr>
                        <th><c:out value="${cartItem.tensp}"/></th>
                        <th><img src="<c:out value="${cartItem.hinhanh}"/>"></th>
                        <th><c:out value="${cartItem.dongia}"/></th>
                        <th><c:out value="${cartItem.amount}"/></th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${sessionScope.listItem == null}" >
        <h1>Khong co san pham nao duoc chon</h1>
    </c:if>
</body>