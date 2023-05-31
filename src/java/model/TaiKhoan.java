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
public class TaiKhoan {
    private String tenTK;
    private String matKhau;
    private boolean trangThai;
    private String email;

    private NhomTaiKhoan nhomTaiKhoan;
    
    public TaiKhoan() {
    }

    public TaiKhoan(String tenTK, String matKhau, boolean trangThai, String email, NhomTaiKhoan nhomTaiKhoan) {
        this.tenTK = tenTK;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
        this.email = email;
        this.nhomTaiKhoan = nhomTaiKhoan;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NhomTaiKhoan getNhomTaiKhoan() {
        return nhomTaiKhoan;
    }

    public void setNhomTaiKhoan(NhomTaiKhoan nhomTaiKhoan) {
        this.nhomTaiKhoan = nhomTaiKhoan;
    }

    
    
    
}
