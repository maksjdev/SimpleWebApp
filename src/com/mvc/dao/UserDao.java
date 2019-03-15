package com.mvc.dao;

import com.mvc.bean.UserBean;
import com.mvc.util.DBConnection;
import com.sun.jdi.Value;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.HashMap;


public class UserDao {

    private static String sql = "INSERT INTO users (userName, email, phone) VALUES (?, ?, ?)";
    private static String filename = "D:\\AndersenProjects2\\SimpleWebApp\\web\\WEB-INF\\lib\\MyQueryUser.sql";

    // сделать Void -> DONE
    public void addUser(UserBean userBean) {

        String userName = userBean.getUserName();
        String email = userBean.getEmail();
        String phoneNumber = userBean.getPhoneNumber();
        Connection con = null;
        PreparedStatement preparedStatement = null;
        // вынести в статик константу класса -> DONE

        try {
            con = DBConnection.createConnection();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,phoneNumber);
            preparedStatement.execute();
            System.out.println("User Added to Database");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void initProcedure(){
        String textFromFile = "";
        Connection conn;
        Statement state;
        try {
            textFromFile = new String(Files.readAllBytes(Paths.get(filename)));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String sqlQuery = textFromFile;
        String[] sqlQueryParts = sqlQuery.split("-");

        for (int i = 0; i < sqlQueryParts.length; i++) {
            try {
                conn = DBConnection.createConnection();
                state = conn.createStatement();
                state.execute(sqlQueryParts[i]);
                state.execute(sqlQueryParts[i+1]);
                i++;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // переименовать smth -> DONE
    public HashMap<String, String> getUser(String enteredUser) throws IOException, SQLException {
        ResultSet rs = null;
        Connection conn;
        CallableStatement cs;
        HashMap<String, String > usersByName = new HashMap<>();
        initProcedure();
        //  в статик переменную -> DONE
        try {
            conn = DBConnection.createConnection();
            cs = conn.prepareCall("{call getUserByNames(?)}");
            cs.setString(1, enteredUser);
            cs.execute();
            rs = cs.getResultSet();
            while (rs.next()) {
                UserBean userData = new UserBean(rs.getString("userName"), rs.getString("email"),
                        rs.getString("phone"));
                usersByName.put(rs.getString("id"), userData.toString());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return usersByName;
    }
}
