<%-- 
    Document   : index
    Created on : Mar 9, 2023, 11:58:17 PM
    Author     : Ho Trong Hieu
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
        <h1>Home Nha Cung Cap</h1>
        <button>
            <a style="color: red" href="/SE161557/home/index"> Home </a>
        </button>
        <table border="1">
            <thead>
                <tr>
                    <th>Nha Cung Cap</th>
                    <th>Dia Chi</th>
                    <th>Trang Thai</th>
                    <th>Detail</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="NhaCungCap" items="${requestScope.listItem}">
                    <tr>
                        <td><c:out value="${NhaCungCap.tenncc}"/></td>
                        <td><c:out value="${NhaCungCap.diachi}"/></td>
                        <td><c:out value="${NhaCungCap.trangthai}"/></td>
                        <td><button>
                                <a href="/SE161557/admin/nhacungcap/DetailNCC?id=<c:out value="${NhaCungCap.mancc}"/>">Detail</a>
                            </button></td>
                        <td>
                            <button>
                                <a href="/SE161557/admin/nhacungcap/EditNCC?id=<c:out value="${NhaCungCap.mancc}"/>">Edit</a>
                            </button>
                        </td>
                        <td>
                            <button>
                                <a href="/SE161557/admin/nhacungcap/DeleteNCC?id=<c:out value="${NhaCungCap.mancc}"/>">Delete</a>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <button>
            <a style="color: red" href="/SE161557/admin/nhacungcap/CreateNCC"> Create </a>
        </button>
    </body>
</html>
