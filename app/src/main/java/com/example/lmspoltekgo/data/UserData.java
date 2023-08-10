package com.example.lmspoltekgo.data;

import com.google.gson.annotations.SerializedName;

public class UserData {

    @SerializedName("id")
    private int id;

    @SerializedName("username")
    private String username;

    @SerializedName("fullname")
    private String fullname;

    @SerializedName("email")
    private String email;

    @SerializedName("department")
    private String department;

    @SerializedName("firstaccess")
    private long firstAccess;

    @SerializedName("lastaccess")
    private long lastAccess;

    @SerializedName("auth")
    private String auth;

    @SerializedName("suspended")
    private boolean suspended;

    @SerializedName("confirmed")
    private boolean confirmed;

    @SerializedName("lang")
    private String lang;

    @SerializedName("theme")
    private String theme;

    @SerializedName("timezone")
    private String timezone;

    @SerializedName("mailformat")
    private int mailFormat;

    @SerializedName("description")
    private String description;

    @SerializedName("descriptionformat")
    private int descriptionFormat;

    @SerializedName("city")
    private String city;

    @SerializedName("country")
    private String country;

    @SerializedName("profileimageurlsmall")
    private String profileImageUrlSmall;

    @SerializedName("profileimageurl")
    private String profileImageUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getFirstAccess() {
        return firstAccess;
    }

    public void setFirstAccess(long firstAccess) {
        this.firstAccess = firstAccess;
    }

    public long getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(long lastAccess) {
        this.lastAccess = lastAccess;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getMailFormat() {
        return mailFormat;
    }

    public void setMailFormat(int mailFormat) {
        this.mailFormat = mailFormat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDescriptionFormat() {
        return descriptionFormat;
    }

    public void setDescriptionFormat(int descriptionFormat) {
        this.descriptionFormat = descriptionFormat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProfileImageUrlSmall() {
        return profileImageUrlSmall;
    }

    public void setProfileImageUrlSmall(String profileImageUrlSmall) {
        this.profileImageUrlSmall = profileImageUrlSmall;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
