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
public class NhaCungCap {
    private String mancc;
    private String tenncc;
    private String diachi;
    private boolean trangthai;

    public NhaCungCap() {
    }

    public NhaCungCap(String mancc, String tenncc, String diachi, boolean trangthai) {
        this.mancc = mancc;
        this.tenncc = tenncc;
        this.diachi = diachi;
        this.trangthai = trangthai;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public String getTenncc() {
        return tenncc;
    }

    public void setTenncc(String tenncc) {
        this.tenncc = tenncc;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }
    
}
