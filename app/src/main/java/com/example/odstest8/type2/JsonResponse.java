package com.example.odstest8.type2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonResponse {

    @SerializedName("moviz")
    @Expose
    private List<MovizModel> movizModelList;

    public List<MovizModel> getMovizModelList() {
        return movizModelList;
    }

    public void setMovizModelList(List<MovizModel> movizModelList) {
        this.movizModelList = movizModelList;
    }
}
