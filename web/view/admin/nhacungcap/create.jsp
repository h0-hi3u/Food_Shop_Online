<%-- 
    Document   : create
    Created on : Mar 10, 2023, 12:04:55 PM
    Author     : Ho Trong Hieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create Nha Cung Cap</h1>
        <button>
            <a style="color: red" href="/SE161557/admin/nhacungcap/IndexNCC"> Home Nha Cung Cap </a>
        </button>
        <h3 style="color: red">${requestScope.noteCreate}</h3>
        <form action="/SE161557/admin/nhacungcap/CreateNCC" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th>Ma Nha Cung Cap</th>
                        <th>Nha Cung Cap</th>
                        <th>Dia Chi</th>
                        <th>Trang Thai (True/False)</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="text" name="txtMaNCC" value="${requestScope.mancc}" readonly></td>
                        <td><input type="text" name="txtTenNCC" value=""></td>
                        <td><input type="text" name="txtDiaChi" value=""></td>
                        <td>
                            <input type="radio" id="html" name="txtTrangThai" value="true">
                              <label for="TRUE">True</label>
                              <input type="radio" id="css" name="txtTrangThai" value="false">
                              <label for="FALSE">False</label><br>
                        </td>
                    </tr>
                </tbody>
            </table>
            <button type="submit" value="submit"> 
                Create
            </button>
        </form>
    </body>
</html>
