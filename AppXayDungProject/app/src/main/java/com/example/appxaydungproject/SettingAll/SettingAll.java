package com.example.appxaydungproject.SettingAll;

import com.example.appxaydungproject.Model.ImageDetailProduct;
import com.example.appxaydungproject.Model.ProductModel;
import com.example.appxaydungproject.Model.TypeProductModel;
import com.example.appxaydungproject.Model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class SettingAll {
    public static final String Base_Url = "http://172.17.101.4:4000/";
//    public static final String Base_Url = "http://192.168.1.20:800/";
    public static List<ProductModel> lsProductHome = new ArrayList<>();

    public static List<ProductModel> lsProduct = new ArrayList<>();

    public static List<ImageDetailProduct> lsIMGDetailProduct = new ArrayList<>();

    public static List<TypeProductModel> lsTypeProduct = new ArrayList<>();
    public static List<ProductModel> lsProductOfTypeProduct = new ArrayList<>();

    public static UserModel userModel;

    public static  int checkDNDX;
}
