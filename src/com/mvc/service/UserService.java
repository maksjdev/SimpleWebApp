package com.mvc.service;

import com.mvc.bean.UserBean;
import com.mvc.dao.UserDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class UserService {

    UserDao uDao = new UserDao();

    public void addUserToDB(UserBean userBean){
           uDao.addUser(userBean);
    }
    public HashMap<String, String> getUsersByName(String enteredUser) throws IOException, SQLException {
       HashMap<String, String> resultUserMap =  uDao.getUser(enteredUser);

        return resultUserMap;
    }
}
