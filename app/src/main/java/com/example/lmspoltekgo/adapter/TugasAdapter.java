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
import com.example.lmspoltekgo.SubmitAssign;
import com.example.lmspoltekgo.data.AssignmentData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TugasAdapter extends RecyclerView.Adapter<TugasAdapter.ViewHolder> {
    private String token,idBiodata;
    private final Context context;
    private List<AssignmentData> tugasDataList;

    public TugasAdapter(Context context, List<AssignmentData> tugasDataList, String token, String idBiodata){
        this.context = context;
        this.tugasDataList = tugasDataList;
        this.token = token;
        this.idBiodata = idBiodata;
    }

    @NonNull
    @Override
    public TugasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_tugas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TugasAdapter.ViewHolder holder, int position) {

        holder.namaTugas.setText(tugasDataList.get(position).getName());
        long gradingDueTimestamp = tugasDataList.get(position).getGradingduedate();
        String formattedDueDate = formatDate(gradingDueTimestamp);
        holder.tanggalTugas.setText(formattedDueDate);

        holder.btnGoSubmit.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), SubmitAssign.class);
            intent.putExtra("idtugas", String.valueOf(tugasDataList.get(position).getId()));
            intent.putExtra("idbiodata", idBiodata);
            intent.putExtra("token", token);
            v.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return tugasDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView namaTugas, tanggalTugas;
        Button btnGoSubmit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            namaTugas = itemView.findViewById(R.id.namaTugas);
            tanggalTugas = itemView.findViewById(R.id.tglClose);
            btnGoSubmit = itemView.findViewById(R.id.btnGoSubmit);
        }
    }

    private String formatDate(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
        Date date = new Date(timestamp * 1000L);
        return sdf.format(date);
    }

}
