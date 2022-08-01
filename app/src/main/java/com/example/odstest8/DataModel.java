package com.example.odstest8;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel {

    private  int  userId;
    private  int  id;
    private  String title;
    private  String body;
    @SerializedName("author")
    private  String reference;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getReference() {
        return reference;
    }
}
