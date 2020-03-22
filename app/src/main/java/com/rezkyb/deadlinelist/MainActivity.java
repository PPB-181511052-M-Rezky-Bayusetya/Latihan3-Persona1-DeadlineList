package com.rezkyb.deadlinelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String NameFromIntent1;
    String DetailFromIntent1;
    String DateFromIntent1;
    DatabaseAdapter db = new DatabaseAdapter(this);

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    MainFragment MainFragment;

    Intent data = new Intent("com.rezkyb.deadlinelist.AddDeadlineActivity");

    static ArrayList<Deadline> deadlineArrayList = new ArrayList<Deadline>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment = new MainFragment();

        fragmentTransaction.replace(
                android.R.id.content, MainFragment);

        fragmentTransaction.commit();
    }

    public void addDeadline(View view) {
        startActivityForResult(data,1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                NameFromIntent1 = data.getStringExtra("deadlineName");
                DetailFromIntent1 = data.getStringExtra("deadlineDetail");
                DateFromIntent1 = data.getStringExtra("deadlineDate");
                Toast.makeText(this, NameFromIntent1, Toast.LENGTH_LONG).show();
                Toast.makeText(this, DetailFromIntent1, Toast.LENGTH_LONG).show();
                Toast.makeText(this, DateFromIntent1, Toast.LENGTH_LONG).show();
                db.open();
                db.insertData(NameFromIntent1,DetailFromIntent1,DateFromIntent1);
                db.close();
                deadlineArrayList.add(new Deadline(NameFromIntent1,DetailFromIntent1,DateFromIntent1));
            }
        }
        MainFragment.adapter.notifyDataSetChanged();
        super.onActivityResult(requestCode,resultCode,data);
    }
}
