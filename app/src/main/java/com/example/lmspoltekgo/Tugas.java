package com.example.lmspoltekgo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lmspoltekgo.adapter.TugasAdapter;
import com.example.lmspoltekgo.api.ServerInterface;
import com.example.lmspoltekgo.api.ServerMoodle;
import com.example.lmspoltekgo.data.AssignmentData;
import com.example.lmspoltekgo.data.TugasData;
import com.example.lmspoltekgo.response.TugasResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tugas extends AppCompatActivity {

    private String token, idBiodata, idKursus, username;
    private ServerInterface serverInterface;
    private RecyclerView recyclerView;
    private TugasAdapter adapter;
    private List<AssignmentData> assignmentData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas);

        Intent intent = getIntent();
        idKursus = intent.getStringExtra("idkursus");
        idBiodata = intent.getStringExtra("idbiodata");
        token = intent.getStringExtra("token");
        username = intent.getStringExtra("username");

        recyclerView = findViewById(R.id.rvTugas);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        assignmentData = new ArrayList<>();

        adapter = new TugasAdapter(Tugas.this, assignmentData, token, idBiodata, username);
        recyclerView.setAdapter(adapter);

        getDataTugas(token, Integer.parseInt(idKursus));
    }

    private void getDataTugas(String sendToken, int idKursusan) {
        String astru = sendToken;
        String function = "mod_assign_get_assignments";
        String format = "json";
        int kursusandi = idKursusan;

        serverInterface = ServerMoodle.getClient().create(ServerInterface.class);

        serverInterface.getTugas(astru,function,format,kursusandi).enqueue(new Callback<TugasResponse>() {
            @Override
            public void onResponse(Call<TugasResponse> call, Response<TugasResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    TugasResponse kursusanData = response.body();

                    for (TugasData tugasCourse : kursusanData.getCourses()) {
                        List<AssignmentData> assignments = tugasCourse.getAssignments();

                        assignmentData.addAll(assignments);
                        adapter.notifyDataSetChanged();

                    }
                } else {
                    // Debugging log
                    Log.d("Debug", "Response is not successful or body is null");
                }
            }

            @Override
            public void onFailure(Call<TugasResponse> call, Throwable t) {
                Toast.makeText(Tugas.this, "ERROR : " +t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("ERROR : ", t.getMessage());
            }
        });
    }
}