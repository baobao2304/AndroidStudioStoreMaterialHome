package com.example.appxaydungproject.Interface;

import com.example.appxaydungproject.Model.ProductModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CallAPIService {
    @GET("product")
    Call<List<ProductModel>> getProducts();
}

