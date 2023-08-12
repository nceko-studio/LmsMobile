package com.example.lmspoltekgo.data;

import java.util.List;

public class TugasData {
    private int id;
    private String fullname;
    private String shortname;
    private long timemodified;
    private List<AssignmentData> assignments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public long getTimemodified() {
        return timemodified;
    }

    public void setTimemodified(long timemodified) {
        this.timemodified = timemodified;
    }

    public List<AssignmentData> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<AssignmentData> assignments) {
        this.assignments = assignments;
    }
}
