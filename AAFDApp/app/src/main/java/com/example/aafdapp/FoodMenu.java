package com.example.aafdapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.aafdapp.databinding.ActivityFoodMenuBinding;

public class FoodMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_food_menu);

        Button btn = (Button)findViewById(R.id.pickup);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodMenu.this, PickupMenu.class));
            }
        });

        Button btn2 = (Button)findViewById(R.id.delivery);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phNum = "18025354634";

                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:" + phNum));

                startActivity(call);
            }
        });
    }
}