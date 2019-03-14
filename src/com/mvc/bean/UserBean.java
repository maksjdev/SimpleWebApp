package com.mvc.bean;

public class UserBean {

// переименовать в UserBEan
    private String userName;
    private String email;
    private String phoneNumber;

    public UserBean() {
    }

    public UserBean(String userName, String email, String phoneNumber) {
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return " User Information: "  +
                "  User Name : " + userName +
                ", User Email : '" + email + '\'' +
                ", User Phone Number : '" + phoneNumber + '\'' + ";";
    }
}
