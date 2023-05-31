/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.danhmuc;

import dao.DanhMucDAO;
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
import model.DanhMuc;

/**
 *
 * @author Ho Trong Hieu
 */
@WebServlet(name = "IndexDM", urlPatterns = {"/admin/danhmuc/IndexDM"})
public class IndexDM extends HttpServlet {
    private final DanhMucDAO objectDAO = new DanhMucDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            objectDAO.read();
            List<DanhMuc> listItem = objectDAO.getListItems();
            request.setAttribute("listItem", listItem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/danhmuc/index.jsp");
            rd.forward(request, response);
        } catch (IOException | ServletException ex ) {
            Logger.getLogger(IndexDM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
