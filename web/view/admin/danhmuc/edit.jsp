<%-- 
    Document   : edit
    Created on : Feb 17, 2023, 3:16:31 PM
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
        <h1>Edit Danh Muc</h1>
        <button>
            <a style="color: red" href="/SE161557/admin/danhmuc/IndexDM"> Home Danh Muc </a>
        </button>
        <form action="/SE161557/admin/danhmuc/EditDM" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th>Ma Danh Muc</th>
                        <th>Ten Danh Muc</th>
                        <th>Trang Thai (True/False)</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="text" name="txtMaDanhMuc" value="${requestScope.item.madm}" readonly></td>
                        <td><input type="text" name="txtTenDanhMuc" value="${requestScope.item.tendm}"></td>
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
