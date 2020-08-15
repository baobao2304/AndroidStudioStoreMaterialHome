package com.example.appxaydungproject.ModuleHandle;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIhandleAll {
    private Retrofit retrofit;
    private APIhandleAll(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


    }
    public Retrofit getRetrofit(){
        return retrofit;
    }
}
