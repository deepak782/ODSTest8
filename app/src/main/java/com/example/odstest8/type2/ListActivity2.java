package com.example.odstest8.type2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.odstest8.MyApiCall;
import com.example.odstest8.R;
import com.example.odstest8.type1.ListActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListActivity2 extends AppCompatActivity {

    ListView simpleList;

    MovizModel movizModel;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> arrayList=new ArrayList<>();
   // List<MovizModel> movizModelList=new ArrayList<>();
    MyApiCall myApiCall;
    Retrofit retrofit;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        simpleList=findViewById(R.id.simpleList);

        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApiCall=retrofit.create(MyApiCall.class);

        Call<JsonResponse> call=myApiCall.getresponseList();

        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                progressDialog.dismiss();
                if(response.code()!=200)
                {
                    Toast.makeText(ListActivity2.this, ""+response, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    List<MovizModel> movizModelList11=response.body().getMovizModelList();

                    for(MovizModel movizModel1:movizModelList11)
                    {
                        int album=movizModel1.getAlbumId();
                        int id=movizModel1.getId();
                        String title=movizModel1.getTitle();
                        String url=movizModel1.getUrl();
                        String thumburl=movizModel1.getThumbnailUrl();

                        arrayList.add(""+album+"\n"+id+"\n"+title+"\n"+url+"\n"+thumburl);
                        arrayAdapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
                        simpleList.setAdapter(arrayAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                progressDialog.dismiss();

            }
        });

    }
}