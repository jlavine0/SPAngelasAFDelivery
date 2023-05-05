package com.example.aafdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import com.google.android.material.snackbar.Snackbar;
import androidx.annotation.NonNull;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.activity.result.ActivityResultLauncher;

import androidx.core.app.ActivityCompat;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.aafdapp.databinding.ActivitySodaMenuBinding;


public class SodaMenu extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    private LocationManager service;
    private String provider;
    private Location location;
    private Criteria criteria;
    private double latitude = 42.114, longitude = 17.2913;

    private int minutesOnTimer;

    private AppBarConfiguration appBarConfiguration;
    private ActivitySodaMenuBinding binding;

    private View snackbarLayout;

    private static final int PERMISSION_REQUEST_LOCATION = 0;

    private static final int CAMERA_ID = 0;

    MediaRecorder recorder;
    SurfaceHolder holder;
    boolean recording = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_soda_menu);
        snackbarLayout = findViewById(R.id.soda_layout);


        Button btn = (Button) findViewById(R.id.order);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amISafe();
            }
        });
    }

    private ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    Snackbar.make(snackbarLayout, R.string.location_permission_granted, Snackbar.LENGTH_SHORT).show();

                } else {
                    Snackbar.make(snackbarLayout, R.string.location_permission_denied, Snackbar.LENGTH_SHORT).show();

                }
            });

    private void locateMe() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            Snackbar.make(snackbarLayout, R.string.location_permission_available, Snackbar.LENGTH_SHORT).show();

            service = (LocationManager) getSystemService(LOCATION_SERVICE);
            criteria = new Criteria();
            provider = service.getBestProvider(criteria, false);
            location = service.getLastKnownLocation(provider);

            if (location != null){
                latitude = location.getLatitude();
                longitude = location.getLongitude();

            } else {
                Snackbar.make(snackbarLayout, R.string.location_unavailable, Snackbar.LENGTH_SHORT).show();

            }

        } else {
            requestLocationPermission();

        }
    }

    private void requestLocationPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            Snackbar.make(snackbarLayout, R.string.location_access_required, Snackbar.LENGTH_INDEFINITE).setAction(R.string.ok, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ActivityCompat.requestPermissions(SodaMenu.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_LOCATION);
                }
            }).show();
        } else {
            Snackbar.make(snackbarLayout, R.string.location_unavailable, Snackbar.LENGTH_SHORT).show();

            ActivityCompat.requestPermissions(SodaMenu.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_LOCATION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_LOCATION) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Snackbar.make(snackbarLayout, R.string.location_permission_granted, Snackbar.LENGTH_SHORT).show();

            } else {
                Snackbar.make(snackbarLayout, R.string.location_permission_denied, Snackbar.LENGTH_SHORT).show();

            }
        }
    }

    private void amISafe() {

        locateMe();

        String ordered = "Order sent!";

        Snackbar.make(snackbarLayout, ordered, Snackbar.LENGTH_LONG).show();

    }
}
