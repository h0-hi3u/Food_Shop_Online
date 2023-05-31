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
import java.io.PrintWriter;
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
@WebServlet(name = "EditSP", urlPatterns = {"/admin/sanpham/EditSP"})
public class EditSP extends HttpServlet {

    private final SanPhamDAO objectDAO = new SanPhamDAO();
    private final NhaCungCapDAO nccDAO = new NhaCungCapDAO();
    private final DanhMucDAO dmDAO = new DanhMucDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String masp = request.getParameter("id");
        SanPham sanPham = objectDAO.details(masp);
        request.setAttribute("item", sanPham);
        request.setAttribute("nhacungcap", sanPham.getNhacungcap().getMancc());
        request.setAttribute("danhmuc", sanPham.getDanhmuc().getMadm());
        List<NhaCungCap> listNCC = nccDAO.read();
        List<DanhMuc> listDM = dmDAO.read();
        request.setAttribute("listNCC", listNCC);
        request.setAttribute("listDM", listDM);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/sanpham/edit.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String masp = request.getParameter("txtMaSP");
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

        if (hinhAnh.isEmpty()) {
            SanPham obj = objectDAO.details(masp);
            hinhAnh = obj.getHinhanh();
        }
        NhaCungCap nhaCungCap = nccDAO.details(str_nhaCungCap);
        DanhMuc danhMuc = dmDAO.details(str_danhMuc);
        SanPham sanPham = new SanPham(masp, tensp, moTa, soLuong, donGia, hinhAnh, trangThai, nhaCungCap, danhMuc);
        objectDAO.update(sanPham);
        response.sendRedirect("/SE161557/admin/sanpham/IndexSP");

    }
}
