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
import model.HoaDon;
import model.TaiKhoan;

/**
 *
 * @author Ho Trong Hieu
 */
public class HoaDonDAO implements ICrud<String, HoaDon> {

    List<HoaDon> listItems;
    private DBContext db;

    public HoaDonDAO() {
        db = new DBContext();
        listItems = new ArrayList<>();
    }

    public List<HoaDon> getListItems() {
        return listItems;
    }

    public void setListItems(List<HoaDon> listItems) {
        this.listItems = listItems;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    private final TaiKhoanDAO objectDao = new TaiKhoanDAO();

    @Override
    public List<HoaDon> read() {
        listItems.removeAll(listItems);
        try {
            String sql = "SELECT * FROM tblHoaDon";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String _mahd = rs.getString("mahd");
                String _ngayhd = rs.getString("ngayhd");
                int _trangthaixuly = rs.getInt("trangthaixuly");
                String _makh = rs.getString("makh");
                TaiKhoan obj_makh = objectDao.details(_makh);
                HoaDon item = new HoaDon(_mahd, _ngayhd, _trangthaixuly, obj_makh);
                listItems.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItems;
    }

    @Override
    public HoaDon details(String id) {
        try {
            String sql = "SELECT * FROM tblHoaDon WHERE mahd=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _mahd = rs.getString("mahd");
                String _ngayhd = rs.getString("ngayhd");
                int _trangthaixuly = rs.getInt("trangthaixuly");
                String _makh = rs.getString("makh");
                TaiKhoan obj_makh = objectDao.details(_makh);
                HoaDon item = new HoaDon(_mahd, _ngayhd, _trangthaixuly, obj_makh);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public java.sql.Date getCurrentDatetime() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    @Override
    public void create(HoaDon newItem) {
        try {
            String sql = "INSERT INTO tblHoaDon(mahd, ngayhd, trangthaixuly, makh) VALUES(?, ?, ?, ?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newItem.getMaHD());
            
//            java.sql.Date date = getCurrentDatetime();
//            stmt.setDate(2, date);
            stmt.setString(2, newItem.getNgayHD());
            
            stmt.setInt(3, newItem.getTrangThaiXuLy());

            String _makh = newItem.getTaiKhoan().getTenTK();
            stmt.setString(4, _makh);
            stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(HoaDon editedItem) {
        try {
            String sql = "UPDATE tblDanhMuc SET ngayhd=?, trangthaixuly=?, makh=? WHERE mahd = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, editedItem.getNgayHD());
            stmt.setInt(2, editedItem.getTrangThaiXuLy());

            String _makh = editedItem.getTaiKhoan().getTenTK();
            stmt.setString(3, _makh);
            stmt.setString(4, editedItem.getMaHD());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql = "DELETE FROM tblHoaDon WHERE mahd=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
