package com.spse.schoolcalendar.AsyncTask;

import android.app.PendingIntent;
import android.os.AsyncTask;

import com.spse.schoolcalendar.CalendarActivity;
import com.spse.schoolcalendar.CalendarPanel;
import com.spse.schoolcalendar.VCalendar.VCalendar;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;

public class ParsingTask extends AsyncTask<Object,Void,CalendarActivity> {

    VCalendar calendar = new VCalendar();

    @Override
    protected CalendarActivity doInBackground(Object... argument) {
        File fileToParse = (File) argument[1];

        BufferedReader reader;




        try {
            reader = new BufferedReader(new FileReader(fileToParse));

            String line;
            String lastState = null;
            int currentVEvent = -1;

            while ((line = reader.readLine()) != null){
                //The buffered reader reads each lines without knowing what it is.
                //We have to re-invent the wheel

                if(line.contains(":") && line.indexOf(" ") != 0){
                    if(line.contains("BEGIN:VEVENT")){
                        currentVEvent++;
                    }
                    String key = line.substring(0,line.indexOf(":"));
                    line = line.replace(key + ":", "");

                    calendar.events[currentVEvent].details.put(key,line);
                    lastState = key;
                }else{
                    String addedValue = calendar.events[currentVEvent].details.get(lastState) + line.replace(" ","");
                    calendar.events[currentVEvent].details.put(lastState, addedValue);
                }

            }


        } catch (FileNotFoundException e) {
            System.err.println("NO FILE TO PARSE !");
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }



}
