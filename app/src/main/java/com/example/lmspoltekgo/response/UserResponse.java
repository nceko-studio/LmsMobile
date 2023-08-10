package com.example.lmspoltekgo.response;

import com.example.lmspoltekgo.data.UserData;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {
    @SerializedName("")
    private List<UserData> userDataList;

    public List<UserData> getUserDataList() {
        return userDataList;
    }
}
