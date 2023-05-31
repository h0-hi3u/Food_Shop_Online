/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.nhacungcap;

import controller.admin.danhmuc.IndexDM;
import dao.NhaCungCapDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "IndexNCC", urlPatterns = {"/admin/nhacungcap/IndexNCC"})
public class IndexNCC extends HttpServlet {

    private final NhaCungCapDAO objectDAO = new NhaCungCapDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            objectDAO.read();
            List<NhaCungCap> listItem = objectDAO.getListItems();
            request.setAttribute("listItem", listItem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/nhacungcap/index.jsp");
            rd.forward(request, response);
        } catch (IOException | ServletException ex ) {
            Logger.getLogger(IndexNCC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
