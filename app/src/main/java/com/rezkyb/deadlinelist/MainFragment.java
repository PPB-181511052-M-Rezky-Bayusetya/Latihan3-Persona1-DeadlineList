package com.rezkyb.deadlinelist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.rezkyb.deadlinelist.MainActivity.*;

public class MainFragment extends Fragment {
    public ArrayList<Deadline> deadlines;
    public DeadlineAdapter adapter;
    private Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public ArrayList<Deadline> createDeadlineList() {
        context = getActivity();
        DatabaseAdapter db = new DatabaseAdapter(context);
        String Nama;
        String Details;
        String Date;

        db.open();
        Cursor c = db.getAllData();
        if(c.moveToFirst()){
            do{
                Nama=c.getString(1);
                Details=c.getString(2);
                Date=c.getString(3);
                deadlineArrayList.add(new Deadline(Nama,Details,Date));
            }while (c.moveToNext());
        }
        return deadlineArrayList;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_fragment, container, false);
        RecyclerView rvDeadline = view.findViewById(R.id.rvDeadline);

        deadlines = createDeadlineList();

        adapter = new DeadlineAdapter(deadlines);

        LinearLayoutManager layoutmanager = new LinearLayoutManager(this.getActivity().getBaseContext());
        rvDeadline.setAdapter(adapter);
        rvDeadline.setLayoutManager(layoutmanager);
        rvDeadline.setHasFixedSize(true);

        // Inflate the layout for this fragment
        return view;

    }
}