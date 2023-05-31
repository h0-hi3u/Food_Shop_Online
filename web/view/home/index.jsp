<%-- 
    Document   : testJSTL
    Created on : Mar 6, 2023, 11:19:30 PM
    Author     : Ho Trong Hieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <style>
            *{
                margin: 0;
                padding: 0;
            }
            #btn {
                display: block;
            }
            a{
                display: block;
            }
            #product{
                display: inline-block;
                width: 19%;
                height: 300px;
            }
            #product p {
                display: flex;
                justify-content: center;
                font-size: 40px;
                height: 20%;
                padding-top: 10px;
            }
            img{
                display: block;
                height: 55%;
                width: 100%;
            }
            button{
                height: 20%;
                width: 49%;
                background-color: rgb(227, 17, 17);
            }
            button a {
                text-decoration: none;
                color: azure;
                font-size: 20px;
                display: block;
            }
            #admin {
                display: flex;
                height: 50px;
                margin-bottom: 20px;
            }
            #admin .btn {
                height: 100%;
                width: 20%;
                margin: auto;
            }
            #user {

                height: 30px;
            }
            #user .btn {
                height: 100%;
                width: 10%;
                margin: auto;
            }
        </style>
    </head>
    <body>
        
        <%@ include file="../header.jsp" %>
        <div id="user">
            <button class="btn" style="background-color: white ">
                <a style="color: red" href="/SE161557/home/ViewCart"> ViewCart </a>
            </button>
            <button class="btn" style="background-color: white ">
                <a style="color: red" href="/SE161557/home/Logout"> Login/Logout </a>
            </button>
            <button class="btn" style="background-color: white ">
                <a style="color: red" href="/SE161557/home/Search"> Search </a>
            </button>
        </div>
        <c:forEach var="SanPham" items="${requestScope.listItem}">
            <div id="product">
                <p><c:out value="${SanPham.tensp}"/></p>
                <img src="<c:out value="${SanPham.hinhanh}"/>" alt="Error">
                <p><c:out value="${SanPham.dongia}"/></p>
                <button class="detail">
                    <a href="/SE161557/home/Order?id=<c:out value="${SanPham.masp}"/>">Order</a>
                </button>
                <button class="detail">
                    <a href="/SE161557/home/Detail?id=<c:out value="${SanPham.masp}"/>">Detail</a>
                </button>
            </div>
        </c:forEach>
    </body>
</html>
