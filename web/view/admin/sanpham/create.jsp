<%-- 
    Document   : create
    Created on : Mar 10, 2023, 1:56:21 PM
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
        <h1>Create San Pham</h1>
        <button>
            <a style="color: red" href="/SE161557/admin/sanpham/IndexSP"> Home San Pham </a>
        </button>
        <h3 style="color: red">${requestScope.noteCreate}</h3>
        <form action="/SE161557/admin/sanpham/CreateSP" method="POST">
            <table border="1">
                <tr>
                    <td>Ma San Pham</td>
                    <td><input name="txtMaSP" value=""></td>
                </tr>
                <tr>
                    <td>Ten San Pham</td>
                    <td><input name="txtTenSP" value=""></td>
                </tr>
                <tr>
                    <td>Mo Ta</td>
                    <td><input name="txtMoTa" value=""></td>
                </tr>
                <tr>
                    <td>So Luong</td>
                    <td><input name="txtSoLuong" value=""></td>
                </tr> 
                <tr>
                    <td>Don Gia</td>
                    <td><input name="txtDonGia" value=""></td>
                </tr>
                <tr>
                    <td>Hinh Anh (url)</td>
                    <td><input name="txtHinhAnh" value=""></td>
                </tr>
                <tr>
                    <td>Trang Thai (True/False)</td>
                    <td>
                        <input type="radio" id="html" name="txtTrangThai" value="true">
                          <label for="TRUE">True</label>
                          <input type="radio" id="css" name="txtTrangThai" value="false">
                          <label for="FALSE">False</label><br>
                    </td>
                </tr>
                <tr>
                    <td>Ma Nha Cung Cap</td>
                    <td>
                        <select name="txtMaNCC">
                            <c:forEach var="NhaCungCap" items="${requestScope.listNCC}">
                                <option value="<c:out value="${NhaCungCap.mancc}"></c:out>"><c:out value="${NhaCungCap.mancc}"></c:out></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Ma Danh Muc</td>
                    <td>
                        <select name="txtMaDM">
                            <c:forEach var="DanhMuc" items="${requestScope.listDM}">
                                <option value="<c:out value="${DanhMuc.madm}"></c:out>"><c:out value="${DanhMuc.madm}"></c:out></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
                 <c:if test="${requestScope.noteSP != null}" >
                    <h3 style="color: red"><c:out value="${requestScope.noteSP}"></c:out></h3>
                </c:if>
            <button type="submit" value="submit"> Create </button>
        </form>
    </body>
</html>
