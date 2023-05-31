/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.home;

import dao.ChiTietHoaDonDAO;
import dao.HoaDonDAO;
import dao.TaiKhoanDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.ChiTietHoaDon;
import model.HoaDon;
import model.SanPham;
import model.TaiKhoan;

/**
 *
 * @author Ho Trong Hieu
 */
@WebServlet(name = "Payment", urlPatterns = {"/home/Payment"})
public class Payment extends HttpServlet {

    private final HoaDonDAO hoaDonDAO = new HoaDonDAO();
    private final TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
    private final ChiTietHoaDonDAO CTHDDAO = new ChiTietHoaDonDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart myCart = (Cart) session.getAttribute("cart");
        session.setAttribute("cart", myCart);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/home/payment.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        TaiKhoan taiKhoan = taiKhoanDAO.details(username);
        Cart myCart = (Cart) session.getAttribute("cart");
        session.setAttribute("cart", null);
        List<HoaDon> listHoaDon = hoaDonDAO.read();
        int numberHoaDon = 0;
        numberHoaDon = listHoaDon.size() + 1;
        String str_numberHoaDon = String.valueOf(numberHoaDon);
        String hd = "HD";
        String maHD = hd.concat(str_numberHoaDon);
//        Date date = new Date();
//        SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String str_date = formatter.format(dateTime);
        HoaDon new_hoaDon = new HoaDon(maHD, str_date, 1, taiKhoan);
        hoaDonDAO.create(new_hoaDon);
        int numberSanPham = myCart.getListCartItem().size();
        for (int i = 0; i < numberSanPham; i++) {
            SanPham sanPham = myCart.getListCartItem().get(i).getSanPham();
            int soLuong = myCart.getListCartItem().get(i).getAmount();
            float donGia = myCart.getListCartItem().get(i).getDongia();
            float khuyenMai = 0;
            float giaTri = soLuong * donGia;
            HoaDon hoaDon = hoaDonDAO.details(maHD);
            ChiTietHoaDon item = new ChiTietHoaDon(soLuong, donGia, khuyenMai, giaTri, sanPham, hoaDon);
            CTHDDAO.create(item);
        }

        response.sendRedirect("/SE161557/home/index");
    }
}
