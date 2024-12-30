package com.example.kuttob;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //define all UI elements
    ImageButton r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, t1, t2, t3, t4, t5, t6, t7, t8;

    Button exit, cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Initialize UI elements
        r1= findViewById(R.id.normalpeople);
        r2=findViewById(R.id.mebeforeyou);
        r3=findViewById(R.id.gonegirl);
        r4=findViewById(R.id.biglittlelies);
        r5=findViewById(R.id.evelynhugo);
        r6=findViewById(R.id.lookingforalaska);
        r7=findViewById(R.id.afteryou);
        r8=findViewById(R.id.sixofcrows);
        r9=findViewById(R.id.courtroses);
        r10=findViewById(R.id.milkandhoney);
        r11=findViewById(R.id.frankenstein);
        r12=findViewById(R.id.atonement);
        r13=findViewById(R.id.enduringlove);
        r14=findViewById(R.id.brighteststar);
        r15=findViewById(R.id.wutheringheights);

        s1= findViewById(R.id.go1984);
        s2=findViewById(R.id.animalfarm);
        s3=findViewById(R.id.hpphilosepherstone);
        s4=findViewById(R.id.fantasticbeasts);
        s5=findViewById(R.id.gameofthrones);
        s6=findViewById(R.id.hpchamberofsecrets);
        s7=findViewById(R.id.hpprisoner);
        s8=findViewById(R.id.nightcircus);
        s9=findViewById(R.id.hporder);
        s10=findViewById(R.id.hpgobletoffire);
        s11=findViewById(R.id.hobbit);
        s12=findViewById(R.id.lordofrings);
        s13=findViewById(R.id.hpdeathlyhollows);
        s14=findViewById(R.id.hpcursedchild);
        s15=findViewById(R.id.thebookthief);
        s16=findViewById(R.id.vicious);
        s17=findViewById(R.id.dracula);
        s18=findViewById(R.id.fahrenhiet451);
        s19=findViewById(R.id.vengful);

        t1= findViewById(R.id.awrinkleintime);
        t2=findViewById(R.id.missperegrines);
        t3=findViewById(R.id.prideandpredujice);
        t4=findViewById(R.id.crookedkingdom);
        t5=findViewById(R.id.stormbreaker);
        t6=findViewById(R.id.caraval);
        t7=findViewById(R.id.fallenkingdoms);
        t8=findViewById(R.id.bridgetoterebithia);

        exit = findViewById(R.id.exit);
        cart = findViewById(R.id.cart);
        //Ext button to exit the application on click
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
        //cart button which will shoft to the kuttob_cart activity to display books added to cart
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, kuttob_cart.class);
                startActivity(intent);
            }
        });

    }

    //code to handle display of all book covers when the corresponding button is pressed in the dashboard
    public void handleSelection(View view) {

        if(r1.isPressed()) {
            GlobalData.selectedDoc = "0";
            GlobalData.bookCover=R.drawable.r1;
        } else if (r2.isPressed()) {
            GlobalData.selectedDoc = "1";
            GlobalData.bookCover=R.drawable.r2;
        } else if (r3.isPressed()) {
            GlobalData.selectedDoc="2";
            GlobalData.bookCover=R.drawable.r3;
        } else if (r4.isPressed()) {
            GlobalData.selectedDoc="3";
            GlobalData.bookCover=R.drawable.r4;
        } else if (r5.isPressed()) {
            GlobalData.selectedDoc="4";
            GlobalData.bookCover=R.drawable.r5;
        } else if (r6.isPressed()) {
            GlobalData.selectedDoc="5";
            GlobalData.bookCover=R.drawable.r6;
        } else if (r7.isPressed()) {
            GlobalData.selectedDoc="6";
            GlobalData.bookCover=R.drawable.r7;
        } else if (r8.isPressed()) {
            GlobalData.selectedDoc="7";
            GlobalData.bookCover=R.drawable.r8;
        } else if (r9.isPressed()) {
            GlobalData.selectedDoc="8";
            GlobalData.bookCover=R.drawable.r9;
        } else if (r10.isPressed()) {
            GlobalData.selectedDoc="9";
            GlobalData.bookCover=R.drawable.r10;
        } else if (r11.isPressed()) {
            GlobalData.selectedDoc="10";
            GlobalData.bookCover=R.drawable.r11;
        } else if (r12.isPressed()) {
            GlobalData.selectedDoc="11";
            GlobalData.bookCover=R.drawable.r12;
        } else if (r13.isPressed()) {
            GlobalData.selectedDoc="12";
            GlobalData.bookCover=R.drawable.r13;
        } else if (r14.isPressed()) {
            GlobalData.selectedDoc="13";
            GlobalData.bookCover=R.drawable.r14;
        } else if (r15.isPressed()) {
            GlobalData.selectedDoc="14";
            GlobalData.bookCover=R.drawable.r15;
        } else if (s1.isPressed()) {
            GlobalData.selectedDoc="15";
            GlobalData.bookCover=R.drawable.s1;
        } else if (s2.isPressed()) {
            GlobalData.selectedDoc="16";
            GlobalData.bookCover=R.drawable.s2;
        } else if (s3.isPressed()) {
            GlobalData.selectedDoc="17";
            GlobalData.bookCover=R.drawable.s3;
        } else if (s4.isPressed()) {
            GlobalData.selectedDoc="18";
            GlobalData.bookCover=R.drawable.s4;
        } else if (s5.isPressed()) {
            GlobalData.selectedDoc="19";
            GlobalData.bookCover=R.drawable.s5;
        } else if (s6.isPressed()) {
            GlobalData.selectedDoc="20";
            GlobalData.bookCover=R.drawable.s6;
        } else if (s7.isPressed()) {
            GlobalData.selectedDoc="21";
            GlobalData.bookCover=R.drawable.s7;
        } else if (s8.isPressed()) {
            GlobalData.selectedDoc="22";
            GlobalData.bookCover=R.drawable.s8;
        } else if (s9.isPressed()) {
            GlobalData.selectedDoc="23";
            GlobalData.bookCover=R.drawable.s9;
        } else if (s10.isPressed()) {
            GlobalData.selectedDoc="24";
            GlobalData.bookCover=R.drawable.s10;
        } else if (s11.isPressed()) {
            GlobalData.selectedDoc="25";
            GlobalData.bookCover=R.drawable.s11;
        } else if (s12.isPressed()) {
            GlobalData.selectedDoc="26";
            GlobalData.bookCover=R.drawable.s12;
        } else if (s13.isPressed()) {
            GlobalData.selectedDoc="27";
            GlobalData.bookCover=R.drawable.s13;
        } else if (s14.isPressed()) {
            GlobalData.selectedDoc="28";
            GlobalData.bookCover=R.drawable.s14;
        } else if (s15.isPressed()) {
            GlobalData.selectedDoc="29";
            GlobalData.bookCover=R.drawable.s15;
        } else if (s16.isPressed()) {
            GlobalData.selectedDoc="30";
            GlobalData.bookCover=R.drawable.s16;
        } else if (s17.isPressed()) {
            GlobalData.selectedDoc="31";
            GlobalData.bookCover=R.drawable.s17;
        } else if (s18.isPressed()) {
            GlobalData.selectedDoc="32";
            GlobalData.bookCover=R.drawable.s18;
        } else if (s19.isPressed()) {
            GlobalData.selectedDoc="33";
            GlobalData.bookCover=R.drawable.s19;
        } else if (t1.isPressed()) {
            GlobalData.selectedDoc="34";
            GlobalData.bookCover=R.drawable.t1;
        } else if (t2.isPressed()) {
            GlobalData.selectedDoc="35";
            GlobalData.bookCover=R.drawable.t2;
        } else if (t3.isPressed()) {
            GlobalData.selectedDoc="36";
            GlobalData.bookCover=R.drawable.t3;
        } else if (t4.isPressed()) {
            GlobalData.selectedDoc="37";
            GlobalData.bookCover=R.drawable.t4;
        } else if (t5.isPressed()) {
            GlobalData.selectedDoc="38";
            GlobalData.bookCover=R.drawable.t5;
        } else if (t6.isPressed()) {
            GlobalData.selectedDoc="39";
            GlobalData.bookCover=R.drawable.t6;
        } else if (t7.isPressed()) {
            GlobalData.selectedDoc="40";
            GlobalData.bookCover=R.drawable.t7;
        } else if (t8.isPressed()) {
            GlobalData.selectedDoc="41";
            GlobalData.bookCover=R.drawable.t8;
        }
        //when a book is clicked, the user is redirected to this page to view all book details based on the image button they clicked.
        Intent bookView=new Intent(MainActivity.this, kuttob_book_details.class);
        startActivity(bookView);
    }
}