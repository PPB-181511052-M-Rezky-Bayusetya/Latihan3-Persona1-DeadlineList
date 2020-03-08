package com.rezkyb.deadlinelist;

import android.app.Activity;
import android.content.Intent;
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
    String NameFromIntent1;
    String DetailFromIntent1;
    String DateFromIntent1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
  }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_fragment, container, false);
        RecyclerView rvDeadline = view.findViewById(R.id.rvDeadline);

        deadlines = MainActivity.createDeadlineList();

        adapter = new DeadlineAdapter(deadlines);

        LinearLayoutManager layoutmanager = new LinearLayoutManager(this.getActivity().getBaseContext());
        rvDeadline.setAdapter(adapter);
        rvDeadline.setLayoutManager(layoutmanager);
        rvDeadline.setHasFixedSize(true);

        // Inflate the layout for this fragment
        return view;

    }
}
