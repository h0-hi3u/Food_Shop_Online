/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.sanpham;

import dao.SanPhamDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ho Trong Hieu
 */
@WebServlet(name = "DeleteSP", urlPatterns = {"/admin/sanpham/DeleteSP"})
public class DeleteSP extends HttpServlet {

    private final SanPhamDAO objectDAO = new SanPhamDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String masp = request.getParameter("id");
        objectDAO.delete(masp);
        response.sendRedirect("/SE161557/admin/sanpham/IndexSP");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
