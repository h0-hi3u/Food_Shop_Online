<%-- 
    Document   : edit
    Created on : Mar 10, 2023, 11:01:15 AM
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
        <h1>Edit Nha Cung Cap</h1>
        <button>
            <a style="color: red" href="/SE161557/admin/nhacungcap/IndexNCC"> Home Nha Cung Cap </a>
        </button>
        <form action="/SE161557/admin/nhacungcap/EditNCC" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th>Ma Danh Muc</th>
                        <th>Ten Danh Muc</th>
                        <th>Dia Chi</th>
                        <th>Trang Thai (True/False)</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="text" name="txtMaNCC" value="${requestScope.item.mancc}" readonly></td>
                        <td><input type="text" name="txtTenNCC" value="${requestScope.item.tenncc}"></td>
                        <td><input type="text" name="txtDiaChi" value="${requestScope.item.diachi}"></td>
                        <td>
                            <c:if test="${requestScope.item.trangthai == true}" >
                                <input type="radio" id="html" name="txtTrangThai" value="true" checked>
                                  <label for="TRUE">True</label>
                                  <input type="radio" id="css" name="txtTrangThai" value="false">
                                  <label for="FALSE">False</label><br>
                            </c:if>
                            <c:if test="${requestScope.item.trangthai == false}" >
                                <input type="radio" id="html" name="txtTrangThai" value="true" >
                                  <label for="TRUE">True</label>
                                  <input type="radio" id="css" name="txtTrangThai" value="false" checked>
                                  <label for="FALSE">False</label><br>
                            </c:if>
                        </td>
                    </tr>
                </tbody>
            </table>
            <button type="submit" value="submit"> 
                Edit
            </button>
        </form>
    </body>
</html>
