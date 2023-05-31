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
import model.NhomTaiKhoan;
import model.TaiKhoan;

/**
 *
 * @author Ho Trong Hieu
 */
public class TaiKhoanDAO implements ICrud<String, TaiKhoan> {

    List<TaiKhoan> listItems;
    private DBContext db;

    public TaiKhoanDAO() {
        db = new DBContext();
        listItems = new ArrayList<>();
    }

    public List<TaiKhoan> getListItems() {
        return listItems;
    }

    public void setListItems(List<TaiKhoan> listItems) {
        this.listItems = listItems;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }
    
    private final NhomTaiKhoanDAO objectDao = new NhomTaiKhoanDAO();

    @Override
    public List<TaiKhoan> read() {
        listItems.removeAll(listItems);
        try {
            String sql = "SELECT * FROM tblTaiKhoan";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String _tentk = rs.getString("tentk");
                String _matkhau = rs.getString("matkhau");
                boolean _trangthai = rs.getBoolean("trangthai");
                String _email = rs.getString("email");
                String _nhomtk = rs.getString("nhomtk");
                NhomTaiKhoan obj_nhomtk = objectDao.details(_nhomtk);      
                TaiKhoan item = new TaiKhoan(_tentk, _matkhau, _trangthai, _email, obj_nhomtk);
                listItems.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItems;
    }

    @Override
    public TaiKhoan details(String id) {
        try {
            String sql = "SELECT * FROM tblTaiKhoan WHERE tentk=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _tentk = rs.getString("tentk");
                String _matkhau = rs.getString("matkhau");
                boolean _trangthai = rs.getBoolean("trangthai");
                String _email = rs.getString("email");
                String _nhomtk = rs.getString("nhomtk");
                NhomTaiKhoan obj_nhomtk = objectDao.details(_nhomtk);      
                TaiKhoan item = new TaiKhoan(_tentk, _matkhau, _trangthai, _email, obj_nhomtk);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(TaiKhoan newItem) {
        try {
            String sql = "INSERT INTO tblTaiKhoan(tentk, matkhau, trangthai, email, nhomtk) VALUES(?, ?, ?, ?, ?)"; 
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newItem.getTenTK());
            stmt.setString(2, newItem.getMatKhau());
            stmt.setBoolean(3, newItem.isTrangThai());
            stmt.setString(4, newItem.getEmail());
            String nhomtk = newItem.getNhomTaiKhoan().getNhomTaiKhoan();
            stmt.setString(5, nhomtk);
            stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(TaiKhoan editedItem) {
        try {
            String sql = "UPDATE tblTaiKhoan SET matkhau=?, trangthai=?, email=?, nhomtk=? WHERE tentk=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, editedItem.getMatKhau());
            stmt.setBoolean(2, editedItem.isTrangThai());
            stmt.setString(3, editedItem.getEmail());
            
            String _nhomtk = editedItem.getNhomTaiKhoan().getNhomTaiKhoan();
            stmt.setString(4, _nhomtk);
            stmt.setString(5, editedItem.getTenTK());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql = "DELETE FROM tblTaiKhoan WHERE tentk=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate();  
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
