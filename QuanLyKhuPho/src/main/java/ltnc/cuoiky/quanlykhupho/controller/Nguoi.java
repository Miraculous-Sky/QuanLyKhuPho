/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltnc.cuoiky.quanlykhupho.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ltnc.cuoiky.quanlykhupho.model.CONNECTION;
import ltnc.cuoiky.quanlykhupho.model.HODAN;
import ltnc.cuoiky.quanlykhupho.model.NGUOI;

/**
 *
 * @author Darkmoon
 */
public class Nguoi {

    public static ArrayList<NGUOI> getByMaHoDan(String maHoDan) {
        ArrayList<NGUOI> danhSach = new ArrayList<>();
        Connection connection = CONNECTION.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from nguoi where mahodan = ?");
            preparedStatement.setString(1, maHoDan);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maNguoi = resultSet.getNString(1);
                String hoTen = resultSet.getNString(2);
                int tuoi = resultSet.getInt(3);
                int namSinh = resultSet.getInt(4);
                String ngheNghiep = resultSet.getNString(5);
                danhSach.add(new NGUOI(maNguoi, hoTen, ngheNghiep, maHoDan, tuoi, namSinh));
            }
            return danhSach;
        } catch (SQLException ex) {
            return danhSach;
        }
    }
    
    public static ArrayList<NGUOI> getByMaKhuPho(String maKhuPho) {
        ArrayList<NGUOI> danhSach = new ArrayList<>();
        Connection connection = CONNECTION.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select n.* from hodan h join nguoi n on h.mahodan = n.mahodan where h.makhupho = ?");
            preparedStatement.setString(1, maKhuPho);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maNguoi = resultSet.getNString(1);
                String hoTen = resultSet.getNString(2);
                int tuoi = resultSet.getInt(3);
                int namSinh = resultSet.getInt(4);
                String ngheNghiep = resultSet.getNString(5);
                String maHoDan = resultSet.getNString(6);
                danhSach.add(new NGUOI(maNguoi, hoTen, ngheNghiep, maHoDan, tuoi, namSinh));
            }
            return danhSach;
        } catch (SQLException ex) {
            return danhSach;
        }
    }

    public static int edit(String maNguoi, String hoTen, int tuoi, int namSinh, String ngheNghiep) {
        Connection connection = CONNECTION.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update nguoi set hovaten = ?, tuoi = ?, namsinh = ?, nghenghiep = ? where manguoi = ?");
            preparedStatement.setNString(1, hoTen);
            preparedStatement.setInt(2, tuoi);
            preparedStatement.setInt(3, namSinh);
            preparedStatement.setNString(4, ngheNghiep);
            preparedStatement.setString(5, maNguoi);
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static int insert(String maNguoi, String hoTen, int tuoi, int namSinh, String ngheNghiep, String maHoDan) {
        Connection connection = CONNECTION.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into nguoi (manguoi, hovaten, tuoi, namsinh, nghenghiep, mahodan) values (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, maNguoi);
            preparedStatement.setNString(2, hoTen);
            preparedStatement.setInt(3, tuoi);
            preparedStatement.setInt(4, namSinh);
            preparedStatement.setNString(5, ngheNghiep);
            preparedStatement.setString(6, maHoDan);
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

}
