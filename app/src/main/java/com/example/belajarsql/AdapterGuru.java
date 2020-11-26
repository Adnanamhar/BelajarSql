package com.example.belajarsql;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterGuru extends RecyclerView.Adapter<AdapterGuru.GuruViewHolder> {
    private ArrayList<Guru> listguru;

    public AdapterGuru(ArrayList<Guru> listguru) {
        this.listguru = listguru;
    }

    @NonNull
    @Override
    public AdapterGuru.GuruViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_guru,parent,false);
        return new GuruViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuruViewHolder holder, int position) {
        holder.idguru.setText(listguru.get(position).getIdguru());
        holder.nama_guru.setText(listguru.get(position).getNama_guru());
        holder.jenis_kelamin.setText(listguru.get(position).getJenis_kelamin());
        holder.kota.setText(listguru.get(position).getKota());
        holder.gajiguru.setText(listguru.get(position).getGajiguru());

    }

    @Override
    public int getItemCount() {
        return listguru.size();
    }

    public class GuruViewHolder extends RecyclerView.ViewHolder {

        TextView idguru,nama_guru,jenis_kelamin,kota,gajiguru;

        public GuruViewHolder(@NonNull View itemView) {
            super(itemView);

            idguru = itemView.findViewById(R.id.idguru);
            nama_guru = itemView.findViewById(R.id.nama_guru);
            jenis_kelamin = itemView.findViewById(R.id.jenis_kelamin);
            kota = itemView.findViewById(R.id.kota);
            gajiguru = itemView.findViewById(R.id.gajiguru);

        }
    }
}
