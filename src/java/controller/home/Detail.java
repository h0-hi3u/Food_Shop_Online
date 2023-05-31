/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.SanPhamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SanPham;

/**
 *
 * @author Ho Trong Hieu
 */
@WebServlet(name = "Detail", urlPatterns = {"/home/Detail"})
public class Detail extends HttpServlet {
    
    private final SanPhamDAO objectDAO = new SanPhamDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String str = request.getParameter("id");   
        try {            
            SanPham data = objectDAO.details(str);
            request.setAttribute("data", data);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/home/details.jsp");
            rd.forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        };
    }
}
