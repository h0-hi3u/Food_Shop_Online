/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.TaiKhoanDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.TaiKhoan;

/**
 *
 * @author Ho Trong Hieu
 */
@WebServlet(name = "Login", urlPatterns = {"/home/Login"})
public class Login extends HttpServlet {

    private final TaiKhoanDAO objectDao = new TaiKhoanDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("username") != null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/home/index");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/home/login.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("txtUser");
        String password = request.getParameter("txtPassword");

        TaiKhoan _taikhoan = objectDao.details(username);

        if (_taikhoan == null) {
            request.setAttribute("noteLogin", "Incorrect User and Password!!");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/home/login.jsp");
            rd.forward(request, response);
        } else if (_taikhoan.getMatKhau().equals(password) == false) {
            request.setAttribute("noteLogin", "Incorrect User and Password!!");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/home/login.jsp");
            rd.forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("username", _taikhoan.getTenTK());
            session.setAttribute("role", _taikhoan.getNhomTaiKhoan().getNhomTaiKhoan());
            session.setMaxInactiveInterval(60 * 60);
            response.sendRedirect(request.getContextPath() + "/home/index");
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/home/index");
//            rd.forward(request, response);
        }
    }
}
