package com.raghav.android.notez;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Vighnesh on 16-08-2018.
 */

public class NoteListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private NoteAdapter mNoteAdapter;


    private class NoteAdapter extends RecyclerView.Adapter<NoteHolder>{
        private List<Note> mNoteList;

        public NoteAdapter(List<Note> mNotes){
            mNoteList = mNotes;
        }

        @NonNull
        @Override
        public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new NoteHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
            Note note = mNoteList.get(position);
            holder.bind(note);
        }


        @Override
        public int getItemCount() {
            return mNoteList.size();
        }

        public void setNotes(List<Note> notes){
            mNoteList = notes;
        }
    }

    private class NoteHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitle,mDate;
        private ImageView mImage,mDeleteImage;
        private Note mNote;

        public NoteHolder(LayoutInflater inflater,ViewGroup parent){
            super(inflater.inflate(R.layout.single_list,parent,false));

            mTitle = (TextView)itemView.findViewById(R.id.note_title);
            mDate = (TextView)itemView.findViewById(R.id.note_date);
            mImage = (ImageView)itemView.findViewById(R.id.bullet_image);
            mDeleteImage = (ImageView)itemView.findViewById(R.id.delete_icon);

            itemView.setOnClickListener(this);
        }


        public void bind(Note note){
            mNote = note;
            mTitle.setText(mNote.getTitle());
            mDate.setText(mNote.getDate().toString());
        }

        @Override
        public void onClick(View v) {

        }
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recycler_view_list,container,false);

        mRecyclerView = (RecyclerView)v.findViewById(R.id.crime_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return v;
    }

    private void updateUI() {
        NotesList mNotesList = NotesList.get();
        List<Note> mNotes = mNotesList.getNotes();
        if(mNoteAdapter == null){
            mNoteAdapter = new NoteAdapter(mNotes);
            mRecyclerView.setAdapter(mNoteAdapter);
        }else {
            mNoteAdapter.setNotes(mNotes);
            mNoteAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    public static NoteListFragment newInstance(){
        return new NoteListFragment();
    }
}
