package com.mvc.dao;

import com.mvc.bean.UserBean;
import com.mvc.util.DBConnection;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.HashMap;


public class UserDao {

    private static StringBuilder InsertUserQuery = new StringBuilder("INSERT INTO `test`.`users` (`userName`, `email`, `phone`) VALUES ('");
    private static String filename = "D:\\AndersenProjects2\\SimpleWebApp\\web\\WEB-INF\\lib\\MyQueryUser.sql";
    private static StringBuilder thisIsFeature = new StringBuilder("')");

    // сделать Void -> DONE
    public void addUser(UserBean userBean) {

        String userName = userBean.getUserName();
        String email = userBean.getEmail();
        String phoneNumber = userBean.getPhoneNumber();

        Connection con = null;
        Statement statement = null;

        // вынести в статик константу класса -> DONE
        String sql = InsertUserQuery +
                userName + "', '" +
                email + "', '" +
                phoneNumber + thisIsFeature;

        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            statement.execute(sql);
            System.out.println("User Added to Database");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void initProcedure(){
        String textFromFile = "";
        Connection conn;
        Statement state;
        try
        {
            textFromFile = new String(Files.readAllBytes(Paths.get(filename)));
        }
        catch (IOException e)
        {
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
        String userName = enteredUser;
        initProcedure();
        //  в статик переменную -> DONE
        try {
            conn = DBConnection.createConnection();
            cs = conn.prepareCall("{call getUserByNames(?)}");
            cs.setString(1, userName);
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
