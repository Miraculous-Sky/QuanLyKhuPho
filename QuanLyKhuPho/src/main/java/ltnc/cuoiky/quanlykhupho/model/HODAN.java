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
public class HODAN {
    private  String maHoDan, soNha, maKhuPho;
    private int soThanhVien;

    public HODAN() {
    }

    public HODAN(String maHoDan, String soNha, String maKhuPho, int soThanhVien) {
        this.maHoDan = maHoDan;
        this.soNha = soNha;
        this.maKhuPho = maKhuPho;
        this.soThanhVien = soThanhVien;
    }

    public String getMaHoDan() {
        return maHoDan;
    }

    public void setMaHoDan(String maHoDan) {
        this.maHoDan = maHoDan;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public String getMaKhuPho() {
        return maKhuPho;
    }

    public void setMaKhuPho(String maKhuPho) {
        this.maKhuPho = maKhuPho;
    }

    public int getSoThanhVien() {
        return soThanhVien;
    }

    public void setSoThanhVien(int soThanhVien) {
        this.soThanhVien = soThanhVien;
    }

    @Override
    public String toString() {
        return "HODAN{" + "maHoDan=" + maHoDan + ", soNha=" + soNha + ", maKhuPho=" + maKhuPho + ", soThanhVien=" + soThanhVien + '}';
    }
    
}
