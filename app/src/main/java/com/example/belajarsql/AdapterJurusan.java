package com.example.belajarsql;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterJurusan extends RecyclerView.Adapter<AdapterJurusan.JurusanViewHolder> {
    private ArrayList<Jrsn> listjurusan;

    public AdapterJurusan(ArrayList<Jrsn> listjurusan) {
        this.listjurusan = listjurusan;
    }
    @NonNull
    @Override
    public AdapterJurusan.JurusanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jurusan,parent,false);
        return new JurusanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JurusanViewHolder holder,final int position) {
        holder.nosis.setText(listjurusan.get(position).getNosiswa());
        holder.tvnama.setText(listjurusan.get(position).getNamajurusan());
        holder.idjurusan.setText(listjurusan.get(position).getIdjurusan());
    }

    @Override
    public int getItemCount() {
        return listjurusan.size();
    }

    public class JurusanViewHolder extends RecyclerView.ViewHolder {

        TextView tvnama, nosis,idjurusan;

        public JurusanViewHolder(@NonNull View itemView) {
            super(itemView);

            tvnama = itemView.findViewById(R.id.textnya);
            nosis = itemView.findViewById(R.id.nosis);
            idjurusan = itemView.findViewById(R.id.idjurusan);
        }
    }
}
