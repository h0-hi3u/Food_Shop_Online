<%-- 
    Document   : index
    Created on : Feb 17, 2023, 3:16:06 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Danh Muc</h1>
        <button>
            <a style="color: red" href="/SE161557/home/index"> Home </a>
        </button>
        <table border="1">
            <thead>
                <tr>
                    <th>Ten Danh Muc</th>
                    <th>Trang Thai</th>
                    <th>Detail</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="DanhMuc" items="${requestScope.listItem}">
                    <tr>
                        <td><c:out value="${DanhMuc.tendm}"/></td>
                        <td><c:out value="${DanhMuc.trangthai}"/></td>
                        <td><button>
                                <a href="/SE161557/admin/danhmuc/DetailDM?id=<c:out value="${DanhMuc.madm}"/>">Detail</a>
                            </button></td>
                        <td>
                            <button>
                                <a href="/SE161557/admin/danhmuc/EditDM?id=<c:out value="${DanhMuc.madm}"/>">Edit</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="/SE161557/admin/danhmuc/DeleteDM?id=<c:out value="${DanhMuc.madm}"/>">Delete</a>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <button>
            <a style="color: red" href="/SE161557/admin/danhmuc/CreateDM"> Create </a>
        </button>
    </body>
</html>
