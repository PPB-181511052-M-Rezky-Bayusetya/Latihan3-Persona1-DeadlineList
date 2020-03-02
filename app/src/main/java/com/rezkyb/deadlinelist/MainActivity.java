package com.rezkyb.deadlinelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Deadline> deadlines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvDeadline = (RecyclerView)findViewById(R.id.rvDeadline);

        deadlines = Deadline.createDeadlineList(2);

        DeadlineAdapter adapter = new DeadlineAdapter(deadlines);

        rvDeadline.setAdapter(adapter);
        rvDeadline.setLayoutManager(new LinearLayoutManager(this));


    }
}
