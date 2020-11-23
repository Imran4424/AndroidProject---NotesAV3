package com.imran.android.notesav3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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

    public static void saveTitle(int position, String title) {
        if (position >= titleList.size()) {
            titleList.add(title);
        } else {
            titleList.set(position, title);
        }

    }

    public static void saveBody(int position, String body) {
        if (position >= bodyList.size()) {
            bodyList.add(body);
        } else {
            bodyList.set(position, body);
        }
    }

    // Menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.add_note) {
            if (titleList.size() > bodyList.size()) {
                NoteEditorActivity.position = titleList.size();
            } else {
                NoteEditorActivity.position = bodyList.size();
            }

            Intent newNoteIntent = new Intent(this, NoteEditorActivity.class);
            startActivity(newNoteIntent);

            return  true;
        }

        return  false;
    }
}