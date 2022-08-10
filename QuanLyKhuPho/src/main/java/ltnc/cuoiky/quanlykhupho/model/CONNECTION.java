/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltnc.cuoiky.quanlykhupho.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Darkmoon
 */
public class CONNECTION {
    public static Connection con = null;
    private static final CONNECTION instance = new CONNECTION();

    public static CONNECTION getInstance() {
        return instance;
    }

    public void connect() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CONNECTION.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = "jdbc:sqlserver://localhost:1433;databasename=QUANLYKHUPHO";
        String user = "sa";
        String password = "123456";
        con = DriverManager.getConnection(url, user, password);
    }

    public void disconnect() {
        if (con != null)
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static Connection getConnection() {
        if (con == null)
            try {
                instance.connect();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return con;
    }
}
