package com.example.lmspoltekgo.response;

public class UploadResponse {
    private String component;
    private int contextid;
    private String userid;
    private String filearea;
    private String filename;
    private String filepath;
    private long itemid;
    private String license;
    private String author;
    private String source;

    // Getter methods for the fields

    public String getComponent() {
        return component;
    }

    public int getContextid() {
        return contextid;
    }

    public String getUserid() {
        return userid;
    }

    public String getFilearea() {
        return filearea;
    }

    public String getFilename() {
        return filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public long getItemid() {
        return itemid;
    }

    public String getLicense() {
        return license;
    }

    public String getAuthor() {
        return author;
    }

    public String getSource() {
        return source;
    }
}
