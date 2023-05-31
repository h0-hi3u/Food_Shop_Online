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
        <title>JSP Page</title>
        <style>
            table td, th{
                padding: 12px;
            }
            img{
                height: 80px;
                width: 80px;
            }
        </style>
    </head>
    <body>
        <h1>Detail</h1>

        <button>
            <a style="color: red" href="/SE161557/home/index"> Home </a>
        </button>
        <table border="1">
            <thead>
                <tr>
                    <th> Ma San Pham </th>
                    <th> Ten San Pham </th>
                    <th> Mo Ta </th>
                    <th> So Luong </th>
                    <th> Don Gia </th>
                    <th> Hinh Anh</th>
                    <th> Trang Thai </th>
                    <th> Nha Cung Cap </th>
                    <th> Danh Muc </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><c:out value="${requestScope.data.masp}"/></td>
                    <td><c:out value="${requestScope.data.tensp}"/></td>
                    <td><c:out value="${requestScope.data.mota}"/></td>
                    <td><c:out value="${requestScope.data.soluong}"/></td>
                    <td><c:out value="${requestScope.data.dongia}"/></td>
                    <td><img src="<c:out value="${requestScope.data.hinhanh}"/>" alt="Error"></td>
                    <td><c:out value="${requestScope.data.trangthai}"/></td>
                    <td><c:out value="${requestScope.data.nhacungcap.getTenncc()}"/></td>
                    <td><c:out value="${requestScope.data.danhmuc.getTendm()}"/></td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
