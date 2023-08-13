package com.example.lmspoltekgo.data;

import java.util.List;

public class KursusData {
    private int id;
    private String shortname;
    private String fullname;
    private String displayname;
    private int enrolledusercount;
    private String idnumber;
    private int visible;
    private String summary;
    private int summaryformat;
    private String format;
    private boolean showgrades;
    private String lang;
    private boolean enablecompletion;
    private boolean completionhascriteria;
    private boolean completionusertracked;
    private int category;
    private double progress;
    private boolean completed;
    private long startdate;
    private long enddate;
    private int marker;
    private Long lastaccess;
    private boolean isfavourite;
    private boolean hidden;
    private List<Object> overviewfiles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public int getEnrolledusercount() {
        return enrolledusercount;
    }

    public void setEnrolledusercount(int enrolledusercount) {
        this.enrolledusercount = enrolledusercount;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getSummaryformat() {
        return summaryformat;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public void setSummaryformat(int summaryformat) {
        this.summaryformat = summaryformat;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean isShowgrades() {
        return showgrades;
    }

    public void setShowgrades(boolean showgrades) {
        this.showgrades = showgrades;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public boolean isEnablecompletion() {
        return enablecompletion;
    }

    public void setEnablecompletion(boolean enablecompletion) {
        this.enablecompletion = enablecompletion;
    }

    public boolean isCompletionhascriteria() {
        return completionhascriteria;
    }

    public void setCompletionhascriteria(boolean completionhascriteria) {
        this.completionhascriteria = completionhascriteria;
    }

    public boolean isCompletionusertracked() {
        return completionusertracked;
    }

    public void setCompletionusertracked(boolean completionusertracked) {
        this.completionusertracked = completionusertracked;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public long getStartdate() {
        return startdate;
    }

    public void setStartdate(long startdate) {
        this.startdate = startdate;
    }

    public long getEnddate() {
        return enddate;
    }

    public void setEnddate(long enddate) {
        this.enddate = enddate;
    }

    public int getMarker() {
        return marker;
    }

    public void setMarker(int marker) {
        this.marker = marker;
    }

    public Long getLastaccess() {
        return lastaccess;
    }

    public void setLastaccess(Long lastaccess) {
        this.lastaccess = lastaccess;
    }

    public boolean isIsfavourite() {
        return isfavourite;
    }

    public void setIsfavourite(boolean isfavourite) {
        this.isfavourite = isfavourite;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public List<Object> getOverviewfiles() {
        return overviewfiles;
    }

    public void setOverviewfiles(List<Object> overviewfiles) {
        this.overviewfiles = overviewfiles;
    }
}
