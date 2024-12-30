package com.example.kuttob;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class kuttob_login extends AppCompatActivity {

    //define UI elements
    EditText logmail, logpassword;
    Button log, redirect;
    FirebaseAuth kAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kuttob_login);
        //create instance of firebase
        kAuth = FirebaseAuth.getInstance();
        //initialize all ui elements
        logmail=findViewById(R.id.logemail);
        logpassword=findViewById(R.id.logpassword);
        log=findViewById(R.id.login);
        redirect=findViewById(R.id.alreadyreg);
        //whe login button is clicked, trigger the method loginuserAccount()
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUserAccount();
            }
        });
        //when the not registered button is clicked, the user is redirected to the registration ui to register
        redirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent redirectt=new Intent(kuttob_login.this, kuttob_register.class);
                startActivity(redirectt);
            }
        });
    }


    public void loginUserAccount() {
        //define variables and get tect from edit text fields
        String ema, pas;
        ema = logmail.getText().toString();
        pas = logpassword.getText().toString();
// validations for input email and password
        if (TextUtils.isEmpty(ema)) {
            Toast.makeText(getApplicationContext(),
                            "Plesase enter email!!",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (TextUtils.isEmpty(pas)) {
            Toast.makeText(getApplicationContext(),
                            "Please enter password!!",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }

        kAuth.signInWithEmailAndPassword(ema, pas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //if the user logs in with the admin email then they are redirected to the admin page and a toast message is displayed
                if("admin@gmail.com".equals(ema)) {
                    Toast.makeText(kuttob_login.this, "Admin Login Sucessfull", Toast.LENGTH_SHORT).show();
                    Intent adminintent = new Intent(kuttob_login.this, kuttob_admin.class);
                    startActivity(adminintent);
                }
                //if user logs in with normal credentials then they are directed to the dashboard and a toast message is displayed
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),
                                    "Login Sucessfull - Welcome To Kuttob",
                                    Toast.LENGTH_LONG)
                            .show();
                    Intent loginintent = new Intent(kuttob_login.this,
                            MainActivity.class);
                    startActivity(loginintent);
                } else {
                    Toast.makeText(kuttob_login.this, "Login Failed - Please try Again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}