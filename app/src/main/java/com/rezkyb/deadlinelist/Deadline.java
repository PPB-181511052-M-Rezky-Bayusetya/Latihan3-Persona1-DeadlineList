package com.rezkyb.deadlinelist;

import java.util.ArrayList;

public class Deadline {
    private String mDeadlineName;
    private String mDeadlineDetails;
    private String mDeadlineDate;

    public Deadline(String name, String details, String date) {
        mDeadlineName = name;
        mDeadlineDetails = details;
        mDeadlineDate = date;
    }

    public String getName() {
        return mDeadlineName;
    }

    public String getDetails() {
        return mDeadlineDetails;
    }

    public String getDate() {
        return mDeadlineDate;
    }
}

