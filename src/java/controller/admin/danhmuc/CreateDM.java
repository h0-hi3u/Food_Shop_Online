/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.danhmuc;

import dao.DanhMucDAO;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "CreateDM", urlPatterns = {"/admin/danhmuc/CreateDM"})
public class CreateDM extends HttpServlet {

    private final DanhMucDAO objectDAO = new DanhMucDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<DanhMuc> listDanhMuc = objectDAO.read();
        int n = listDanhMuc.size() + 1;
        String a = "DM";
        a = a.concat(String.valueOf(n));
        request.setAttribute("madm", a);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/danhmuc/create.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String madm = request.getParameter("txtMaDanhMuc");
        String tendm = request.getParameter("txtTenDanhMuc");
        String str_trangthai = request.getParameter("txtTrangThai");
        boolean trangthai = str_trangthai.equals("true");
        DanhMuc danhMuc = new DanhMuc(madm, tendm, trangthai);
        objectDAO.create(danhMuc);
        response.sendRedirect("/SE161557/admin/danhmuc/IndexDM");

    }
}
