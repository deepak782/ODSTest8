package com.example.odstest8;

import com.example.odstest8.type1.ListModel;
import com.example.odstest8.type2.JsonResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApiCall {

    //https://run.mocky.io/v3/           0c5a6324-bbe8-45f3-8c88-b29dc99bd9cb
    @GET("0c5a6324-bbe8-45f3-8c88-b29dc99bd9cb")
    Call<DataModel> getData();

    //https://run.mocky.io/v3/c4de48b8-5b93-4f07-94bc-a3e339b1de5d
    @GET("c4de48b8-5b93-4f07-94bc-a3e339b1de5d")
    Call<List<ListModel>> getList();

    //https://run.mocky.io/v3/
    @GET("482a6837-1770-4f8c-ab33-b2a36b7088fc")
    Call<JsonResponse> getresponseList();
}
