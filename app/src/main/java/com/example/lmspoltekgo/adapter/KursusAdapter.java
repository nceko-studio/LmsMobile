package com.example.lmspoltekgo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lmspoltekgo.R;
import com.example.lmspoltekgo.Tugas;
import com.example.lmspoltekgo.data.KursusData;

import java.util.List;

public class KursusAdapter extends RecyclerView.Adapter<KursusAdapter.ViewHolder> {

    private final Context context;
    private List<KursusData> kursusDataList;

    public KursusAdapter(Context context, List<KursusData> kursusDataList){
        this.context = context;
        this.kursusDataList = kursusDataList;
    }

    @NonNull
    @Override
    public KursusAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_kursus, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KursusAdapter.ViewHolder holder, int position) {

        holder.namaKursus.setText(kursusDataList.get(position).getFullname());

        holder.btnGoTugas.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), Tugas.class);
            intent.putExtra("idkursus", kursusDataList.get(position).getId());
            intent.putExtra("idbiodata", kursusDataList.get(position).getId());
            intent.putExtra("token", kursusDataList.get(position).getId());
            v.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return kursusDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView namaKursus;
        Button btnGoTugas;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            namaKursus = itemView.findViewById(R.id.namaKursus);
            btnGoTugas = itemView.findViewById(R.id.btnGoTugas);
        }
    }
}
