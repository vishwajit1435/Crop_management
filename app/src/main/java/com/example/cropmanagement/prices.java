package com.example.cropmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class prices extends AppCompatActivity {

    TextView c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14;
    Button btn;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prices);

        btn=(Button)findViewById(R.id.pricebutton);
        c1=(TextView)findViewById(R.id.crp_1);
        c2=(TextView)findViewById(R.id.crp_2);
        c3=(TextView)findViewById(R.id.crp_3);
        c4=(TextView)findViewById(R.id.crp_4);
        c5=(TextView)findViewById(R.id.crp_5);
        c6=(TextView)findViewById(R.id.crp_6);
        c7=(TextView)findViewById(R.id.crp_7);
        c8=(TextView)findViewById(R.id.crp_8);
        c9=(TextView)findViewById(R.id.crp_9);
        c10=(TextView)findViewById(R.id.crp_10);
        c11=(TextView)findViewById(R.id.crp_11);
        c12=(TextView)findViewById(R.id.crp_12);
        c13=(TextView)findViewById(R.id.crp_13);
        c14=(TextView)findViewById(R.id.crp_14);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reff = FirebaseDatabase.getInstance().getReference().child("prices");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String p1 =snapshot.child("rice").getValue().toString();
                        String p2 =snapshot.child("jowar").getValue().toString();
                        String p3 =snapshot.child("wheat").getValue().toString();
                        String p4 =snapshot.child("peas").getValue().toString();
                        String p5 =snapshot.child("mustard").getValue().toString();
                        String p6 =snapshot.child("growndunt").getValue().toString();
                        String p7 =snapshot.child("maize").getValue().toString();
                        String p8 =snapshot.child("soybean").getValue().toString();
                        String p9 =snapshot.child("Cotton").getValue().toString();
                        String p10 =snapshot.child("Corn").getValue().toString();
                        String p11 =snapshot.child("Millets").getValue().toString();
                        String p12 =snapshot.child("Bajra").getValue().toString();
                        String p13 =snapshot.child("Coffee").getValue().toString();
                        String p14 =snapshot.child("Rubber").getValue().toString();





                        c1.setText(p1);
                        c2.setText(p2);
                        c3.setText(p3);
                        c4.setText(p4);
                        c5.setText(p5);
                        c6.setText(p6);
                        c7.setText(p7);
                        c8.setText(p8);
                        c9.setText(p9);
                        c10.setText(p10);
                        c11.setText(p11);
                        c12.setText(p12);
                        c13.setText(p13);
                        c14.setText(p14);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });


    }
}