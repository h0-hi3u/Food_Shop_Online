<%-- 
    Document   : login
    Created on : Feb 17, 2023, 3:26:40 PM
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
        <button>
            <a style="text-decoration: none; color: red" href="/SE161557/home/index"> Home </a>
        </button>
        <form action="/SE161557/home/Login" method="POST">
            <h1> Login </h1>
            <table>

                <tr>
                    <td>User</td> 
                    <td><input type="text" id="txt1" name="txtUser" value=""></td>
                </tr>
                <tr>
                    <td>Password</td> 
                    <td><input type="password" id="txt2" name="txtPassword" value=""></td>
                </tr>
                <c:if test="${requestScope.noteLogin != null}" >
                    <h3 style="color: red"><c:out value="${requestScope.noteLogin}"></c:out></h3>
                </c:if>
                    
                <tr>
                    <td></td> 
                    <td><button type="submit">Login</button>
                        <button>
                            <a style="text-decoration: none; color: red" href="/SE161557/home/Register"> Register </a>
                        </button>
                    </td>
                </tr>
            </table>

        </form>
    </body>
</html>
