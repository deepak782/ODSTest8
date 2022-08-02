package com.example.odstest8;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApiCall {

    //https://run.mocky.io/v3/           0c5a6324-bbe8-45f3-8c88-b29dc99bd9cb
    @GET("0c5a6324-bbe8-45f3-8c88-b29dc99bd9cb")
    Call<DataModel> getData();

    //https://run.mocky.io/v3/
    @GET("c4de48b8-5b93-4f07-94bc-a3e339b1de5d")
    Call<List<ListModel>> getList();
}
