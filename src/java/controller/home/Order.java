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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.CartItem;
import model.SanPham;

/**
 *
 * @author Ho Trong Hieu
 */
@WebServlet(name = "Order", urlPatterns = {"/home/Order"})
public class Order extends HttpServlet {
    private final SanPhamDAO objectDAO = new SanPhamDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String PID = request.getParameter("id");
        
        if (session.getAttribute("cart") == null) {
            SanPham item = new SanPham();
            item = objectDAO.details(PID);
            Cart myCart = new Cart();
            CartItem cart = new CartItem(item, 1, item.getTensp(), item.getHinhanh(), item.getDongia());
            myCart.getListCartItem().add(cart);
            session.setAttribute("cart", myCart);
            response.sendRedirect(request.getContextPath() + "/home/index");
        } else {
            Cart myCart = (Cart) session.getAttribute("cart");
            boolean checkExist = false;
            int n = myCart.getListCartItem().size();
            SanPham item = objectDAO.details(PID);
            for (int i = 0; i < n; i++) {
                if (myCart.getListCartItem().get(i).getSanPham().getMasp().equals(PID)) {
                    int newAmount = myCart.getListCartItem().get(i).getAmount() + 1;
                    myCart.getListCartItem().get(i).setAmount(newAmount);
                    checkExist = true;
                    break;
                } else {
                    checkExist = false;
                }
            }
            if (!checkExist) {
                CartItem cart = new CartItem(item, 1 ,item.getTensp(), item.getHinhanh(), item.getDongia());
                myCart.getListCartItem().add(cart);
            }
            session.setAttribute("cart", myCart);
            response.sendRedirect(request.getContextPath() + "/home/index");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
