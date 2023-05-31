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
public class CartItem {
    private SanPham sanpham;
    private int amount;
    private String tensp;
    private String hinhanh;
    private float dongia;
    public CartItem() {
    }

    public CartItem(SanPham sanpham, int amount, String tensp, String hinhanh, float dongia) {
        this.sanpham = sanpham;
        this.amount = amount;
        this.tensp = tensp;
        this.hinhanh = hinhanh;
        this.dongia = dongia;
    }

    public SanPham getSanPham() {
        return sanpham;
    }

    public void setSanPham(SanPham sanpham) {
        this.sanpham = sanpham;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }
    
    
}
