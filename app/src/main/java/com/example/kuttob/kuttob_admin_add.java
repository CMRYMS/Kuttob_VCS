package com.example.kuttob;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.HashMap;
import java.util.Map;

public class kuttob_admin_add extends AppCompatActivity {

    Map<String, Object> book = new HashMap<>();
    private FirebaseFirestore fb;
    EditText bname, bauthor, bcategory, bpages, bprice;
    Button add, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kuttob_admin_add);

        bname = findViewById(R.id.name1);
        bauthor = findViewById(R.id.author1);
        bcategory = findViewById(R.id.category1);
        bpages = findViewById(R.id.pages1);
        bprice = findViewById(R.id.price1);
        add = findViewById(R.id.add2);
        clear = findViewById(R.id.clearcont2);

        fb = FirebaseFirestore.getInstance();
        //when add button is clicked, addData() method is triggered
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddData();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bname.setText(" ");
                bauthor.setText(" ");
                bcategory.setText(" ");
                bpages.setText(" ");
                bprice.setText(" ");
            }
        });

    }

    //the add data method will use the defined hashmap to insert the inputted admin fields into the firestore and displays a toast message on completion
    public void AddData() {
        book.put("name", bname.getText().toString());
        book.put("author", bauthor.getText().toString());
        book.put("category", bcategory.getText().toString());
        book.put("pages", bpages.getText().toString());
        book.put("price", bprice.getText().toString());

        fb.collection("books").add(book);
        Toast.makeText(kuttob_admin_add.this, "Book Added Sucessfully!", Toast.LENGTH_LONG).show();

    }
}