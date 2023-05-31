/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.nhacungcap;

import dao.NhaCungCapDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.NhaCungCap;

/**
 *
 * @author Ho Trong Hieu
 */
@WebServlet(name = "EditNCC", urlPatterns = {"/admin/nhacungcap/EditNCC"})
public class EditNCC extends HttpServlet {

    private final NhaCungCapDAO objectDAO = new NhaCungCapDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mancc = request.getParameter("id");
        NhaCungCap nhaCungCap = objectDAO.details(mancc);
        request.setAttribute("item", nhaCungCap);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/nhacungcap/edit.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mancc = request.getParameter("txtMaNCC");
        String tenncc = request.getParameter("txtTenNCC");
        String diaChi = request.getParameter("txtDiaChi");
        String str_trangThai = request.getParameter("txtTrangThai");
        boolean trangThai = str_trangThai.equals("true") || str_trangThai.equals("1");
        NhaCungCap nhaCungCap = new NhaCungCap(mancc, tenncc, diaChi, trangThai);
        objectDAO.update(nhaCungCap);
        response.sendRedirect("/SE161557/admin/nhacungcap/IndexNCC");
    }

}
