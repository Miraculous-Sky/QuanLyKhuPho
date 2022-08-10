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
import java.sql.Statement;
import java.util.ArrayList;
import ltnc.cuoiky.quanlykhupho.model.CONNECTION;
import ltnc.cuoiky.quanlykhupho.model.KHUPHO;

/**
 *
 * @author Darkmoon
 */
public class KhuPho {

    public static ArrayList<KHUPHO> getAll() {
        ArrayList<KHUPHO> danhSach = new ArrayList<>();
        Connection connection = CONNECTION.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from khupho");
            String maKhuPho, tenKhuPho;
            while (resultSet.next()) {
                maKhuPho = resultSet.getNString(1);
                tenKhuPho = resultSet.getNString(2);
                danhSach.add(new KHUPHO(maKhuPho, tenKhuPho));
            }
            return danhSach;
        } catch (SQLException ex) {
            return danhSach;
        }
    }

    public static int deleteKhuPho(String maKhuPho) {
        Connection connection = CONNECTION.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from khupho where makhupho = ?");
            preparedStatement.setString(1, maKhuPho);
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static KHUPHO getByMaKhuPho(String maKhuPho) {
        KHUPHO khuPho = new KHUPHO();
        Connection connection = CONNECTION.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from khupho where makhupho = ?");
            preparedStatement.setString(1, maKhuPho);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                khuPho.setMaKhuPho(resultSet.getNString(1));
                khuPho.setTenKhuPho(resultSet.getNString(2));
                return khuPho;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }

    public static int edit(String maKhuPho, String tenKhuPho) {
        Connection connection = CONNECTION.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update khupho set tenkhupho = ? where makhupho = ?");
            preparedStatement.setString(1, tenKhuPho);
            preparedStatement.setString(2, maKhuPho);
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }

    public static int insert(String maKhuPho, String tenKhuPho) {
        Connection connection = CONNECTION.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into khupho (makhupho, tenkhupho) values (?, ?)");
            preparedStatement.setString(1, maKhuPho);
            preparedStatement.setString(2, tenKhuPho);
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            return -1;
        }
    }
}
