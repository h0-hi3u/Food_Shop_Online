/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.nhacungcap;

import dao.NhaCungCapDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ho Trong Hieu
 */
@WebServlet(name = "DeleteNCC", urlPatterns = {"/admin/nhacungcap/DeleteNCC"})
public class DeleteNCC extends HttpServlet {

    private final NhaCungCapDAO objectDAO = new NhaCungCapDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mancc = request.getParameter("id");
        objectDAO.delete(mancc);
        response.sendRedirect("/SE161557/admin/nhacungcap/IndexNCC");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
