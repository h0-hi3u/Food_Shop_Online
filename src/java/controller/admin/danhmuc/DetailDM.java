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
@WebServlet(name = "DetailDM", urlPatterns = {"/admin/danhmuc/DetailDM"})
public class DetailDM extends HttpServlet {
    private final DanhMucDAO objectDao = new DanhMucDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String madm = request.getParameter("id");
        DanhMuc danhMuc = objectDao.details(madm);
        request.setAttribute("item", danhMuc);
        RequestDispatcher rd  = getServletContext().getRequestDispatcher("/view/admin/danhmuc/details.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
