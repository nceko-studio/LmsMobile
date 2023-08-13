package com.example.lmspoltekgo.response;

import com.google.gson.annotations.SerializedName;

public class SubmitResponse {
    @SerializedName("component")
    private String component;

    @SerializedName("contextid")
    private int contextId;

    @SerializedName("userid")
    private String userId;

    @SerializedName("filearea")
    private String fileArea;

    @SerializedName("filename")
    private String fileName;

    @SerializedName("filepath")
    private String filePath;

    @SerializedName("itemid")
    private long itemId;

    @SerializedName("license")
    private String license;

    @SerializedName("author")
    private String author;

    @SerializedName("source")
    private String source;
}
