package com.spse.schoolcalendar;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.nio.file.Files;

public class FileManager{

    public static boolean fileExists(String absolutePath){
        File file = new File(absolutePath);
        if(file.exists()){
            return true;
        }
        return false;
    }

    public static void createFolder(String absolutePathToFolder){
        File file = new File(absolutePathToFolder);
        if(!file.exists()){
            file.mkdir();
        }
    }



}
