package com.imran.android.notesav3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
        body = findViewById(R.id.editorBody);

        if(position < MainActivity.titleList.size()) {
            title.setText(MainActivity.titleList.get(position));
        }

        if (position < MainActivity.bodyList.size()) {
            body.setText(MainActivity.bodyList.get(position));
        }

        title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                String titleText = text.toString();
                titleText = titleText.replaceAll(" ", "");

                if(titleText.length() == 0) {
                    MainActivity.saveTitle(position, "No Title");
                } else {
                    MainActivity.saveTitle(position, String.valueOf(text));
                }
            }

            @Override
            public void afterTextChanged(Editable text) {

            }
        });

        body.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                MainActivity.saveBody(position, String.valueOf(text));
            }

            @Override
            public void afterTextChanged(Editable text) {

            }
        });
    }
}