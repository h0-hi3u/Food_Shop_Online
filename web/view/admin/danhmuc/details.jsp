<%-- 
    Document   : details
    Created on : Feb 17, 2023, 3:16:14 PM
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
        <h1>Detail Danh Muc</h1>
        <button>
            <a style="color: red" href="/SE161557/admin/danhmuc/IndexDM"> Home Danh Muc </a>
        </button>
        <table border="1">
            <thead>
                <tr>
                    <th>Ma Danh Muc</th>
                    <th>Ten Danh Muc</th>
                    <th>Trang Thai</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${requestScope.item.madm}</td>
                    <td>${requestScope.item.tendm}</td>
                    <td>${requestScope.item.trangthai}</td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
