<%-- 
    Document   : search
    Created on : Feb 17, 2023, 3:17:56 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h1>Search</h1>
        <button>
            <a style="color: red" href="/SE161557/home/index"> Home </a>
        </button>
        <form action="Search" method="POST">
            Nhap Ten San Pham: <input type="text" id="txtMaSanPham" name="txtTenSanPham" value=""><br>
            <button type="submit" value="search"> Search </button>
        </form>
        <c:if test="${requestScope.listItem != null}" >
            <table border="1">
                <thead>
                    <tr>
                        <th> Ten San Pham </th>
                        <th> Don Gia </th>
                        <th> Hinh Anh</th>
                        <th> Trang Thai</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="SanPham" items="${requestScope.listItem}">
                        <tr>
                            <td><c:out value="${SanPham.tensp}"/></td>
                            <td><c:out value="${SanPham.dongia}"/></td>
                            <td><img src="<c:out value="${SanPham.hinhanh}"/>" alt="Error"></td>
                            <td><c:out value="${SanPham.trangthai}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>  
        <h3 style="color: red">${requestScope.thongbao}</h3>

    </body>
</html>
