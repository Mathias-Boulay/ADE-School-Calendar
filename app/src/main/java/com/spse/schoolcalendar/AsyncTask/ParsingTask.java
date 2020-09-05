package com.spse.schoolcalendar.AsyncTask;

import android.app.PendingIntent;
import android.os.AsyncTask;

import com.spse.schoolcalendar.CalendarActivity;
import com.spse.schoolcalendar.CalendarPanel;
import com.spse.schoolcalendar.VCalendar.VCalendar;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.data.UnfoldingReader;
import net.fortuna.ical4j.model.*;
import net.fortuna.ical4j.model.component.*;
import net.fortuna.ical4j.model.property.*;

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

                if(line.contains("BEGIN:VCALENDAR")){
                    lastState = "BEGIN:VCALENDAR";
                    continue;
                }

                if(line.contains("METHOD:")){
                    lastState = "METHOD";
                    calendar.method = line.replace("METHOD:","");
                    continue;
                }

                //if(line.contains("PROID"))



            }


        } catch (FileNotFoundException e) {
            System.err.println("NO FILE TO PARSE !");
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }



}
