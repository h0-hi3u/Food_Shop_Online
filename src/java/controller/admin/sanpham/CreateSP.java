/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin.sanpham;

import dao.DanhMucDAO;
import dao.NhaCungCapDAO;
import dao.SanPhamDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DanhMuc;
import model.NhaCungCap;
import model.SanPham;

/**
 *
 * @author Ho Trong Hieu
 */
@WebServlet(name = "CreateSP", urlPatterns = {"/admin/sanpham/CreateSP"})
public class CreateSP extends HttpServlet {

    public static final String FORMAT_SP = "SP\\d{3}";
    private final SanPhamDAO sanPhamDAO = new SanPhamDAO();
    private final NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
    private final DanhMucDAO danhMucDAO = new DanhMucDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<NhaCungCap> listNCC = nhaCungCapDAO.read();
        List<DanhMuc> listDM = danhMucDAO.read();
        request.setAttribute("listNCC", listNCC);
        request.setAttribute("listDM", listDM);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/sanpham/create.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String masp = request.getParameter("txtMaSP");
        SanPham sp = sanPhamDAO.details(masp);
        List<NhaCungCap> listNCC = nhaCungCapDAO.read();
        List<DanhMuc> listDM = danhMucDAO.read();
        String name = request.getParameter("txtTenSP");
        if (masp.isEmpty()) {
            request.setAttribute("listNCC", listNCC);
            request.setAttribute("listDM", listDM);
            request.setAttribute("noteSP", "ID can not empty!!!");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/sanpham/create.jsp");
            rd.forward(request, response);
        } else if (!masp.matches(FORMAT_SP)) {
            request.setAttribute("listNCC", listNCC);
            request.setAttribute("listDM", listDM);
            request.setAttribute("noteSP", "Format San Pham is SPxxx!!!");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/sanpham/create.jsp");
            rd.forward(request, response);
        } else if (sp != null) {
            request.setAttribute("listNCC", listNCC);
            request.setAttribute("listDM", listDM);
            request.setAttribute("noteSP", "Ma San Pham Da Ton Tai!!!");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/sanpham/create.jsp");
            rd.forward(request, response);
        } else if (name.isEmpty()) {
            request.setAttribute("listNCC", listNCC);
            request.setAttribute("listDM", listDM);
            request.setAttribute("noteSP", "Name can not empty!!!");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/sanpham/create.jsp");
            rd.forward(request, response);
        } else {
            String tensp = request.getParameter("txtTenSP");
            String moTa = request.getParameter("txtMoTa");
            int soLuong = 0;
            float donGia = 0;
            try {
                String str_soLuong = request.getParameter("txtSoLuong");
                soLuong = Integer.parseInt(str_soLuong);
            } catch (NumberFormatException ex) {
                soLuong = 0;
            }
            try {
                String str_donGia = request.getParameter("txtDonGia");
                donGia = Float.parseFloat(str_donGia);
            } catch (NumberFormatException ex) {
                donGia = 0;
            }
            String hinhAnh = request.getParameter("txtHinhAnh");
            String str_trangThai = request.getParameter("txtTrangThai");
            boolean trangThai = str_trangThai.equals("true");
            String str_nhaCungCap = request.getParameter("txtMaNCC");
            String str_danhMuc = request.getParameter("txtMaDM");
            NhaCungCap nhaCungCap = nhaCungCapDAO.details(str_nhaCungCap);
            DanhMuc danhMuc = danhMucDAO.details(str_danhMuc);
            SanPham sanPham = new SanPham(masp, tensp, moTa, soLuong, donGia, hinhAnh, trangThai, nhaCungCap, danhMuc);
            sanPhamDAO.create(sanPham);
            response.sendRedirect("/SE161557/admin/sanpham/IndexSP");
        }

    }
}
