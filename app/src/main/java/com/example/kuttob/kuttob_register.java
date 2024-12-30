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

public class kuttob_register extends AppCompatActivity {

    //define all UI elements including the firebase
    EditText email, pass;
    Button reg, clear;
    FirebaseAuth kAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kuttob_register);
        //create an instance of the firebase database
        kAuth= FirebaseAuth.getInstance();
        //initialize UI elements
        email=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        reg=findViewById(R.id.register);
        clear = findViewById(R.id.clearcont);
        //registration button, when clicked, run the method registernewuser()
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerNewUser();
            }
        });
        //clear button to erase all text within the edit text fields
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email.setText(" ");
                pass.setText(" ");
            }
        });

    }
    private void registerNewUser() {
        //initialize the text fields
        String em, pas;
        em=email.getText().toString();
        pas=pass.getText().toString();
        //if fields are empty, display toast messages
        if (TextUtils.isEmpty(em)) {
            Toast.makeText(getApplicationContext(), "Please Enter E-Mail", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(pas)) {
            Toast.makeText(getApplicationContext(), "Please Enter Password", Toast.LENGTH_LONG).show();
            return;
        }
        //method that handles firebase user creation with the email and password entered
        kAuth.createUserWithEmailAndPassword(em, pas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //if email and password are in the acceptable format, display a toast message and redirect user to login page
                if(task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Registration Complete!",Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(kuttob_register.this, kuttob_login.class);

                    startActivity(intent);
                }
                else {
                    //if registration is not accepted, display toast message.
                    Toast.makeText(getApplicationContext(),"Registration Incomplete - Please Try Again Later", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}