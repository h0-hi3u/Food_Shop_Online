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

/**
 *
 * @author Ho Trong Hieu
 */
public class NhomTaiKhoanDAO implements ICrud<String, NhomTaiKhoan> {

    List<NhomTaiKhoan> listItems;
    private DBContext db;

    public NhomTaiKhoanDAO() {
        db = new DBContext();
        listItems = new ArrayList<>();
    }

    public List<NhomTaiKhoan> getListItems() {
        return listItems;
    }

    public void setListItems(List<NhomTaiKhoan> listItems) {
        this.listItems = listItems;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    @Override
    public List<NhomTaiKhoan> read() {
        listItems.removeAll(listItems);
        try {

            String sql = "SELECT * FROM tblNhomTaiKhoan";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String _nhomtk = rs.getString("nhomtk");
                String _mota = rs.getString("mota");
                boolean _trangthai = rs.getBoolean("trangthai");
                NhomTaiKhoan item = new NhomTaiKhoan(_nhomtk, _mota, _trangthai);
                listItems.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhomTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItems;
    }

    @Override
    public NhomTaiKhoan details(String id) {
        try {
            String sql = "SELECT * FROM tblNhomTaiKhoan WHERE nhomtk=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _nhomtk = rs.getString("nhomtk");
                String _mota = rs.getString("mota");
                boolean _trangthai = rs.getBoolean("trangthai");
                NhomTaiKhoan item = new NhomTaiKhoan(_nhomtk, _mota, _trangthai);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhomTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(NhomTaiKhoan newItem) {
        try {
            String sql = "INSERT INTO tblNhomTaiKhoan(nhomtk, mota, trangthai) VALUES(?, ?, ?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newItem.getNhomTaiKhoan());
            stmt.setString(2, newItem.getMoTa());
            stmt.setBoolean(3, newItem.isTrangThai());
            stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(NhomTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(NhomTaiKhoan editedItem) {
        try {
            String sql = "UPDATE tblNhomTaiKhoan SET mota=? ,trangthai=? WHERE nhomtk=?";

            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setString(1, editedItem.getMoTa());
            stmt.setBoolean(2, editedItem.isTrangThai());
            stmt.setString(3, editedItem.getNhomTaiKhoan());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NhomTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql = "DELETE FROM tblNhomTaiKhoan WHERE nhomtk=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhomTaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
