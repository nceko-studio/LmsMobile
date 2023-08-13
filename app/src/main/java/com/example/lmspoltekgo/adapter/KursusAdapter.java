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

    private int idBiodata;
    private String token, username;
    private final Context context;
    private List<KursusData> kursusDataList;

    public KursusAdapter(Context context, List<KursusData> kursusDataList, String token){
        this.context = context;
        this.kursusDataList = kursusDataList;
        this.idBiodata = idBiodata;
        this.token = token;
    }

    public void setIdBiodata(int idBiodata, String username) {
        this.idBiodata = idBiodata;
        this.username  = username;
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
            intent.putExtra("idkursus", String.valueOf(kursusDataList.get(position).getId()));
            intent.putExtra("idbiodata", String.valueOf(idBiodata));
            intent.putExtra("username", String.valueOf(username));
            intent.putExtra("token", token);
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
