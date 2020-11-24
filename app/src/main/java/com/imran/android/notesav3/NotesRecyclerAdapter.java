package com.imran.android.notesav3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by Shah Md Imran Hossain on 18, November, 2020
 */
public class NotesRecyclerAdapter extends RecyclerView.Adapter<NotesRecyclerAdapter.ViewHolder> {
    private final Context context;
    private final LayoutInflater layoutInflater;
    private final List<String> titles;

    public NotesRecyclerAdapter(Context context, List<String> titles) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.titles = titles;
    }

    @NonNull
    @Override
    public NotesRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_note_list, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesRecyclerAdapter.ViewHolder holder, int position) {
        holder.titleTextView.setText(titles.get(position));
        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView titleTextView;
        public int position;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent noteEditorIntent = new Intent(context, NoteEditorActivity.class);
                    NoteEditorActivity.position = position;

                    context.startActivity(noteEditorIntent);
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    new AlertDialog.Builder(context)
                            .setIcon(android.R.drawable.ic_delete)
                            .setTitle("Are you sure?")
                            .setMessage("Do you want to delete this note?")
                            .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    MainActivity.removeNote(position);
                                }
                            })
                            .setNegativeButton("NO", null)
                            .show();

                    return true;
                }
            });
        }
    }
}
