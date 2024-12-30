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

public class kuttob_admin_delete extends AppCompatActivity {

    EditText bookToDelete;

    Button delete;
    private FirebaseFirestore fb;

    String bookIdToDel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kuttob_admin_delete);

        bookToDelete = findViewById(R.id.book_delete_ID);
        delete = findViewById(R.id.delete);
        fb = FirebaseFirestore.getInstance();

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteRecord();
            }
        });

    }


    //uses the inputted document id to delete the coressponding document from the database
    public void deleteRecord() {
        bookIdToDel = bookToDelete.getText().toString();
        fb.collection("books").document(bookIdToDel).delete();

        Toast.makeText(kuttob_admin_delete.this, "Book Record Deleted Sucessfully!!", Toast.LENGTH_SHORT).show();
    }
}