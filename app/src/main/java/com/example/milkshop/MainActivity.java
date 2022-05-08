package com.example.milkshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.example.milkshop.adapter.LoaiSpAdapter;
import com.example.milkshop.model.activity.LoaiSp;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerViewHome;
    NavigationView navigationView;
    ListView listViewHome;
    LoaiSpAdapter loaiSpAdapter;
    List<LoaiSp> mangloaisp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls() {
        toolbar = findViewById(R.id.toolbarhome);
        recyclerViewHome = findViewById(R.id.recycleview);
        navigationView = findViewById(R.id.navigationview);
        listViewHome = findViewById(R.id.listviewhome);


        //khoi tao adapter
        loaiSpAdapter = new LoaiSpAdapter(getApplicationContext(),mangloaisp);
        listViewHome.setAdapter(loaiSpAdapter);
    }

    private void addEvents() {
    }
}