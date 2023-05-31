/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.danhmuc;

import dao.DanhMucDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DanhMuc;

/**
 *
 * @author Ho Trong Hieu
 */
@WebServlet(name = "EditDM", urlPatterns = {"/admin/danhmuc/EditDM"})
public class EditDM extends HttpServlet {

    private final DanhMucDAO objectDao = new DanhMucDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String madm = request.getParameter("id");
        DanhMuc danhMuc = objectDao.details(madm);
        request.setAttribute("item", danhMuc);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/danhmuc/edit.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String madm = request.getParameter("txtMaDanhMuc");
        String tendm = request.getParameter("txtTenDanhMuc");
        String str_trangthai = request.getParameter("txtTrangThai");
        boolean trangthai = false;
        if(str_trangthai.equals("true") || str_trangthai.equals("1")) {
            trangthai = true;
        } else {
            trangthai = false;
        }
        DanhMuc danhMuc = new DanhMuc(madm, tendm, trangthai);
        objectDao.update(danhMuc);
        response.sendRedirect("/SE161557/admin/danhmuc/IndexDM");
        
    }
}
