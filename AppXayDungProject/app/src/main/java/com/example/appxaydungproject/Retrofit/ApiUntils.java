package com.example.appxaydungproject.Retrofit;

import com.example.appxaydungproject.Model.TypeProductModel;

import java.util.List;

public class ApiUntils {
    //truyen duong dan vao
    public static final String Base_Url = "http://192.168.1.21:500";

//    public static DataClient getData(){
//        return RetrofitClient.getClient(Base_Url).create(DataClient.class);
//    }
//
//    public static DataClient getDataTypeProduct(){
//        return RetrofitClient.getClient(Base_Url).create(DataClient.class);
//    }
    /**
     GET List Resources
     **/
//    Call<TypeProductModel> call = apiInterface.doGetListResources();
//        call.enqueue(new Callback<MultipleResource>() {
//        @Override
//        public void onResponse(Call<MultipleResource> call, Response<MultipleResource> response) {
//
//
//            Log.d("TAG",response.code()+"");
//
//            String displayResponse = "";
//
//            MultipleResource resource = response.body();
//            Integer text = resource.page;
//            Integer total = resource.total;
//            Integer totalPages = resource.totalPages;
//            List<MultipleResource.Datum> datumList = resource.data;
//
//            displayResponse += text + " Page\n" + total + " Total\n" + totalPages + " Total Pages\n";
//
//            for (MultipleResource.Datum datum : datumList) {
//                displayResponse += datum.id + " " + datum.name + " " + datum.pantoneValue + " " + datum.year + "\n";
//            }
//
//            responseText.setText(displayResponse);
//
//        }
//
//    }
}
