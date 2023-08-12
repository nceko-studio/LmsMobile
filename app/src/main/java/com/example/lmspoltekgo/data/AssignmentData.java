package com.example.lmspoltekgo.data;

public class AssignmentData {
    private int id;
    private int cmid;
    private int course;
    private String name;
    private int nosubmissions;
    private int submissiondrafts;
    private int sendnotifications;
    private int sendlatenotifications;
    private int sendstudentnotifications;
    private int duedate;
    private int allowsubmissionsfromdate;
    private int grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCmid() {
        return cmid;
    }

    public void setCmid(int cmid) {
        this.cmid = cmid;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNosubmissions() {
        return nosubmissions;
    }

    public void setNosubmissions(int nosubmissions) {
        this.nosubmissions = nosubmissions;
    }

    public int getSubmissiondrafts() {
        return submissiondrafts;
    }

    public void setSubmissiondrafts(int submissiondrafts) {
        this.submissiondrafts = submissiondrafts;
    }

    public int getSendnotifications() {
        return sendnotifications;
    }

    public void setSendnotifications(int sendnotifications) {
        this.sendnotifications = sendnotifications;
    }

    public int getSendlatenotifications() {
        return sendlatenotifications;
    }

    public void setSendlatenotifications(int sendlatenotifications) {
        this.sendlatenotifications = sendlatenotifications;
    }

    public int getSendstudentnotifications() {
        return sendstudentnotifications;
    }

    public void setSendstudentnotifications(int sendstudentnotifications) {
        this.sendstudentnotifications = sendstudentnotifications;
    }

    public int getDuedate() {
        return duedate;
    }

    public void setDuedate(int duedate) {
        this.duedate = duedate;
    }

    public int getAllowsubmissionsfromdate() {
        return allowsubmissionsfromdate;
    }

    public void setAllowsubmissionsfromdate(int allowsubmissionsfromdate) {
        this.allowsubmissionsfromdate = allowsubmissionsfromdate;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getTimemodified() {
        return timemodified;
    }

    public void setTimemodified(int timemodified) {
        this.timemodified = timemodified;
    }

    public int getGradingduedate() {
        return gradingduedate;
    }

    public void setGradingduedate(int gradingduedate) {
        this.gradingduedate = gradingduedate;
    }

    private int timemodified;
    private int gradingduedate;


}
