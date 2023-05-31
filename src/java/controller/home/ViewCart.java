/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;

/**
 *
 * @author Ho Trong Hieu
 */
@WebServlet(name = "ViewCart", urlPatterns = {"/home/ViewCart"})
public class ViewCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") == null) {
            session.setAttribute("listItem",null);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/home/order.jsp");
            rd.forward(request, response);
        } else {
            Cart myCart = (Cart) session.getAttribute("cart");
            session.setAttribute("listItem", myCart.getListCartItem());

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/home/order.jsp");
            rd.forward(request, response);
        }
    }

}
