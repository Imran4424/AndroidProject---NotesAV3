package com.imran.android.notesav3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import java.util.HashSet;

public class NoteEditorActivity extends AppCompatActivity {
    private final String TITLE_LIST_KEY = "titleListKey";
    private final String BODY_LIST_KEY = "bodyListKey";
    public static int position;
    private TextView title;
    private TextView body;
    private SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.imran.android.notesav3", Context.MODE_PRIVATE);

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

                    HashSet<String> titleSet = new HashSet<>(MainActivity.titleList);
                    sharedPreferences.edit().putStringSet(TITLE_LIST_KEY, titleSet).apply();
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
                String bodyText = text.toString();
                bodyText = bodyText.replaceAll(" ", "");

                if(bodyText.length() > 0) {
                    MainActivity.saveBody(position, String.valueOf(text));

                    HashSet<String> bodySet = new HashSet<>(MainActivity.bodyList);
                    sharedPreferences.edit().putStringSet(BODY_LIST_KEY, bodySet).apply();
                }
            }

            @Override
            public void afterTextChanged(Editable text) {

            }
        });
    }
}