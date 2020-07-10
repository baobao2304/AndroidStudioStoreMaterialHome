package com.example.appxaydungproject.Model;

public class TypeProductModel {
    private String typeNamePr;
    private int imgTypeNamePr,id;

    public TypeProductModel(String typeNamePr, int imgTypeNamePr) {
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

    public int getImgTypeNamePr() {
        return imgTypeNamePr;
    }

    public void setImgTypeNamePr(int imgTypeNamePr) {
        this.imgTypeNamePr = imgTypeNamePr;
    }
}
