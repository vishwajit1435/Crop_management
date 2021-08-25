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


public class login extends AppCompatActivity {

    EditText email_l,password_l;
    Button login_l;
    TextView loginhere_l;
    ProgressBar progressBar_1;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email_l=findViewById(R.id.emailL);
        password_l=findViewById(R.id.passwordL);
        login_l=findViewById(R.id.buttonL);
        loginhere_l=findViewById(R.id.loginhereL);
        progressBar_1=findViewById(R.id.progressBar1);
        fAuth=FirebaseAuth.getInstance();

        login_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=email_l.getText().toString().trim();
                String password=password_l.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    email_l.setError("Email is required !!");
                    return;
                }

                if(TextUtils.isEmpty(password))
                {
                    password_l.setError("Please enter password ");
                    return;
                }

                if(password.length() < 6)
                {
                    password_l.setError("password must be >6 character");
                    return;
                }
                progressBar_1.setVisibility(View.VISIBLE);
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful())
                        {
                            Toast.makeText(login.this, "logged in successfully.", Toast.LENGTH_SHORT).show();
                            progressBar_1.setVisibility(View.INVISIBLE);
                            startActivity(new Intent(getApplicationContext(),Mpage.class));
                        }
                        else
                        {
                            Toast.makeText(login.this, "error ! "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar_1.setVisibility(View.INVISIBLE);
                        }

                    }
                });
            }
        });

        loginhere_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),register.class));
            }
        });

    }
}