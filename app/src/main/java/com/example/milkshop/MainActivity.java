package com.example.milkshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewHome;
    NavigationView navigationView;
    ListView listViewHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls() {
        toolbar = findViewById(R.id.toolbarhome);
        viewFlipper = findViewById(R.id.viewFlipper);
        recyclerViewHome = findViewById(R.id.recycleview);
        navigationView = findViewById(R.id.navigationview);
        listViewHome = findViewById(R.id.listviewhome);
    }

    private void addEvents() {
    }
}