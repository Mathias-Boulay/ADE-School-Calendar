package com.spse.schoolcalendar;

import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

public class DataPanel {
    public View frame;
    public TextView title;
    public TextView argument1;
    public TextView argument2;
    public TextView argument3;
    public Button confirmButton;

    DataPanel(View frame, TextView title, TextView argument1, TextView argument2, TextView argument3, Button confirmButton){
        this.frame = frame;
        this.title = title;
        this.argument1 = argument1;
        this.argument2 = argument2;
        this.argument3 = argument3;
        this.confirmButton = confirmButton;

    }

    public void startAnimation(Animation animation){
        frame.startAnimation(animation);
        title.startAnimation(animation);
        argument1.startAnimation(animation);
        argument2.startAnimation(animation);
        argument3.startAnimation(animation);
        confirmButton.startAnimation(animation);
    }

}
