package com.raghav.android.notez;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vighnesh on 16-08-2018.
 */

public class NotesList {
    public static NotesList mNoteList ;
    public List<Note> Notes;

    private NotesList(){
        Notes = new ArrayList<>();
        for(int i=0;i<50;i++){
            Notes.add(new Note());
        }
    }
    public static NotesList get(){
        if(mNoteList == null){
            mNoteList = new NotesList();
        }
        return mNoteList;
    }
    public List<Note> getNotes() {
        return Notes;
    }

}
