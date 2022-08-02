package com.example.odstest8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyHolder> {
    Context context;
    List<ListModel> listModelList=new ArrayList<>();

    public MyListAdapter(Context context, List<ListModel> listModelList) {
        this.context = context;
        this.listModelList = listModelList;
    }

    @NonNull
    @Override
    public MyListAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  root= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recycler,parent,false);

        return new MyHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.MyHolder holder, int position) {

        holder.title.setText(listModelList.get(position).getTitle());
        holder.album.setText(""+listModelList.get(position).getAlbumId());

        Glide.with(context)
                .load(listModelList.get(position).getUrl())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return listModelList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title,album;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image1);
            title=itemView.findViewById(R.id.title1);
            album=itemView.findViewById(R.id.album1);

        }
    }
}
