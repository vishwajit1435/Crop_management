package com.example.cropmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mpage extends AppCompatActivity {


    Button productlink_mpage,prices_mpage,crpinfo_mpage,video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpage);

        productlink_mpage=findViewById(R.id.productlink);
        prices_mpage=findViewById(R.id.prices);
        crpinfo_mpage=findViewById(R.id.crp_info);
        video=findViewById(R.id.videos);

        productlink_mpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),productlinks.class));
            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),videos.class));
            }
        });

        prices_mpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),prices.class));
            }
        });

        crpinfo_mpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),crpinfo.class));
            }
        });

    }
}