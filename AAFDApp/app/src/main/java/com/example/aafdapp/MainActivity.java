package com.example.aafdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void food(View view)
    {

    }


    public void drink(View view)
    { Toast test=Toast.makeText (this, "someone pressed the drink button", Toast.LENGTH_LONG);

    }
}