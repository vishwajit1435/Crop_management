package com.example.cropmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;

public class crpinfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crpinfo);


        findViewById(R.id.crop1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(crpinfo.this, crop1.class));
            }
        });

        findViewById(R.id.crop2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(crpinfo.this, crop2.class));
            }
        });

        findViewById(R.id.crop3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(crpinfo.this, crop3.class));
            }
        });

        findViewById(R.id.crop4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(crpinfo.this, crop4.class));
            }
        });

        findViewById(R.id.crop5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(crpinfo.this, crop5.class));
            }
        });

        findViewById(R.id.crop6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(crpinfo.this, crop6.class));
            }
        });

        findViewById(R.id.crop7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(crpinfo.this, crop7.class));
            }
        });

        findViewById(R.id.crop8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(crpinfo.this, crop8.class));
            }
        });
    }
}