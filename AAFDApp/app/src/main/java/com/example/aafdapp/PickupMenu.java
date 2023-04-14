package com.example.aafdapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.aafdapp.databinding.ActivityPickupMenuBinding;

public class PickupMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup_menu);

        Button btn = (Button)findViewById(R.id.buildYourOwn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PickupMenu.this, BuildYourOwnMenu.class));
            }
        });

        Button btn2 = (Button)findViewById(R.id.specialtyPizza);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PickupMenu.this, SpecialtyMenu.class));
            }
        });
    }
}