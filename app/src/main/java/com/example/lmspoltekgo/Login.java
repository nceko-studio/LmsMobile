package com.example.lmspoltekgo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lmspoltekgo.api.ServerInterface;
import com.example.lmspoltekgo.api.ServerMoodle;
import com.example.lmspoltekgo.response.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private ServerInterface serverInterface;

    private EditText iUsername, iPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iUsername = findViewById(R.id.textUsername);
        iPassword = findViewById(R.id.textPassword);
        btnLogin = findViewById(R.id.btLogin);

        btnLogin.setOnClickListener(v -> {
            loginYuk();
        });
    }

    private void loginYuk(){
        serverInterface = ServerMoodle.getClient().create(ServerInterface.class);

        String userName = iUsername.getText().toString();
        String passWord = iPassword.getText().toString();

        if (userName.isEmpty() || passWord.isEmpty()) {
            Toast.makeText(Login.this, "Mohon lengkapi semua data terlebih dahulu", Toast.LENGTH_SHORT).show();
            return;
        }

        serverInterface.login(userName, passWord, "moodle_mobile_app").enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    String token = loginResponse.getToken();
                    String sendUsername = userName;

                    if (token != null && !token.isEmpty()) {
                        Intent i = new Intent(Login.this, Kursus.class);
                        i.putExtra("token", token);
                        i.putExtra("username", sendUsername);
                        startActivity(i);

                        Toast.makeText(Login.this, "Selamat Datang", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Login.this, "Username atau password salah", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Login.this, "Terjadi kesalahan, coba lagi nanti", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(Login.this, "Terjadi kesalahan, coba lagi nanti", Toast.LENGTH_SHORT).show();
            }
        });

    }
}