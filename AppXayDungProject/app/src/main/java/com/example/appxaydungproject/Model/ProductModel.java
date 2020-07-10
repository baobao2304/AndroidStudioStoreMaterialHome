package com.example.appxaydungproject.Model;

public class ProductModel {
    private int productID,categoryID,imagePR;
    private float pricePR,PromotionPricePR,OriginalPricePR;
    private String namePR,DescriptionPR;
    public ProductModel(){

    }

    public ProductModel(int productID, int categoryID, float pricePR, float promotionPricePR, float originalPricePR, String namePR, int imagePR, String descriptionPR) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.pricePR = pricePR;
        PromotionPricePR = promotionPricePR;
        OriginalPricePR = originalPricePR;
        this.namePR = namePR;
        this.imagePR = imagePR;
        DescriptionPR = descriptionPR;
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
