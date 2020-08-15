package com.example.appxaydungproject.Model;

public class ItemGioHang {
    String nameProduct;
    String soLuong;
    String Image;
    String priceProduct;
    public ItemGioHang(String nameProduct, String soLuong,String priceProduct, String image) {
        this.nameProduct = nameProduct;
        this.priceProduct =priceProduct;
        this.soLuong = soLuong;
        Image = image;
    }

    public String getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(String priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
