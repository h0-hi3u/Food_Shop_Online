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
import model.NhaCungCap;

/**
 *
 * @author Ho Trong Hieu
 */
public class NhaCungCapDAO implements ICrud<String, NhaCungCap> {

    List<NhaCungCap> listItems;
    private DBContext db;

    public NhaCungCapDAO() {
        db = new DBContext();
        listItems = new ArrayList<>();
    }

    public List<NhaCungCap> getListItems() {
        return listItems;
    }

    public void setListItems(List<NhaCungCap> listItems) {
        this.listItems = listItems;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    @Override
    public List<NhaCungCap> read() {
        listItems.removeAll(listItems);
        try {
            String sql = "SELECT * FROM tblNhaCungCap";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String _madm = rs.getString("mancc");
                String _tendm = rs.getString("tenncc");
                String _diachi = rs.getString("diachi");
                boolean _trangthai = rs.getBoolean("trangthai");
                NhaCungCap item = new NhaCungCap(_madm, _tendm, _diachi, _trangthai);
                listItems.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItems;
    }

    @Override
    public NhaCungCap details(String id) {
        try {
            String sql = "SELECT * FROM tblNhaCungCap WHERE mancc=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _madm = rs.getString("mancc");
                String _tendm = rs.getString("tenncc");
                String _diachi = rs.getString("diachi");
                boolean _trangthai = rs.getBoolean("trangthai");
                NhaCungCap item = new NhaCungCap(_madm, _tendm, _diachi, _trangthai);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(NhaCungCap newItem) {
       try {
            String sql = "INSERT INTO tblNhaCungCap(mancc, tenncc, diachi, trangthai) VALUES(?, ?, ?, ?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newItem.getMancc());
            stmt.setString(2, newItem.getTenncc());
            stmt.setString(3, newItem.getDiachi());
            stmt.setBoolean(4, newItem.isTrangthai());
            stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(NhaCungCap editedItem) {
        try {
            String sql = "UPDATE tblNhaCungCap SET tenncc=? ,diachi=? , trangthai=? WHERE mancc = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, editedItem.getTenncc());  
            stmt.setString(2, editedItem.getDiachi());
            stmt.setBoolean(3, editedItem.isTrangthai());
            stmt.setString(4, editedItem.getMancc());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql = "DELETE FROM tblNhaCungCap WHERE mancc=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
