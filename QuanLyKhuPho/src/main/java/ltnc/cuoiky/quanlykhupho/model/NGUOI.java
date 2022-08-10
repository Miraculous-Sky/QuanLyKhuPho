/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltnc.cuoiky.quanlykhupho.model;

/**
 *
 * @author Darkmoon
 */
public class NGUOI {
    private String maNguoi, hoTen, ngheNghiep, maHoDan;
    private int tuoi, namSinh;

    public NGUOI() {
    }

    public NGUOI(String maNguoi, String hoTen, String ngheNghiep, String maHoDan, int tuoi, int namSinh) {
        this.maNguoi = maNguoi;
        this.hoTen = hoTen;
        this.ngheNghiep = ngheNghiep;
        this.maHoDan = maHoDan;
        this.tuoi = tuoi;
        this.namSinh = namSinh;
    }

    public String getMaNguoi() {
        return maNguoi;
    }

    public void setMaNguoi(String maNguoi) {
        this.maNguoi = maNguoi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getMaHoDan() {
        return maHoDan;
    }

    public void setMaHoDan(String maHoDan) {
        this.maHoDan = maHoDan;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    @Override
    public String toString() {
        return "NGUOI{" + "maNguoi=" + maNguoi + ", hoTen=" + hoTen + ", ngheNghiep=" + ngheNghiep + ", maHoDan=" + maHoDan + ", tuoi=" + tuoi + ", namSinh=" + namSinh + '}';
    }
    
}
