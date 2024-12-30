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

public class kuttob_admin_update extends AppCompatActivity {

    Map<String, Object> book = new HashMap<>();

    private FirebaseFirestore fb;
    EditText book_retrieveID, bprice;
    TextView bname, bauthor, bcategory, bpages;
    Button update, retrieve;
    String bookret;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kuttob_admin_update);

        fb = FirebaseFirestore.getInstance();

        book_retrieveID = findViewById(R.id.book_retrieve_ID);
        bname = findViewById(R.id.name2);
        bauthor = findViewById(R.id.author2);
        bcategory = findViewById(R.id.category2);
        bpages = findViewById(R.id.pages2);
        bprice = findViewById(R.id.price2);
        update = findViewById(R.id.update2);
        retrieve = findViewById(R.id.retbook);



        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrieveData();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priceUpdate();
            }
        });

    }

    //fetches the book information based on the typed document id
    public void RetrieveData() {
        bookret = book_retrieveID.getText().toString();
        DocumentReference document=fb.collection("books").document(bookret);
        document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()) {
                            bname.setText(documentSnapshot.getString("name"));
                            bauthor.setText("Author: "+documentSnapshot.getString("author"));
                            bcategory.setText("Category: "+documentSnapshot.getString("category"));
                            bpages.setText("Pages: "+documentSnapshot.getString("pages"));

                        } else {
                            Toast.makeText(getApplicationContext(), "Book Data Unavailable", Toast.LENGTH_LONG).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Failed to fetch book data", Toast.LENGTH_LONG).show();
                    }
                });

    }


    //updates the price of that retrieved book based on the value the admin inputs into the field
    public void priceUpdate() {

        String updatedPrice = bprice.getText().toString();

        fb.collection("books").document(bookret).update("price", updatedPrice);

        Toast.makeText(kuttob_admin_update.this, "Price Updated Sucessfully!", Toast.LENGTH_SHORT).show();
    }

}
