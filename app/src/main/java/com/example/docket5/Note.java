package com.example.docket5;

import android.widget.EditText;

public class Note {

    private String course;
    private String task;
    private String startDate;
    private String endDate;

    //    Constructor that allows setting values for instance variables
    public Note(String course,String task, String startDate, String endDate){
        this.course = course;
        this.task = task;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getNote(){
        return "Course: " + course + '\n' +
                "Assignment: " + task + '\n' +
                "Start Date: " + startDate + '\n' +
                "Due Date: " + endDate;
    }
}
