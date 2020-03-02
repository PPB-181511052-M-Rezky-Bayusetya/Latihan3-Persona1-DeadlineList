package com.rezkyb.deadlinelist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainFragment extends Fragment {
    ArrayList<Deadline> deadlines;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_fragment, container, false);
        RecyclerView rvDeadline = view.findViewById(R.id.rvDeadline);

        deadlines = Deadline.createDeadlineList(2);

        DeadlineAdapter adapter = new DeadlineAdapter(deadlines);

        LinearLayoutManager layoutmanager = new LinearLayoutManager(this.getActivity().getBaseContext());
        rvDeadline.setAdapter(adapter);
        rvDeadline.setLayoutManager(layoutmanager);
        rvDeadline.setHasFixedSize(true);



        // Inflate the layout for this fragment
        return view;
    }

}
