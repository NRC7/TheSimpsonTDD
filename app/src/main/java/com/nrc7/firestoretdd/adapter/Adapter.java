package com.nrc7.firestoretdd.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nrc7.firestoretdd.databinding.ListItemSimpsonsBinding;
import com.nrc7.firestoretdd.model.Pojo;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Pojo> pojoList;
    private Context context;

    public Adapter(List<Pojo> pojoList, Context context) {
        this.pojoList = pojoList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemSimpsonsBinding listBinding = ListItemSimpsonsBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new MyViewHolder(listBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pojo pojo = pojoList.get(position);
        // Nombre
        holder.holderBinding.nombreTv.setText(pojo.getCharacter());
        // Frase
        holder.holderBinding.fraseTv.setText(pojo.getQuote());
        // Imagen
        Glide.with(context).load(pojo.getImage())
                .into(holder.holderBinding.imageView);
    }

    @Override
    public int getItemCount() {
        return pojoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ListItemSimpsonsBinding holderBinding;

        public MyViewHolder(@NonNull ListItemSimpsonsBinding itemView) {
            super(itemView.getRoot());
            this.holderBinding = itemView;
        }
    }
}
