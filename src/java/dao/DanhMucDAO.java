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
import model.DanhMuc;

/**
 *
 * @author Admin
 */
public class DanhMucDAO implements ICrud<String, DanhMuc> {

    List<DanhMuc> listItems;
    private DBContext db;

    public DanhMucDAO() {
        db = new DBContext();
        listItems = new ArrayList<>();
    }

    public List<DanhMuc> getListItems() {
        return listItems;
    }

    public void setListItems(List<DanhMuc> listItems) {
        this.listItems = listItems;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    @Override
    public List<DanhMuc> read() {
        listItems.removeAll(listItems);
        try {
            String sql = "SELECT * FROM tblDanhMuc";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String _madm = rs.getString("madm");
                String _tendm = rs.getString("tendm");
                boolean _trangthai = rs.getBoolean("trangthai");
                DanhMuc item = new DanhMuc(_madm, _tendm, _trangthai);
                listItems.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItems;
    }

    @Override
    public DanhMuc details(String id) {
        try {
            String sql = "SELECT * FROM tblDanhMuc WHERE madm=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _madm = rs.getString("madm");
                String _tendm = rs.getString("tendm");
                boolean _trangthai = rs.getBoolean("trangthai");
                DanhMuc item = new DanhMuc(_madm, _tendm, _trangthai);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(DanhMuc newItem) {
        try {
            String sql = "INSERT INTO tblDanhMuc(madm, tendm, trangthai) VALUES(?, ?, ?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newItem.getMadm());
            stmt.setString(2, newItem.getTendm());
            stmt.setBoolean(3, newItem.isTrangthai());
            stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(DanhMuc editedItem) {
        try {
            String sql = "UPDATE tblDanhMuc SET tendm=? ,trangthai=? WHERE madm = ?";

            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            stmt.setString(1, editedItem.getTendm());
            stmt.setBoolean(2, editedItem.isTrangthai());
            stmt.setString(3, editedItem.getMadm());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql = "DELETE FROM tblDanhMuc WHERE madm=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
