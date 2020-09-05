package com.spse.schoolcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;


import com.spse.schoolcalendar.AsyncTask.DownloadTask;
import com.spse.schoolcalendar.AsyncTask.ParsingTask;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.data.UnfoldingReader;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.component.CalendarComponent;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.util.MapTimeZoneCache;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        //launchAsyncTask(1);

        //parseCalendar(getApplicationInfo().dataDir + "/test2.ics", this);

        // We need to provide file path as the parameter:
        // double backquote is to avoid compiler interpret words
        // like \test as \t (ie. as a escape sequence)
        File file = new File(getApplicationInfo().dataDir + "/test2.ics");

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null)
                System.out.println(st);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }




    private void reloadCalendarFile(){

        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        if((getSharedPreferences("Preferences",MODE_PRIVATE).getBoolean("DataSaverMode",false)) || !FileManager.fileExists(getApplicationInfo().dataDir + "/plannings/" + date + ".ics")) {

            //Get the file

            SharedPreferences preferences = getSharedPreferences("Preferences",MODE_PRIVATE);
            new DownloadTask(this).execute(preferences.getString("ADELink","") + "&firstDate=" + date + "&lastDate=" + date ,getApplicationInfo().dataDir + "/plannings/" + date + ".ics");


        }
    }

    public void parseCalendar(String filePath, CalendarActivity activity){
        new ParsingTask().execute(activity, filePath);
    }

    public void launchAsyncTask(int taskNumber){
        switch (taskNumber){

            case 1:
                reloadCalendarFile();
                break;

            case 2:
                String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

                parseCalendar(getApplicationInfo().dataDir + "/plannings/" + date + ".ics",CalendarActivity.this);
                break;

            default:
                System.err.println("WRONG ASYNCTASK LAUNCHED !");
                break;
        }
    }
}