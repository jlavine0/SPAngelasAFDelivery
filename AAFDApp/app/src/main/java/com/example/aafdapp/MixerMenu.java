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

import com.example.aafdapp.databinding.ActivityMixerMenuBinding;

public class MixerMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mixer_menu);


        Button btn = (Button)findViewById(R.id.tonicH2O);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MixerMenu.this, TonicMenu.class));
            }
        });

        Button btn2 = (Button)findViewById(R.id.soda);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MixerMenu.this, SodaMenu.class));
            }
        });
        Button btn3 = (Button)findViewById(R.id.redBull);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MixerMenu.this, RedBullMenu.class));
            }
        });
    }
}