package com.rezkyb.deadlinelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment MainFragment = new MainFragment();
        fragmentTransaction.replace(
                android.R.id.content, MainFragment);

        fragmentTransaction.commit();
    }


    public void addDeadline(View view) {
        startActivity(new Intent("com.rezkyb.deadlinelist.AddDeadlineActivity"));
    }

}
