package com.example.lmspoltekgo.response;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("token")
    private String token;

    @SerializedName("privatetoken")
    private String privateToken;

    public String getToken() {
        return token;
    }

    public String getPrivateToken() {
        return privateToken;
    }
}
