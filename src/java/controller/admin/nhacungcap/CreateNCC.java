/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.nhacungcap;

import dao.NhaCungCapDAO;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "CreateNCC", urlPatterns = {"/admin/nhacungcap/CreateNCC"})
public class CreateNCC extends HttpServlet {

    public static final String ID_FORMAT = "NCC\\d{2}";
    private final NhaCungCapDAO objectDAO = new NhaCungCapDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<NhaCungCap> listNhaCungCap = objectDAO.read();
        int n = listNhaCungCap.size() + 1;
        String a = "NCC";
        if (n < 10) {
            a = a.concat("0" + String.valueOf(n));
        } else {
            a = a.concat(String.valueOf(n));
        }
        request.setAttribute("mancc", a);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/nhacungcap/create.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mancc = request.getParameter("txtMaNCC");
        String tenncc = request.getParameter("txtTenNCC");
        String diachi = request.getParameter("txtDiaChi");
        String str_trangthai = request.getParameter("txtTrangThai");
        boolean trangthai = str_trangthai.equals("true") || str_trangthai.equals("1");
        NhaCungCap nhacungcap = new NhaCungCap(mancc, tenncc, diachi, trangthai);
        objectDAO.create(nhacungcap);
        response.sendRedirect("/SE161557/admin/nhacungcap/IndexNCC");
    }

}
