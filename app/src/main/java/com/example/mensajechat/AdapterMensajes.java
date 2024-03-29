package com.example.mensajechat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterMensajes extends RecyclerView.Adapter<HolderMensaje>{

    private List<Mensaje> listMensaje = new ArrayList<>();
    private Context c;

    public AdapterMensajes(Context c) {
        this.c = c;
    }

    public void addMensaje (Mensaje m){
        listMensaje.add(m);
        notifyItemChanged(listMensaje.size());
    }

    @NonNull
    @Override
    public HolderMensaje onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.card_view_mensajes,parent,false);
        return new HolderMensaje(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderMensaje holder, int position) {
        holder.getNombre().setText(listMensaje.get(position).getNombre());
        holder.getMensaje().setText(listMensaje.get(position).getMensaje());
        holder.getHora().setText(listMensaje.get(position).getHora());

        if (listMensaje.get(position).getType_mensaje().equals("2")){
            holder.getFotoMensajePerfil().setVisibility(View.VISIBLE);
            holder.getMensaje().setVisibility(View.VISIBLE);
            Glide.with(c).load(listMensaje.get(position).getUrlFoto()).into(holder.getFotoMensaje());
        }if (listMensaje.get(position).getType_mensaje().equals("1")){
            holder.getFotoMensajePerfil().setVisibility(View.GONE);
            holder.getMensaje().setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return listMensaje.size();
    }
}
