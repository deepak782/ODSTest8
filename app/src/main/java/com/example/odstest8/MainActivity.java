package com.example.odstest8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ProgressDialog progressDialog;
    Retrofit retrofit;
    MyApiCall myApiCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);

        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApiCall=retrofit.create(MyApiCall.class);



        loadData();



    }

    private void loadData() {
        progressDialog.show();
        progressDialog.setMessage("Loading....");

        Call<DataModel> call=myApiCall.getData();

        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                progressDialog.dismiss();

                if(response.code()!=200)
                {
                    Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    DataModel dataModel= response.body();

                    String value="";
                    value+="UserId:- "+dataModel.getUserId()+"\n";
                    value+="Id:- "+dataModel.getId()+"\n";
                    value+="Title:- "+dataModel.getTitle()+"\n";
                    value+="Body:- "+dataModel.getBody()+"\n";
                    value+="Author:- "+dataModel.getReference();

                    textView.append(value);


                }

            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                progressDialog.dismiss();

            }
        });
    }
}