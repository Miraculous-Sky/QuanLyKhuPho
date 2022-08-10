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

/**
 *
 * @author Darkmoon
 */
public class HoDan {

    public static ArrayList<HODAN> getByMaKhuPho(String maKhuPho) {
        ArrayList<HODAN> danhSach = new ArrayList<>();
        Connection connection = CONNECTION.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from hodan where makhupho = ?");
            preparedStatement.setString(1, maKhuPho);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maHoDan = resultSet.getNString(1);
                int soThanhVien = resultSet.getInt(2);
                String soNha = resultSet.getNString(3);
                danhSach.add(new HODAN(maHoDan, soNha, maKhuPho, soThanhVien));
            }
            return danhSach;
        } catch (SQLException ex) {
            return danhSach;
        }
    }
    public static int edit(String maHoDan, String soNha) {
        Connection connection = CONNECTION.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update hodan set sonha = ? where mahodan = ?");
            preparedStatement.setString(1, soNha);
            preparedStatement.setString(2, maHoDan);
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static int insert(String maHoDan, String soNha, int soThanhVien, String maKhuPho) {
        Connection connection = CONNECTION.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into hodan (mahodan, sothanhvien, sonha, makhupho) values (?, ?, ?, ?)");
            preparedStatement.setString(1, maHoDan);
            preparedStatement.setInt(2, soThanhVien);
            preparedStatement.setString(3, soNha);
            preparedStatement.setString(4, maKhuPho);
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }
}
