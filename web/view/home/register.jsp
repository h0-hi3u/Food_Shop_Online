<%-- 
    Document   : register
    Created on : Feb 17, 2023, 3:26:54 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Register</h1>
        <c:if test="${requestScope.noteRegister != null}" >
            <h3 style="color: red"><c:out value="${requestScope.noteRegister}"></c:out></h3>
        </c:if>
        <form action="/SE161557/home/Register" method="POST">
            <table>
                <tr>
                    <td>User</td> 
                    <td><input type="text" id="txt1" name="txtUser" value=""></td>
                </tr>

                <tr>
                    <td>Password</td> 
                    <td><input type="password" id="txt2" name="txtPassword" value=""></td>
                </tr>
                <tr>
                    <td>Trang thai</td> 
                    <td><select name="txtTrangthai">
                            <option value="1"> 1 </option>
                            <option value="0"> 0 </option> 
                        </select></td>
                </tr>
                <tr>
                    <td>Email</td> 
                    <td><input type="text" id="txt3" name="txtEmail" value=""></td>
                </tr>
                <tr>
                    <td>Nhom Tai Khoan</td> 
                    <td><input type="text" id="txt4" name="txtNhomTk" value=""></td>
                </tr>
                <tr>
                    <td></td> 
                    <td>
                        <button type="submit">Register</button>
                        <button>
                            <a style="color: red" href="/SE161557/home/index"> Home </a>
                        </button>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
