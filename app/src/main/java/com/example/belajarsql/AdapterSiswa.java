package com.example.belajarsql;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterSiswa extends RecyclerView.Adapter<AdapterSiswa.SiswaViewHolder> {
    private ArrayList<Siswa> listsiswa;

    public AdapterSiswa(ArrayList<Siswa> listsiswa) {
        this.listsiswa = listsiswa;
    }

    @NonNull
    @Override
    public AdapterSiswa.SiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //memanggil layout item siswa untuk tampilan recyclerview activity siswa
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_siswa,parent,false);
        return new SiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SiswaViewHolder holder, final int position) {
        holder.nosiswa.setText(listsiswa.get(position).getNosiswa());
        holder.idjurusan.setText(listsiswa.get(position).getIdjurusan());
        holder.nama.setText(listsiswa.get(position).getNama());
        holder.jeniskelamin.setText(listsiswa.get(position).getJeniskelamin());
        holder.tgllahir.setText(listsiswa.get(position).getTgllahir());

    }

    @Override
    public int getItemCount() {
        return listsiswa.size();
    }

    public class SiswaViewHolder extends RecyclerView.ViewHolder {
        TextView nosiswa, idjurusan, nama, jeniskelamin, tgllahir;

        public SiswaViewHolder(@NonNull View itemView) {
            super(itemView);

            nosiswa = itemView.findViewById(R.id.Nosis);
            idjurusan = itemView.findViewById(R.id.Idjurusan);
            nama = itemView.findViewById(R.id.Nama);
            jeniskelamin = itemView.findViewById(R.id.Jeniskelamin);
            tgllahir = itemView.findViewById(R.id.Tgllahir);
        }
    }
}
