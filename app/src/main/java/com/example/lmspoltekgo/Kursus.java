package com.example.lmspoltekgo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lmspoltekgo.adapter.KursusAdapter;
import com.example.lmspoltekgo.api.ServerInterface;
import com.example.lmspoltekgo.api.ServerMoodle;
import com.example.lmspoltekgo.data.KursusData;
import com.example.lmspoltekgo.data.UserData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Kursus extends AppCompatActivity {

    private String token, username;
    int idBiodata;
    private ServerInterface serverInterface;
    private RecyclerView recyclerView;
    private KursusAdapter adapter;
    private List<KursusData> kursusList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kursus);

        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        username = intent.getStringExtra("username");

        recyclerView = findViewById(R.id.rvKursus);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        kursusList = new ArrayList<>();

        adapter = new KursusAdapter(Kursus.this, kursusList, token);
        recyclerView.setAdapter(adapter);

        getBiodata(token, username);
    }

    private void getBiodata(String sendToken, String sendUsername){

        String token = sendToken;
        String function = "core_user_get_users_by_field";
        String format = "json";
        String value = sendUsername;
        String field = "username";

        serverInterface = ServerMoodle.getClient().create(ServerInterface.class);

        serverInterface.getUserData(token,function,format,value,field).enqueue(new Callback<List<UserData>>() {
            @Override
            public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {
                if (response.isSuccessful()) {
                    List<UserData> userDataList = response.body();

                    for (UserData userData : userDataList) {
                        idBiodata = userData.getId();
                        adapter.setIdBiodata(idBiodata,username);
                        processBiodata(idBiodata, token);
                    }
                } else {
                    Toast.makeText(Kursus.this, "Terjadi kesalahan, coba lagi nanti", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<UserData>> call, Throwable t) {
                Toast.makeText(Kursus.this, "Terjadi kesalahan, coba lagi nanti", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void processBiodata(int idBiodata, String kirimToken) {
        String token = kirimToken;
        String function = "core_enrol_get_users_courses";
        String format = "json";
        int idBdata = idBiodata;

        serverInterface = ServerMoodle.getClient().create(ServerInterface.class);

        serverInterface.getKursus(token,function,format,idBdata).enqueue(new Callback<List<KursusData>>(){
            @Override
            public void onResponse(Call<List<KursusData>> call, Response<List<KursusData>> response) {
                if (response.isSuccessful() && response.body() != null){
                    kursusList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<KursusData>> call, Throwable t) {
                Toast.makeText(Kursus.this, "ERROR : " +t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("ERROR : ", t.getMessage());
            }
        });
    }
}