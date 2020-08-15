package com.example.appxaydungproject.Model;

import com.google.gson.annotations.SerializedName;

public class ImageDetailProduct {
    @SerializedName("Id")
    int Id;
    @SerializedName("ProductId")
    int productID;
    @SerializedName("Path")
    String path;
    @SerializedName("Caption")
    String caption;

    public ImageDetailProduct(int id, int productID, String path, String caption) {
        Id = id;
        this.productID = productID;
        this.path = path;
        this.caption = caption;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
