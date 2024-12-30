package com.example.kuttob;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class kuttob_splash extends AppCompatActivity {
    Handler splash;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kuttob_splash);
        splash=new Handler();
        pb= (ProgressBar) findViewById(R.id.pb1);
        pb.setMax(100);
        pb.setProgress(0);
        //code to run the progress bar
        Thread progress = new Thread() {
            @Override
            public void run() {
                try {
                    for (int i=0; i < 100; i++ ) {
                        pb.setProgress(i);
                        sleep(20);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Intent intentprogress = new Intent(getApplicationContext(), kuttob_login.class);
                    startActivity(intentprogress);
                    finish();
                }

            }
        };
        progress.start();

        //code for splash screen
        splash.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashh = new Intent(kuttob_splash.this, kuttob_login.class);
                startActivity(splashh);
            }
        }, 4000);

    }
}