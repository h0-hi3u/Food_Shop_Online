<%-- 
    Document   : edit
    Created on : Mar 10, 2023, 12:48:25 PM
    Author     : Ho Trong Hieu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit San Pham</h1>
        <button>
            <a style="color: red" href="/SE161557/admin/sanpham/IndexSP"> Home San Pham </a>
        </button>
        <form action="/SE161557/admin/sanpham/EditSP" method="POST">
            <table border="1">
                <tr>
                    <td>Ma San Pham</td>
                    <td><input name="txtMaSP" value="${requestScope.item.masp}" readonly></td>
                </tr>
                <tr>
                    <td>Ten San Pham</td>
                    <td><input name="txtTenSP" value="${requestScope.item.tensp}"></td>
                </tr>
                <tr>
                    <td>Mo Ta</td>
                    <td><input name="txtMoTa" value="${requestScope.item.mota}"></td>
                </tr>
                <tr>
                    <td>So Luong</td>
                    <td><input name="txtSoLuong" value="${requestScope.item.soluong}" type="number"></td>
                </tr> 
                <tr>
                    <td>Don Gia</td>
                    <td><input name="txtDonGia" value="${requestScope.item.dongia}" type="number"></td>
                </tr>
                <tr>
                    <td>Hinh Anh (url)</td>
                    <td><input name="txtHinhAnh" value=""></td>
                </tr>
                <tr>
                    <td>Trang Thai (True/False)</td>
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
                <tr>
                    <td>Ma Nha Cung Cap</td>
                    <td>
                        <select name="txtMaNCC">
                            <option>${requestScope.nhacungcap}</option>
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
                            <option>${requestScope.danhmuc}</option>
                            <c:forEach var="DanhMuc" items="${requestScope.listDM}">
                                <option value="<c:out value="${DanhMuc.madm}"></c:out>"><c:out value="${DanhMuc.madm}"></c:out></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <button type="submit" value="submit"> Edit </button>
        </form>
    </body>
</html>
