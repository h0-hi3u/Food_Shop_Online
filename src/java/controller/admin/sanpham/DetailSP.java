/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.sanpham;

import dao.SanPhamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.NhaCungCap;
import model.SanPham;

/**
 *
 * @author Ho Trong Hieu
 */
@WebServlet(name = "DetailSP", urlPatterns = {"/admin/sanpham/DetailSP"})
public class DetailSP extends HttpServlet {

    private final SanPhamDAO objectDAO = new SanPhamDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String masp = request.getParameter("id");
        SanPham sanPham = objectDAO.details(masp);
        request.setAttribute("item", sanPham);
        request.setAttribute("nhacungcap", sanPham.getNhacungcap().getTenncc());
        request.setAttribute("danhmuc", sanPham.getDanhmuc().getTendm());
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/sanpham/details.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
