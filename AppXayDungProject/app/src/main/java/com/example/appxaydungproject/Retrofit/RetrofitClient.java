package com.example.appxaydungproject.Retrofit;

import android.app.Activity;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.appxaydungproject.Adapter.RCVAdapterDetailImgPr;
import com.example.appxaydungproject.Adapter.RecycleViewAdapterProduct;
import com.example.appxaydungproject.Adapter.RecycleViewAdapterTypeProduct;
import com.example.appxaydungproject.MainActivity;
import com.example.appxaydungproject.MainActivityDetailProduct;
import com.example.appxaydungproject.Model.ImageDetailProduct;
import com.example.appxaydungproject.Model.LoginModel;
import com.example.appxaydungproject.Model.ProductModel;
import com.example.appxaydungproject.Model.TokenModel;
import com.example.appxaydungproject.Model.TypeProductModel;
import com.example.appxaydungproject.SettingAll.SettingAll;
import com.example.appxaydungproject.TabMenu.BlankFragmentDanhMuc;
import com.example.appxaydungproject.TabMenu.BlankFragmentHome;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private List<ProductModel> lstPR;
    public static void getDataProduct(View v){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SettingAll.Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        DataClient dataClient = retrofit.create(DataClient.class);

        Call<List<ProductModel>> call = dataClient.doGetListProduct();

        call.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                System.out.println("đã chạy data ///////////////////////////////////////////");
                if(!response.isSuccessful()){
//                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                    SettingAll.lsProduct = response.body();
                System.out.println("load duoc roi lsproducrt"+ SettingAll.lsProduct.size());
                    int i = 0;
                        for (ProductModel product : SettingAll.lsProduct) {
                            if(i>= 12)
                                break;
                            SettingAll.lsProductHome.add(new ProductModel(product.getProductID(),product.getCategoryID(),product.getPricePR(),product.getNamePR(),product.getImgPR(),product.getDescriptionPR()));
                            i++;
                        }

                BlankFragmentHome.recyclerViewAdapterPR = new RecycleViewAdapterProduct(v.getContext(),SettingAll.lsProductHome );
                BlankFragmentHome.myRecyclerViewPR.setLayoutManager(new GridLayoutManager(v.getContext(),3));

                BlankFragmentHome.myRecyclerViewPR.setHasFixedSize(true);
                BlankFragmentHome.myRecyclerViewPR.setAdapter(BlankFragmentHome.recyclerViewAdapterPR);
            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
            }
        });
    }
    public static void getDataImageProduct(Activity activity){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SettingAll.Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DataClient dataClient = retrofit.create(DataClient.class);
        System.out.println("get imag dettail cuat "+RecycleViewAdapterProduct.productModel.getProductID());
        Call<List<ImageDetailProduct>> call = dataClient.doGetListImgProduct(RecycleViewAdapterProduct.productModel.getProductID());

        call.enqueue(new Callback<List<ImageDetailProduct>>() {
            @Override
            public void onResponse(Call<List<ImageDetailProduct>> call, Response<List<ImageDetailProduct>> response) {
                if(!response.isSuccessful()){
                    return;
                }
                SettingAll.lsIMGDetailProduct = response.body();
                for (ImageDetailProduct post : SettingAll.lsIMGDetailProduct) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "Name Pr: " + post.getPath() + "\n";
                    content += "Category ID: " + post.getProductID() + "\n";
                    content += "Price PR: " + post.getCaption() + "\n\n";
                    System.out.println(content);
                }
                MainActivityDetailProduct.reRcvAdapterDetailImgPr = new RCVAdapterDetailImgPr(activity,SettingAll.lsIMGDetailProduct);
                MainActivityDetailProduct.myRecyclerViewPR.setHasFixedSize(true);
                MainActivityDetailProduct.myRecyclerViewPR.setAdapter(MainActivityDetailProduct.reRcvAdapterDetailImgPr);
            }
            @Override
            public void onFailure(Call<List<ImageDetailProduct>> call, Throwable t) {
            }
        });
    }
    public static void getDataTypeProduct(View v){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SettingAll.Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DataClient dataClient = retrofit.create(DataClient.class);
        Call<List<TypeProductModel>> call = dataClient.doGetListTypeProduct();

        call.enqueue(new Callback<List<TypeProductModel>>() {
            @Override
            public void onResponse(Call<List<TypeProductModel>> call, Response<List<TypeProductModel>> response) {
                if(!response.isSuccessful()){
                    return;
                }
                SettingAll.lsTypeProduct = response.body();
//                for (ImageDetailProduct post : SettingAll.lsIMGDetailProduct) {
//                    String content = "";
//                    content += "ID: " + post.getId() + "\n";
//                    content += "Name Pr: " + post.getPath() + "\n";
//                    content += "Category ID: " + post.getProductID() + "\n";
//                    content += "Price PR: " + post.getCaption() + "\n\n";
//                    System.out.println(content);
//                }
                BlankFragmentDanhMuc.recyclerViewAdapterTypePR = new RecycleViewAdapterTypeProduct(v.getContext(),SettingAll.lsTypeProduct);
                BlankFragmentDanhMuc.myRecyclerViewTypePR.setLayoutManager(new LinearLayoutManager(v.getContext()));

                BlankFragmentDanhMuc.myRecyclerViewTypePR.setHasFixedSize(true);
                BlankFragmentDanhMuc.myRecyclerViewTypePR.setAdapter(BlankFragmentDanhMuc.recyclerViewAdapterTypePR);
            }
            @Override
            public void onFailure(Call<List<TypeProductModel>> call, Throwable t) {
            }
        });
    }
    public static void getDataProductOfType(int idcategory){
        SettingAll.lsProductOfTypeProduct.removeAll(SettingAll.lsProductOfTypeProduct);
        for (ProductModel post : SettingAll.lsProduct) {
            if(post.getCategoryID() == idcategory){
                SettingAll.lsProductOfTypeProduct.add(post);
            }
        }
    }
    public static void handleAPI2(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.2:800/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        DataClient dataClient = retrofit.create(DataClient.class);

        Call<List<ProductModel>> call = dataClient.doGetListProduct();

        call.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                if(!response.isSuccessful()){
//                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                SettingAll.lsProduct = response.body();
                for (ProductModel post : SettingAll.lsProduct) {
                    String content = "";
                    content += "ID: " + post.getImgPR() + "\n";
                    content += "Name Pr: " + post.getNamePR() + "\n";
                    content += "Category ID: " + post.getCategoryID() + "\n";
                    content += "Price PR: " + post.getPricePR() + "\n\n";
                    MainActivity.txtview.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
//                textViewResult.setText(t.getMessage());
            }
        });
    }
    public static String token;

    private DataClient dataClient;

    public void sendPostLogin(String id, String pass){
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request.Builder requestBuilder = chain.request().newBuilder();
                requestBuilder.header("Content-Type", "application/json");
                requestBuilder.header("Accept", "application/json");
                return chain.proceed(requestBuilder.build());
            }
        });

        OkHttpClient httpClient = httpClientBuilder.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SettingAll.Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();


        DataClient dataClient = retrofit.create(DataClient.class);
        LoginModel loginModel = new LoginModel(id,pass,true);
        Call<TokenModel> call = dataClient.postLogin(loginModel);

        call.enqueue(new Callback<TokenModel>() {
            @Override
            public void onResponse(Call<TokenModel> call, Response<TokenModel> response) {
//                System.out.println(response.body().getTokent());
                System.out.println("ok ok ");
                try {
//                    System.out.println("okpro"+response.body().getTokent());
                    System.out.println("okpro======"+response.body().getTokent());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<TokenModel> call, Throwable t) {
//                textViewResult.setText(t.getMessage());
            }
        });
    }
//    public static void sendPostLogin1(String id,String pass){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(SettingAll.Base_Url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//
//        DataClient dataClient = retrofit.create(DataClient.class);
//
//        dataClient.postLogin(id,pass,true);
//    }
//    public static void sendPostRegister(String id,LocalDate date ,String email,String pass,String phoneNumber,String avatar){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(SettingAll.Base_Url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//
//        DataClient dataClient = retrofit.create(DataClient.class);
//
//        Call<UserModel> call = dataClient.postRegister(id,date,email,pass,phoneNumber,avatar);
//
//        call.enqueue(new Callback<UserModel>() {
//            @Override
//            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
////                System.out.println(response.body().getTokent());
//
//                try {
////
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<UserModel> call, Throwable t) {
////                textViewResult.setText(t.getMessage());
//            }
//        });
//    }
}
