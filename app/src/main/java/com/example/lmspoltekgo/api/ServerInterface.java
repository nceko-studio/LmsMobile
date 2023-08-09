package com.example.lmspoltekgo.api;

import com.example.lmspoltekgo.response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServerInterface {
    @GET("login/token.php")
    Call<LoginResponse> login(
            @Query("username") String username,
            @Query("password") String password,
            @Query("service") String service
    );
}
