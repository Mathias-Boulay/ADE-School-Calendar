package com.spse.schoolcalendar;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

public class CalendarPanel {
    View frame;
    String title;
    String location;
    String description;
    String startHour;
    String endHour;
    String creationDate;
    String lastModifiedDate;

    CalendarPanel(String title, String location, String description, String startHour, String endHour, String creationDate, String lastModifiedDate, LinearLayout layout){

        this.title = title;
        this.location = location;
        this.description = description;
        this.startHour = startHour;
        this.endHour = endHour;
        this.creationDate = creationDate;
        this.lastModifiedDate = lastModifiedDate;

        //Create a panel



    }


}
