/* Angela's Alcohol and Food Delivery Service
*  Authors:
*           Josh Lavine
*           Angela Lazarro
*           Kyla Leary
* */

package com.example.aafdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        Button btn = findViewById(R.id.food);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FoodMenu.class));
            }
        });

        Button btn2 = findViewById(R.id.drink);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DrinkMenu.class));
            }
        });
    }
}