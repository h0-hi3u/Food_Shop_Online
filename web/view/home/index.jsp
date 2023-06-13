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
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
            rel="stylesheet">
        <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js"
        crossorigin="anonymous"></script>
        <title>Home</title>
        <style>
            a{
                text-decoration: none;
            }
            #name-price {
                width: 49%;
                display: inline-block;
                font-size: 30px;
            }

            #order-detail {
                margin-bottom: 10px;
            }


        </style>
    </head>
    <body>

        <div class="container mt-3">
            <!-- admin role -->

            <c:if test = "${sessionScope.role == 'Admin'}">
                <%@ include file="../header.jsp" %>
            </c:if>

            <!-- nvabar -->
            <div class="mt-3">
                <button class="btn btn-outline-success btn-lg">
                    <a class="link-success" href="/SE161557/home/ViewCart"> ViewCart
                    </a>
                </button>
                <button class="btn btn-outline-success btn-lg">
                    <a class="link-success" href="/SE161557/home/Logout"> Login/Logout
                    </a>
                </button>
                <button style="float: right"
                        class="btn btn-outline-success btn-lg">
                    <a class="link-success" href="/SE161557/home/Search"> Search </a>
                </button>
            </div>
            <!-- product -->
            <div class="row">
                <c:forEach var="SanPham" items="${requestScope.listItem}">
                    <div class="col-sm-3 text-center mt-3 border border-secondary rounded">
                        <img id="product" class="rounder" width="300" height="200"
                             src="<c:out value="${SanPham.hinhanh}"/>"
                             alt="Error">
                        <div>
                            <p id="name-price"><c:out value="${SanPham.tensp}"/></p>
                            <p id="name-price"><c:out value="${SanPham.dongia}"/></p>
                        </div>
                        <button id="order-detail" class="btn btn-outline-success btn-lg">
                            <a class="link-success" href="/SE161557/home/Order?id=<c:out value="${SanPham.masp}"/>">Order</a>
                        </button>
                        <button id="order-detail" class="btn btn-outline-success btn-lg">
                            <a class="link-success" href="/SE161557/home/Detail?id=<c:out value="${SanPham.masp}"/>">Detail</a>
                        </button>
                    </div>
                </c:forEach>
            </div>
        </div>

    </body>
</html>
