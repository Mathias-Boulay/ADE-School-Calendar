package com.spse.schoolcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent gameActivity = new Intent(MainActivity.this, FirstStartActivity.class);
        startActivity(gameActivity);


        //new DownloadTask().execute("https://ade-web-consult.univ-amu.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?projectId=8&resources=8385&calType=ical&firstDate=2020-09-07&lastDate=2020-09-11",getAppDataPath() + "/test.ics");


    }

    public String getAppDataPath(){
        return getApplicationInfo().dataDir;
    }
}