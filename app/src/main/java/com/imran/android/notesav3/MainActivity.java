package com.imran.android.notesav3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    private static NotesRecyclerAdapter notesRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView notesRecyclerView = findViewById(R.id.notesRecyclerView);
        notesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        notesRecyclerAdapter = new NotesRecyclerAdapter(this, titleList);
        notesRecyclerView.setAdapter(notesRecyclerAdapter);
    }

    public static void saveTitle(int position, String title) {
        if (position >= titleList.size()) {
            titleList.add(title);
        } else {
            titleList.set(position, title);
        }

        notesRecyclerAdapter.notifyDataSetChanged();
    }

    public static void saveBody(int position, String body) {
        if (position >= bodyList.size()) {
            bodyList.add(body);
        } else {
            bodyList.set(position, body);
        }

        notesRecyclerAdapter.notifyDataSetChanged();
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
            NoteEditorActivity.position = Math.max(titleList.size(), bodyList.size());

            Intent newNoteIntent = new Intent(this, NoteEditorActivity.class);
            startActivity(newNoteIntent);

            return  true;
        }

        return  false;
    }
}