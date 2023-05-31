/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.NhomTaiKhoanDAO;
import dao.TaiKhoanDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.NhomTaiKhoan;
import model.TaiKhoan;

/**
 *
 * @author Ho Trong Hieu
 */
@WebServlet(name = "Register", urlPatterns = {"/home/Register"})
public class Register extends HttpServlet {
    private final TaiKhoanDAO objectDAO  = new TaiKhoanDAO();
    private final NhomTaiKhoanDAO nhomTkDAO = new NhomTaiKhoanDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/home/register.jsp");
        rd.forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("txtUser");
        String pass = request.getParameter("txtPassword");
        String trangthai = request.getParameter("txtTrangthai");
        boolean trangthai_boolean = Boolean.parseBoolean(trangthai);
        String email = request.getParameter("txtEmail");
        String str_nhomtk = request.getParameter("txtNhomTk");
        NhomTaiKhoan nhomtk = nhomTkDAO.details(str_nhomtk);
        TaiKhoan taiKhoan_check = objectDAO.details(user);
        if(taiKhoan_check != null) {
            request.setAttribute("noteRegister", "Username is exist!!!");
            
        } else if (nhomtk == null) {
            request.setAttribute("noteRegister", "Nhom Tai Khoan is not exist!!!");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/home/register.jsp");
            rd.forward(request, response);
        } else {
            TaiKhoan taiKhoan = new TaiKhoan(user, pass, trangthai_boolean, email, nhomtk);
            objectDAO.create(taiKhoan);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/home/login.jsp");
            rd.forward(request, response); 
        }
    }

}
