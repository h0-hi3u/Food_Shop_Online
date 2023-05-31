/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class SanPham {
    private String masp;
    private String tensp;
    private String mota;
    private int soluong;
    private float dongia;
    private String hinhanh;
    private boolean trangthai;
    
    private NhaCungCap nhacungcap;
    private DanhMuc danhmuc;

    public SanPham() {
    }

    public SanPham(String masp, String tensp, String mota, int soluong, float dongia, String hinhanh, boolean trangthai, NhaCungCap nhacungcap, DanhMuc danhmuc) {
        this.masp = masp;
        this.tensp = tensp;
        this.mota = mota;
        this.soluong = soluong;
        this.dongia = dongia;
        this.hinhanh = hinhanh;
        this.trangthai = trangthai;
        this.nhacungcap = nhacungcap;
        this.danhmuc = danhmuc;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public NhaCungCap getNhacungcap() {
        return nhacungcap;
    }

    public void setNhacungcap(NhaCungCap nhacungcap) {
        this.nhacungcap = nhacungcap;
    }

    public DanhMuc getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(DanhMuc danhmuc) {
        this.danhmuc = danhmuc;
    }

    @Override
    public String toString() {
        return "SanPham: " + "masp=" + masp + ", tensp=" + tensp + ", mota=" + mota + ", soluong=" + soluong + ", dongia=" + dongia + ", hinhanh=" + hinhanh + ", trangthai=" + trangthai + ", nhacungcap=" + nhacungcap.getTenncc() + ", danhmuc=" + danhmuc.getTendm() + '}';
    }

    
    
}
