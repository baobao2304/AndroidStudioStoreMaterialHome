package com.example.appxaydungproject.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

public class UserModel {
    @SerializedName("title")
    @Expose
    String ID;
    @SerializedName("title")
    @Expose
    String Name;
    @SerializedName("title")
    @Expose
    String Pass;
    @SerializedName("title")
    @Expose
    String Email;
    @SerializedName("title")
    @Expose
    String NumberPhone;
    @SerializedName("title")
    @Expose
    String Address;
    @SerializedName("title")
    @Expose
    LocalDate BirthDay;
    public UserModel(String ID, String pass, String email, String numberPhone,String address, String name) {
        this.ID = ID;
        this.Pass = pass;
        this.Email = email;
        this.NumberPhone = numberPhone;
        this.Address = address;
        this.Name = name;
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNumberPhone() {
        return NumberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        NumberPhone = numberPhone;
    }
}
