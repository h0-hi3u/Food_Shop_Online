/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ho Trong Hieu
 */
public class ChiTietHoaDon {
    
    private int soLuong;
    private float dongGia;
    private float khuyenMai;
    private float giaTri;
    
    private SanPham sanPham;
    private HoaDon hoaDon;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int soLuong, float dongGia, float khuyenMai, float giaTri, SanPham sanPham, HoaDon hoaDon) {
        this.soLuong = soLuong;
        this.dongGia = dongGia;
        this.khuyenMai = khuyenMai;
        this.giaTri = giaTri; 
        this.sanPham = sanPham;
        this.hoaDon = hoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDongGia() {
        return dongGia;
    }

    public void setDongGia(float dongGia) {
        this.dongGia = dongGia;
    }

    public float getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(float khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public float getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(float giaTri) {
        this.giaTri = giaTri;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    
    
}
