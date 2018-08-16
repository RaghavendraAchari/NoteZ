package com.raghav.android.notez;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Vighnesh on 16-08-2018.
 */

public class Note {
    private UUID id;
    private String mTitle;
    private Date mDate;
    private String mContent;

    public Note(){
        id = UUID.randomUUID();
        mDate = new Date();
        mTitle = mContent = null;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
