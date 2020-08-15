package com.example.appxaydungproject.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginModel {


    @SerializedName("UserName")
    @Expose
    public String UserName;

    @SerializedName("Password")
    @Expose
    public String Password;

    @SerializedName("RememberMe")
    @Expose
    boolean RememberMe;


    public LoginModel() {
    }

    public LoginModel(String userName, String password, boolean rememberMe) {
        UserName = userName;
        Password = password;
        RememberMe = rememberMe;
    }


    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isRememberMe() {
        return RememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        RememberMe = rememberMe;
    }
}
