//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static String url = "jdbc:mysql://localhost:3306/test";
    private static String username = "root";
    private static String password = "0959";
    private static String driver = "com.mysql.jdbc.Driver";

    private DBConnection() {
    }

    public static Connection createConnection() {
        Connection con = null;
         // вынести в статические переменные -> DONE
        try {
            try {
                Class.forName(driver);
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
