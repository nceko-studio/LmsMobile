package com.example.lmspoltekgo.response;

import com.example.lmspoltekgo.data.TugasData;

import java.util.List;

public class TugasResponse {
    private List<TugasData> courses;
    private List<String> warnings;

    public List<TugasData> getCourses() {
        return courses;
    }

    public void setCourses(List<TugasData> courses) {
        this.courses = courses;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }
}
