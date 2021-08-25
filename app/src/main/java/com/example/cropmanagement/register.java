package com.example.cropmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {

    EditText fullname_r,email_r,password_r,phone_r;
    Button register_r;
    TextView loginhere_r;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullname_r=findViewById(R.id.fullnameR);
        email_r=findViewById(R.id.emailR);
        password_r=findViewById(R.id.passwordR);
        phone_r=findViewById(R.id.phonenumberR);
        register_r=findViewById(R.id.buttonR);
        loginhere_r=findViewById(R.id.loginhereR);

        fAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);

        if(fAuth.getCurrentUser() !=null)
        {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        register_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=email_r.getText().toString().trim();
                String password=password_r.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    email_r.setError("Email is required !!");
                    return;
                }

                if(TextUtils.isEmpty(password))
                {
                    password_r.setError("Please enter password ");
                    return;
                }

                if(password.length() < 6)
                {
                    password_r.setError("password must be >6 character");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(register.this, "user created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Mpage.class));
                        }
                        else
                        {
                            Toast.makeText(register.this, "error ! "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        loginhere_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),login.class));
            }
        });
    }
}