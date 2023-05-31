<%-- 
    Document   : payment
    Created on : Feb 17, 2023, 3:17:27 PM
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
    <title>JSP Page</title>
    <style>
        img{
            height: 80px;
            width: 80px;
        }
    </style>
</head>
<body>
    <h1>Payment</h1>
    <button >
        <a style="text-decoration: none; color: red" href="/SE161557/home/index"> Home </a>
    </button>
    <form action="Payment" method="POST">
        <c:set var="total" scope="page" value="${0}"/> 
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
                <input style="display: none" name="txtName" value="${cartItem.tensp}">
                    <tr>
                        <th><c:out value="${cartItem.tensp}"/></th>
                        <th><img src="<c:out value="${cartItem.hinhanh}"/>"></th>
                        <th><c:out value="${cartItem.dongia}"/></th>
                        <th><c:out value="${cartItem.amount}"/></th>
                            <c:set var="total" scope="page" value="${total+(cartItem.dongia*cartItem.amount)}"/> 
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <h1>Total: <c:out value="${total}"></c:out></h1>
        <h3>Loi Nhac Cho Shop: <input type="text"></h3>
        <button type="submit" name="btn" value="submit">Payment</button>
    </form>
</body>



