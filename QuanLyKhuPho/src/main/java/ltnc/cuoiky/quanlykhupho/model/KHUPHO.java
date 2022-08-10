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
public class KHUPHO {
    private String maKhuPho, tenKhuPho;

    public KHUPHO() {
    }

    public KHUPHO(String maKhuPho, String tenKhuPho) {
        this.maKhuPho = maKhuPho;
        this.tenKhuPho = tenKhuPho;
    }

    public String getMaKhuPho() {
        return maKhuPho;
    }

    public void setMaKhuPho(String maKhuPho) {
        this.maKhuPho = maKhuPho;
    }

    public String getTenKhuPho() {
        return tenKhuPho;
    }

    public void setTenKhuPho(String tenKhuPho) {
        this.tenKhuPho = tenKhuPho;
    }

    @Override
    public String toString() {
        return "KHUPHO{" + "maKhuPho=" + maKhuPho + ", tenKhuPho=" + tenKhuPho + '}';
    }
    
    
}
