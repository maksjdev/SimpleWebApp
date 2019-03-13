//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public DBConnection() {
    }

    public static Connection createConnection() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "0959";

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException var5) {
                var5.printStackTrace();
            }

            con = DriverManager.getConnection(url, username, password);
            System.out.println(con);
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return con;
    }
}
