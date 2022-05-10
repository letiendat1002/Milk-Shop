package com.example.milkshop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toolbar;

import com.example.milkshop.R;

public class SuaBotActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_bot);

        addControls();
    }
    private void addControls(){
        toolbar= findViewById(R.id.toolbar);
        recyclerView = findViewById((R.id.recycleview_suabot));
    }
}