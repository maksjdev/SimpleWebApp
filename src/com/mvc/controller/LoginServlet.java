package com.mvc.controller;

import com.mvc.bean.LoginBean;
import com.mvc.dao.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {

    public LoginServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        LoginDao loginDao = new LoginDao();
        HashMap<String,String> resultView = loginDao.getUser(userName);
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + "User Name: "+ req.getParameter("username") + "</h1>");
        for (Map.Entry entry : resultView.entrySet()){
            out.println("<h2>" + "User Email: " + entry.getKey() + "  |  " + "User Phone: " + entry.getValue() + "</h2>" + "<br>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phone_number");

        LoginBean loginBean = new LoginBean();

        loginBean.setUserName(userName);
        loginBean.setEmail(email);
        loginBean.setPhoneNumber(phoneNumber);

        LoginDao loginDao = new LoginDao();

        String insertUser = loginDao.addUser(loginBean);

        request.setAttribute("username", userName); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
        request.getRequestDispatcher("/Home.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.

    }

}