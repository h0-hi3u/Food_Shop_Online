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
public class NhomTaiKhoan {
    private String nhomTK;
    private String moTa;
    private boolean trangThai;

    public NhomTaiKhoan() {
    }

    public NhomTaiKhoan(String nhomTaiKhoan, String moTa, boolean trangThai) {
        this.nhomTK = nhomTaiKhoan;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public String getNhomTaiKhoan() {
        return nhomTK;
    }

    public void setNhomTaiKhoan(String nhomTaiKhoan) {
        this.nhomTK = nhomTaiKhoan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
