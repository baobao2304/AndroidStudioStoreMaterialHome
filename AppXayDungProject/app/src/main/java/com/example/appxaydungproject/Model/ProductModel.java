package com.example.appxaydungproject.Model;

import com.google.gson.annotations.SerializedName;

public class ProductModel {
    @SerializedName("Id")
    private int productID;
    @SerializedName("CategoryId")
    private int categoryID;
    @SerializedName("Image")
    private String imgPR;
    @SerializedName("Price")
    private float pricePR;
    @SerializedName("Name")
    private String namePR;
    @SerializedName("Description")
    private String DescriptionPR;
    private int imagePR;

    private float PromotionPricePR;
    private float OriginalPricePR;



    public ProductModel(String imgPR){
        this.imgPR = imgPR;
    }
    public ProductModel(int productID, int categoryID, float pricePR, String namePR, String imagePR, String descriptionPR) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.pricePR = pricePR;
        this.namePR = namePR;
        this.imgPR = imagePR;
        this.DescriptionPR = descriptionPR;
    }
//    public ProductModel(int productID, int categoryID, float pricePR, float promotionPricePR, float originalPricePR, String namePR, int imagePR, String descriptionPR) {
//        this.productID = productID;
//        this.categoryID = categoryID;
//        this.pricePR = pricePR;
//        PromotionPricePR = promotionPricePR;
//        OriginalPricePR = originalPricePR;
//        this.namePR = namePR;
//        this.imagePR = imagePR;
//        DescriptionPR = descriptionPR;
//    }

    public String getImgPR() {
        return imgPR;
    }

    public void setImgPR(String imgPR) {
        this.imgPR = imgPR;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public float getPricePR() {
        return pricePR;
    }

    public void setPricePR(float pricePR) {
        this.pricePR = pricePR;
    }

    public float getPromotionPricePR() {
        return PromotionPricePR;
    }

    public void setPromotionPricePR(float promotionPricePR) {
        PromotionPricePR = promotionPricePR;
    }

    public float getOriginalPricePR() {
        return OriginalPricePR;
    }

    public void setOriginalPricePR(float originalPricePR) {
        OriginalPricePR = originalPricePR;
    }

    public String getNamePR() {
        return namePR;
    }

    public void setNamePR(String namePR) {
        this.namePR = namePR;
    }

    public int getImagePR() {
        return imagePR;
    }

    public void setImagePR(int imagePR) {
        this.imagePR = imagePR;
    }

    public String getDescriptionPR() {
        return DescriptionPR;
    }

    public void setDescriptionPR(String descriptionPR) {
        DescriptionPR = descriptionPR;
    }
}
