<%-- 
    Document   : index
    Created on : Mar 10, 2023, 12:24:45 PM
    Author     : Ho Trong Hieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h1>Home San Pham</h1>
        <button>
            <a style="color: red" href="/SE161557/home/index"> Home </a>
        </button>
        <button>
            <a style="color: red" href="/SE161557/admin/sanpham/CreateSP"> Create </a>
        </button>
        <table border="1">
            <thead>
                <tr>
                    <th> Ten San Pham </th>
                    <th> Don Gia </th>
                    <th> Hinh Anh</th>
                    <th> Trang Thai </th>
                    <th> Detail</th>
                    <th> Edit</th>
                    <th> Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="SanPham" items="${requestScope.listItem}">
                    <tr>
                        <td><c:out value="${SanPham.tensp}"/></td>
                        <td><c:out value="${SanPham.dongia}"/></td>
                        <td><img src="<c:out value="${SanPham.hinhanh}"/>" alt="Error"></td>
                        <td><c:out value="${SanPham.trangthai}"/></td>
                        <td>
                            <button>
                                <a href="/SE161557/admin/sanpham/DetailSP?id=<c:out value="${SanPham.masp}"/>">Detail</a>
                            </button></td>
                        <td>
                            <button>
                                <a href="/SE161557/admin/sanpham/EditSP?id=<c:out value="${SanPham.masp}"/>">Edit</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="/SE161557/admin/sanpham/DeleteSP?id=<c:out value="${SanPham.masp}"/>">Delete</a>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
