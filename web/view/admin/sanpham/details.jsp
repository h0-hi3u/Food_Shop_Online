<%-- 
    Document   : details
    Created on : Mar 10, 2023, 12:37:17 PM
    Author     : Ho Trong Hieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
             table td, th{
                padding: 12px;
            }
            img{
                height: 80px;
                width: 80px;
            }
        </style>
    </head>
    <body>
        <h1>Detail San Pham</h1>
        <button>
            <a style="color: red" href="/SE161557/admin/sanpham/IndexSP"> Home San Pham </a>
        </button>
        <table border="1">
            <thead>
                <tr>
                    <th>Ma San Pham</th>
                    <th>Ten San Pham</th>
                    <th>Mo Ta</th>
                    <th>So Luong</th>
                    <th>Don Gia</th>
                    <th>Hinh Anh</th>
                    <th>Trang Thai</th>
                    <th>Nha Cung Cap</th>
                    <th>Danh Muc</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${requestScope.item.masp}</td>
                    <td>${requestScope.item.tensp}</td>
                    <td>${requestScope.item.mota}</td>
                    <td>${requestScope.item.soluong}</td>
                    <td>${requestScope.item.dongia}</td>
                    <td><img src="${requestScope.item.hinhanh}" alt="Null"></td>
                    <td>${requestScope.item.trangthai}</td>
                    <td>${requestScope.nhacungcap}</td>
                    <td>${requestScope.danhmuc}</td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
