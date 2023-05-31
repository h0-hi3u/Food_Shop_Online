<%-- 
    Document   : details
    Created on : Mar 10, 2023, 10:47:49 AM
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
        <h1>Detail Nha Cung Cap</h1>
        <button>
            <a style="color: red" href="/SE161557/admin/nhacungcap/IndexNCC"> Home Nha Cung Cap </a>
        </button>
        <table border="1">
            <thead>
                <tr>
                    <th>Ma Nha Cung Cap</th>
                    <th>Nha Cung Cap</th>
                    <th>Dia Chi</th>
                    <th>Trang Thai</th>
                </tr>
            </thead>
            <tbody>
                <tr><td>${requestScope.item.mancc}</td>
                    <td>${requestScope.item.tenncc}</td>
                    <td>${requestScope.item.diachi}</td>
                    <td>${requestScope.item.trangthai}</td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
