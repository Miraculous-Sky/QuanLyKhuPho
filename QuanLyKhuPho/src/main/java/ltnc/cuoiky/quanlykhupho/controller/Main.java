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
import javax.swing.UIManager;
import ltnc.cuoiky.quanlykhupho.model.CONNECTION;
import ltnc.cuoiky.quanlykhupho.view.LoginJFrame;

/**
 *
 * @author Darkmoon
 */
public class Main {

    public static boolean login(String taiKhoan, String matKhau, boolean vaiTro) {
        Connection connection = CONNECTION.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select count(*) from useritem where tentaikhoan = ? and matkhau = ? and vaitro = ?");
            preparedStatement.setString(1, taiKhoan);
            preparedStatement.setString(2, matKhau);
            preparedStatement.setBoolean(3, vaiTro);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) == 1;
        } catch (SQLException ex) {
            return false;
        }
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginJFrame().setVisible(true);
            }
        });
    }
}
