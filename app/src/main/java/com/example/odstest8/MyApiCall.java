package com.example.odstest8;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApiCall {

    //https://run.mocky.io/v3/           0c5a6324-bbe8-45f3-8c88-b29dc99bd9cb
    @GET("0c5a6324-bbe8-45f3-8c88-b29dc99bd9cb")
    Call<DataModel> getData();
}
