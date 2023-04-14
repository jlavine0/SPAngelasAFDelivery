package com.example.aafdapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.aafdapp.databinding.ActivityAlcoholMenuBinding;

public class AlcoholMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_alcohol_menu);

        Button btn = (Button)findViewById(R.id.beer);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AlcoholMenu.this, BeerMenu.class));
            }
        });

        Button btn2 = (Button)findViewById(R.id.wine);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AlcoholMenu.this, WineMenu.class));
            }
        });

        Button btn3 = (Button)findViewById(R.id.hardLiquor);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AlcoholMenu.this, HardLiquorMenu.class));
            }
        });
    }
}