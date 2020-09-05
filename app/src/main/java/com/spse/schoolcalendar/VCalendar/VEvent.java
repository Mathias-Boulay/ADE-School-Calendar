package com.spse.schoolcalendar.VCalendar;

import java.time.LocalDate;
import java.util.Date;

public class VEvent {
    int[] startDate = new int[5];
    int[] endDate = new int[5];
    int[] modifiedDate = new int[5];

    String UID;
    String summary;
    String location;
    String Description;

    //Set values
    public void setStartDate(int[] startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(int[] endDate) {
        this.endDate = endDate;
    }

    public void setModifiedDate(int[] modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    //Get values
    public int[] getStartDate(int part) {
        return startDate;
    }

    public int[] getEndDate() {
        return endDate;
    }

    public int[] getModifiedDate() {
        return modifiedDate;
    }

    public String getDescription() {
        return Description;
    }

    public String getLocation() {
        return location;
    }

    public String getSummary() {
        return summary;
    }

    public String getUID() {
        return UID;
    }
}
