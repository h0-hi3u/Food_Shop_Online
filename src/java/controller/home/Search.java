/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.SanPhamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DanhMuc;
import model.SanPham;

/**
 *
 * @author Ho Trong Hieu
 */
@WebServlet(name = "Search", urlPatterns = {"/home/Search"})
public class Search extends HttpServlet {

    public static final String ID_FORMAT = "SP\\d{3}";
    private final SanPhamDAO objectDAO = new SanPhamDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/home/search.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tensp = request.getParameter("txtTenSanPham");
        List<SanPham> listItem = objectDAO.searchByName(tensp);
        if (listItem.isEmpty()) {
            request.setAttribute("thongbao", "San Pham Khong Ton Tai!!!");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/home/search.jsp");
            rd.forward(request, response);
        }else {
            request.setAttribute("thongbao", null);
            request.setAttribute("listItem", listItem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/home/search.jsp");
            rd.forward(request, response);
        }
    }

}
