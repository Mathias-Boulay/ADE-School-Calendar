package com.spse.schoolcalendar;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.nio.file.Files;

public class FirstStartActivity extends AppCompatActivity {

    boolean dataSaverMode = true;

    DataPanel dataBurner;
    DataPanel dataSaver;

    EditText ADELink;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_start);



        dataSaver = new DataPanel(findViewById(R.id.DataSaverFrame),
                (TextView) findViewById(R.id.textViewDataSaverTitle),
                (TextView) findViewById(R.id.textViewDataSaverArgument1),
                (TextView) findViewById(R.id.textViewDataSaverArgument2),
                (TextView) findViewById(R.id.textViewDataSaverArgument3),
                (Button) findViewById(R.id.buttonDataSaverConfirm));

        dataBurner = new DataPanel(findViewById(R.id.DataBurnerFrame),
                (TextView) findViewById(R.id.textViewDataBurnerTitle),
                (TextView) findViewById(R.id.textViewDataBurnerArgument1),
                (TextView) findViewById(R.id.textViewDataBurnerArgument2),
                (TextView) findViewById(R.id.textViewDataBurnerArgument3),
                (Button) findViewById(R.id.buttonDataBurnerConfirm));

        ADELink = findViewById(R.id.editTextADELink);



        //First thing, play an animation
        transitionInDataPanel(dataSaver, dataBurner);


        dataSaver.confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataSaverMode = true;
                dataSaver.confirmButton.setClickable(false);

                transitionOutDataPanel(dataSaver,dataBurner);
                transitionInTextView(ADELink);


            }
        });


        dataBurner.confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataSaverMode = false;
                dataBurner.confirmButton.setClickable(false);

                transitionOutDataPanel(dataSaver,dataBurner);
                transitionInTextView(ADELink);

            }
        });



    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_ENTER){
            //Then take the link into account to process it.
            String link = ADELink.getText().toString();

            //Check if the link is valid by looking at special traits with this type of links
            if (link.contains("ade-web-consult") && (link.contains("Type=ical"))){
                //The link is 'valid'
                link = link.substring(0,link.indexOf("&firstDate"));
                preferences = getSharedPreferences("Preferences",MODE_PRIVATE);
                editor = preferences.edit();
                editor.putString("ADELink",link);
                editor.putBoolean("DataSaverMode",dataSaverMode);

                editor.apply();
                Intent gameActivity = new Intent(FirstStartActivity.this, CalendarActivity.class);
                startActivity(gameActivity);
            }
            else{
                //Do something to tell the link is invalid
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    private void transitionInDataPanel(DataPanel leftPanel, DataPanel rightPanel){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.bottom_to_top_fade_in);
        leftPanel.startAnimation(animation);
        rightPanel.startAnimation(animation);
    }

    private void transitionOutDataPanel(DataPanel leftPanel, DataPanel rightPanel){
        Animation animationScale = AnimationUtils.loadAnimation(this,R.anim.on_click_scale);
        Animation animationOutLeft = AnimationUtils.loadAnimation(this,R.anim.right_to_left);
        Animation animationOutRight = AnimationUtils.loadAnimation(this,R.anim.left_to_right);

        leftPanel.startAnimation(animationScale);
        rightPanel.startAnimation(animationScale);

        leftPanel.startAnimation(animationOutLeft);
        rightPanel.startAnimation(animationOutRight);

    }

    private void transitionInTextView(EditText editText){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.bottom_to_top_fade_in);
        editText.setClickable(true);
        editText.startAnimation(animation);
        editText.setVisibility(View.VISIBLE);
    }




}