package com.example.appxaydungproject.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TypeProductModel {
    @SerializedName("Name")
    private String typeNamePr;
    @SerializedName("Image")
    private String imgTypeNamePr;
    @SerializedName("Id")
    private int id;

    public TypeProductModel(String typeNamePr, String imgTypeNamePr) {
        this.typeNamePr = typeNamePr;
        this.imgTypeNamePr = imgTypeNamePr;
    }

//    public TypeProductModel(String typeNamePr, int imgTypeNamePr, int id) {
//        this.typeNamePr = typeNamePr;
//        this.imgTypeNamePr = imgTypeNamePr;
//        this.id = id;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeNamePr() {
        return typeNamePr;
    }

    public void setTypeNamePr(String typeNamePr) {
        this.typeNamePr = typeNamePr;
    }

    public String getImgTypeNamePr() {
        return imgTypeNamePr;
    }

    public void setImgTypeNamePr(String imgTypeNamePr) {
        this.imgTypeNamePr = imgTypeNamePr;
    }
}
