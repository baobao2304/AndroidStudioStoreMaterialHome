package com.example.appxaydungproject.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenModel {

    @SerializedName("token")
    @Expose
    String Tokent;

    public String getTokent() {
        return Tokent;
    }

    public void setTokent(String tokent) {
        Tokent = tokent;
    }
}
