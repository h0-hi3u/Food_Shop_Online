/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ChiTietHoaDon;
import model.HoaDon;
import model.SanPham;

/**
 *
 * @author Ho Trong Hieu
 */
public class ChiTietHoaDonDAO implements ICrud<String, ChiTietHoaDon> {

    List<ChiTietHoaDon> listItems;
    private DBContext db;

    public ChiTietHoaDonDAO() {
        db = new DBContext();
        listItems = new ArrayList<>();
    }

    public List<ChiTietHoaDon> getListItems() {
        return listItems;
    }

    public void setListItems(List<ChiTietHoaDon> listItems) {
        this.listItems = listItems;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    private final SanPhamDAO objectSanPhamDao = new SanPhamDAO();
    private final HoaDonDAO objectHoaDonDao = new HoaDonDAO();

    @Override
    public List<ChiTietHoaDon> read() {
        listItems.removeAll(listItems);
        try {
            String sql = "SELECT * FROM tblChiTietHoaDon";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String _mahd = rs.getString("mahd");
                String _masp = rs.getString("masp");
                HoaDon obj_hd = objectHoaDonDao.details(_mahd);
                SanPham obj_sp = objectSanPhamDao.details(_masp);

                int _soluong = rs.getInt("soluong");
                float _dongia = rs.getFloat("dongia");
                float _khuyenmai = rs.getFloat("khuyenmai");
                float _giatri = rs.getFloat("giatri");
                ChiTietHoaDon item = new ChiTietHoaDon(_soluong, _dongia, _khuyenmai, _giatri, obj_sp, obj_hd);
                listItems.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItems;
    }

    @Override
    public ChiTietHoaDon details(String id) {
        try {
            String sql = "SELECT * FROM tblChiTietHoaDon WHERE mahd=? AND masp=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _mahd = rs.getString("mahd");
                String _masp = rs.getString("masp");
                HoaDon obj_hd = objectHoaDonDao.details(_mahd);
                SanPham obj_sp = objectSanPhamDao.details(_masp);

                int _soluong = rs.getInt("soluong");
                float _dongia = rs.getFloat("dongia");
                float _khuyenmai = rs.getFloat("khuyenmai");
                float _giatri = rs.getFloat("giatri");
                ChiTietHoaDon item = new ChiTietHoaDon(_soluong, _dongia, _khuyenmai, _giatri, obj_sp, obj_hd);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(ChiTietHoaDon newItem) {
//        INSERT INTO tblChiTietHoaDon(mahd, masp, soluong, dongia, khuyenmai, giatri)
//VALUES ('HD1', 'SP001', 1, 3000, 0, 3000)
        try {
            String sql = "INSERT INTO tblChiTietHoaDon(mahd, masp, soluong, dongia, khuyenmai, giatri) VALUES ( ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            
            String _mahd = newItem.getHoaDon().getMaHD();
            stmt.setString(1, _mahd);
            String _masp = newItem.getSanPham().getMasp();
            stmt.setString(2, _masp);
            
            stmt.setInt(3, newItem.getSoLuong());
            stmt.setFloat(4, newItem.getDongGia());
            stmt.setFloat(5, newItem.getKhuyenMai());
            stmt.setFloat(6, newItem.getGiaTri());

            stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(ChiTietHoaDon editedItem) {
        try {
            String sql = "UPDATE tblChiTietHoaDon SET soluong=?, dongia=?, khuyenmai=?, giatri=? WHERE mahd=? AND masp=?'";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setInt(1, editedItem.getSoLuong());
            stmt.setFloat(2, editedItem.getDongGia());
            stmt.setFloat(3, editedItem.getKhuyenMai());
            stmt.setFloat(4, editedItem.getGiaTri());

            String _mahd = editedItem.getHoaDon().getMaHD();
            stmt.setString(5, _mahd);
            String _masp = editedItem.getSanPham().getMasp();
            stmt.setString(6, _masp);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
//       
    }

}
