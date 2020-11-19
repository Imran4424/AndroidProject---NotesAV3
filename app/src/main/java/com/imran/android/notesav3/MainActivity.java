package com.imran.android.notesav3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<String> titleList = new ArrayList<>();
    public static List<String> bodyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void saveNote(String title, String body, int position) {
        if(position >= titleList.size()) {
            titleList.add(title);
            bodyList.add(body);
        } else {
            ArrayList<String> test = new ArrayList<>();































            
        }

    }
}