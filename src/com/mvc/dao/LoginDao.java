package com.mvc.dao;

import com.mvc.bean.LoginBean;
import com.mvc.util.DBConnection;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.HashMap;

public class LoginDao {
    public String addUser(LoginBean loginBean) {

        String userName = loginBean.getUserName();
        String email = loginBean.getEmail();
        String phoneNumber = loginBean.getPhoneNumber();

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;


        String sql = "INSERT INTO `test`.`users` (`userName`, `email`, `phone`) VALUES ('" +
                userName + "', '" +
                email + "', '" +
                phoneNumber + "');";

        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            statement.execute(sql);
            System.out.println("User Added to Database");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return "User Created";
    }
    public HashMap<String, String> getUser(String smth) throws IOException {
        HashMap<String, String > usersByName = new HashMap<>();
        String userName = smth;
        ResultSet rs = null;
        String resultUser = "";
        Connection conn;
        CallableStatement cs;
        Statement state;
        String filename = "D:\\AndersenProjects2\\SimpleWebApp\\web\\WEB-INF\\lib\\MyQueryUser.sql";
        String content = new String(Files.readAllBytes(Paths.get(filename)), "UTF-8");
        int delimiter = content.indexOf('$');
        String leftStatement = content.substring(0,delimiter);
        String rightStatement = content.substring(delimiter+1);
        System.out.println(content);

        try {
            conn = DBConnection.createConnection();
            state = conn.createStatement();
            state.execute(leftStatement);
            state.execute(rightStatement);
            cs = conn.prepareCall("{call getUserByNames(?)}");
            cs.setString(1, userName);
            cs.execute();
            rs = cs.getResultSet();
            while (rs.next()) {
                usersByName.put(rs.getString("email"), rs.getString("phone"));
//                System.out.println("Email: " + rs.getString("email") + "  Phone Number"
//                        + rs.getString("phone"));
            }
            resultUser = String.valueOf(rs);
            rs.close();

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        System.out.println(resultUser);

        return usersByName;
    }
}
