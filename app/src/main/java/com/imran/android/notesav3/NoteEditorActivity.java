package com.imran.android.notesav3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NoteEditorActivity extends AppCompatActivity {
    public static int position;
    private TextView title;
    private TextView body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        title = findViewById(R.id.editorTitle);
        body = findViewById(R.id.editTextTextMultiLine);
    }
}