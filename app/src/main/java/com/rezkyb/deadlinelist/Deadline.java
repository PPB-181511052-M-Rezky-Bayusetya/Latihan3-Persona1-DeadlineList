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

    public static ArrayList<Deadline> createDeadlineList(int numDeadline) {
        ArrayList<Deadline> deadlineArrayList = new ArrayList<Deadline>();

        deadlineArrayList.add(new Deadline("PPB1","Tugas Recycler View","2 Maret 2020"));
        deadlineArrayList.add(new Deadline("Proyek 4","Sprint 2","3 Maret 2020"));
        deadlineArrayList.add(new Deadline("PPL1","Tugas Refactor","5 Maret 2020"));


        return deadlineArrayList;
    }
}

