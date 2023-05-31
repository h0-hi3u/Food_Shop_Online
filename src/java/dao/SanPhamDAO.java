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
import model.NhaCungCap;
import model.SanPham;

/**
 *
 * @author Ho Trong Hieu
 */
public class SanPhamDAO implements ICrud<String, SanPham> {

    List<SanPham> listItems;
    private DBContext db;

    public SanPhamDAO() {
        db = new DBContext();
        listItems = new ArrayList<>();
    }

    public List<SanPham> getListItems() {
        return listItems;
    }

    public void setListItems(List<SanPham> listItems) {
        this.listItems = listItems;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    private final DanhMucDAO objectDanhMucDao = new DanhMucDAO();
    private final NhaCungCapDAO objectNhaCungCapDao = new NhaCungCapDAO();

    @Override
    public List<SanPham> read() {
        listItems.removeAll(listItems);
        try {
            String sql = "SELECT * FROM tblSanPham";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String _masp = rs.getString("masp");
                String _tensp = rs.getString("tensp");
                String _mota = rs.getString("mota");
                int _soluong = rs.getInt("soluong");
                float _dongia = rs.getFloat("dongia");
                String _hinhanh = rs.getString("hinhanh");
                boolean _trangthai = rs.getBoolean("trangthai");

                String _madm = rs.getString("madm");
                DanhMuc obj_dm = objectDanhMucDao.details(_madm);
                String _mancc = rs.getString("mancc");
                NhaCungCap obj_ncc = objectNhaCungCapDao.details(_mancc);

                SanPham item = new SanPham(_masp, _tensp, _mota, _soluong, _dongia, _hinhanh, _trangthai, obj_ncc, obj_dm);
                listItems.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItems;
    }

    public List<SanPham> searchByName(String id) {
        listItems.removeAll(listItems);
        try {
            String sql = "SELECT * FROM tblSanPham WHERE tensp LIKE ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            String a = "%";
            a = a.concat(id).concat(a);
            stmt.setString(1, a);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String _masp = rs.getString("masp");
                String _tensp = rs.getString("tensp");
                String _mota = rs.getString("mota");
                int _soluong = rs.getInt("soluong");
                float _dongia = rs.getFloat("dongia");
                String _hinhanh = rs.getString("hinhanh");
                boolean _trangthai = rs.getBoolean("trangthai");

                String _madm = rs.getString("madm");
                DanhMuc obj_dm = objectDanhMucDao.details(_madm);
                String _mancc = rs.getString("mancc");
                NhaCungCap obj_ncc = objectNhaCungCapDao.details(_mancc);

                SanPham item = new SanPham(_masp, _tensp, _mota, _soluong, _dongia, _hinhanh, _trangthai, obj_ncc, obj_dm);
                listItems.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listItems;
    }

    @Override
    public SanPham details(String id) {
        try {
            String sql = "SELECT * FROM tblSanPham WHERE masp=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String _masp = rs.getString("masp");
                String _tensp = rs.getString("tensp");
                String _mota = rs.getString("mota");
                int _soluong = rs.getInt("soluong");
                float _dongia = rs.getFloat("dongia");
                String _hinhanh = rs.getString("hinhanh");
                boolean _trangthai = rs.getBoolean("trangthai");

                String _madm = rs.getString("madm");
                DanhMuc obj_dm = objectDanhMucDao.details(_madm);
                String _mancc = rs.getString("mancc");
                NhaCungCap obj_ncc = objectNhaCungCapDao.details(_mancc);

                SanPham item = new SanPham(_masp, _tensp, _mota, _soluong, _dongia, _hinhanh, _trangthai, obj_ncc, obj_dm);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(SanPham newItem) {
        try {
            String sql = "INSERT INTO tblSanPham( masp, tensp, mota, soluong, dongia, hinhanh, trangthai, madm, mancc) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newItem.getMasp());
            stmt.setString(2, newItem.getTensp());
            stmt.setString(3, newItem.getMota());
            stmt.setInt(4, newItem.getSoluong());
            stmt.setFloat(5, newItem.getDongia());
            stmt.setString(6, newItem.getHinhanh());
            stmt.setBoolean(7, newItem.isTrangthai());

            String _madm = newItem.getDanhmuc().getMadm();
            String _mancc = newItem.getNhacungcap().getMancc();
            stmt.setString(8, _madm);
            stmt.setString(9, _mancc);

            stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(SanPham editedItem) {
        try {
            String sql = "UPDATE tblSanPham SET tensp=?, mota=?, soluong=?, dongia=?, hinhanh=?, trangthai=?, madm=?, mancc=? WHERE masp = ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, editedItem.getTensp());
            stmt.setString(2, editedItem.getMota());
            stmt.setInt(3, editedItem.getSoluong());
            stmt.setFloat(4, editedItem.getDongia());
            stmt.setString(5, editedItem.getHinhanh());
            stmt.setBoolean(6, editedItem.isTrangthai());

            String _madm = editedItem.getDanhmuc().getMadm();
            stmt.setString(7, _madm);
            String _mancc = editedItem.getNhacungcap().getMancc();
            stmt.setString(8, _mancc);
            stmt.setString(9, editedItem.getMasp());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql = "DELETE FROM tblSanPham WHERE masp=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
