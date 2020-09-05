package com.spse.schoolcalendar.VCalendar;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

public class VEvent {
    public HashMap<String, String> details;

    public VEvent(){
        //Preconfigure the hashmap to offer better performance
        String[] keys = {"DTSTAMP","DTSTART","DTEND","SUMMARY","LOCATION","DESCRIPTION","CREATED","LAST-MODIFIED","SEQUENCE"};
        for (String s : keys ) {
            details.put(s,null);
        }

    }

}
