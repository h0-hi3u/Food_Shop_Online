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
public class HoaDon {
    private String maHD;
    private String ngayHD;
    private int trangThaiXuLy;

    
    private TaiKhoan taiKhoan;

    public HoaDon() {
    }
  
    public HoaDon(String maHD, String ngayHD, int trangThaiXuLy, TaiKhoan taiKhoan) {
        this.maHD = maHD;
        this.ngayHD = ngayHD;
        this.trangThaiXuLy = trangThaiXuLy;
        this.taiKhoan = taiKhoan;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayHD() {
        return ngayHD;
    }

    public void setNgayHD(String ngayHD) {
        this.ngayHD = ngayHD;
    }

    public int getTrangThaiXuLy() {
        return trangThaiXuLy;
    }

    public void setTrangThaiXuLy(int trangThaiXuLy) {
        this.trangThaiXuLy = trangThaiXuLy;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

}
