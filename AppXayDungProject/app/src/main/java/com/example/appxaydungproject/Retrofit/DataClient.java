package com.example.appxaydungproject.Retrofit;

import com.example.appxaydungproject.Adapter.RecycleViewAdapterProduct;
import com.example.appxaydungproject.Model.ImageDetailProduct;
import com.example.appxaydungproject.Model.LoginModel;
import com.example.appxaydungproject.Model.Post;
import com.example.appxaydungproject.Model.ProductModel;
import com.example.appxaydungproject.Model.TokenModel;
import com.example.appxaydungproject.Model.TypeProductModel;
import com.example.appxaydungproject.Model.UserModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DataClient {

    @GET("api/ProductApi")
    Call<List<ProductModel>> doGetListProduct();



    @GET("api/ProductApi/images-{id}")
    Call<List<ImageDetailProduct>> doGetListImgProduct(@Path("id") int id);

    @GET("api/ProductCategoryApi")
    Call<List<TypeProductModel>> doGetListTypeProduct();

//    @POST("/api/AccountApi")
//    Call<LoginModel> postLogin(@Body LoginModel login);
    @POST("/posts")
    @FormUrlEncoded
    Call<Post> savePost(@Field("title") String title,
                        @Field("body") String body,
                        @Field("userId") long userId);






    @POST("/api/AccountAPi/dang-nhap")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<TokenModel> postLogin(@Body LoginModel posts);
//
////    @POST("/api/AccountAPi/dang-nhap/")
////    @FormUrlEncoded
////    Call<TokenModel> postLogin(@Body LoginModel post);
//
//    @POST("/api/AccountAPi/dang-ky")
//    @FormUrlEncoded
//    Call<UserModel> postRegister(@Field("FullName") String id,
//                                 @Field("BirthDay") LocalDate date,
//                                 @Field("Email") String Email,
//                                 @Field("Password") String Password,
//                                 @Field("PhoneNumber") String PhoneNumber,
//                                 @Field("Avatar") String Avatar);

//
//    @GET("/api/users?")
//    Call<UserList> doGetUserList(@Query("page") String page);
//
//    @FormUrlEncoded
//    @POST("/api/users?")
//    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);
}
