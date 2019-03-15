package com.mvc.controller;

import com.mvc.bean.UserBean;
import com.mvc.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class UserServlet extends HttpServlet {

    public UserServlet() {
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");

        UserService userService = new UserService();
        // создать сервис для работы с DAO не напрямую -> DONE
        HashMap<String,String> resultView = null;
        try {
            resultView = userService.getUsersByName(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // перенести на фронт -> DONE
        req.setAttribute("resultView" , resultView);
        req.getRequestDispatcher("/UserMap.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phone_number");

        UserBean userBean = new UserBean(userName, email, phoneNumber);
        // заменить на конструктор -> DONE
//        loginBean.setUserName(userName);
//        loginBean.setEmail(email);
//        loginBean.setPhoneNumber(phoneNumber);
        UserService userService = new UserService();
        userService.addUserToDB(userBean);
        request.setAttribute("username", userName);
        request.getRequestDispatcher("/Home.jsp").forward(request, response);
    }
}