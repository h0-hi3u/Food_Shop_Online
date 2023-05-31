<%-- 
    Document   : create
    Created on : Feb 17, 2023, 3:16:45 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create Danh Muc</h1>
        <button>
            <a style="color: red" href="/SE161557/admin/danhmuc/IndexDM"> Home Danh Muc </a>
        </button>
        <form action="/SE161557/admin/danhmuc/CreateDM" method="POST">
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
                        <td><input type="text" name="txtMaDanhMuc" value="${requestScope.madm}" readonly></td>
                        <td><input type="text" name="txtTenDanhMuc" value=""></td>
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
