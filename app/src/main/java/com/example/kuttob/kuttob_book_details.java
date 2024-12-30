package com.example.kuttob;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

import java.util.ArrayList;
import java.util.HashMap;

public class kuttob_book_details extends AppCompatActivity {
    private FirebaseFirestore ff;
    public DatabaseReference ref;
    TextView nametv, authortv, categorytv, pagestv, pricetv;
    ImageView coverdisplay;
    String selectedDoc = GlobalData.selectedDoc;
    Integer bookCover = GlobalData.bookCover;
    RatingBar bookRating;
    Button setRating, addToCart;
    Spinner readingStatus;
    float rating;
    String status;
    Double finalTotal = GlobalData.finalTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kuttob_book_details);

        nametv = findViewById(R.id.name);
        authortv = findViewById(R.id.author);
        categorytv = findViewById(R.id.category);
        pagestv = findViewById(R.id.pages);
        pricetv = findViewById(R.id.price);
        coverdisplay = findViewById(R.id.cover);
        bookRating = findViewById(R.id.bookRating);
        setRating=findViewById(R.id.submitRating);
        addToCart=findViewById(R.id.addToCart);
        readingStatus=findViewById(R.id.readingStatus);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://kuttob-14976-default-rtdb.asia-southeast1.firebasedatabase.app/");
        ref = database.getReference();

        ff = FirebaseFirestore.getInstance();
        fetchDataFromFirestore();



        setRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rating = bookRating.getRating();
                Toast.makeText(kuttob_book_details.this, "Rating: "+rating, Toast.LENGTH_SHORT).show();
            }
        });

        readingStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                status = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(kuttob_book_details.this, "Status: "+status, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String, Object> nameprice = new HashMap<>();

                if ("0".equals(selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 8.93;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Normal People");
                    nameprice.put("Price", "8.93");
                    ref.child(ID).setValue(nameprice);
                } else if ("1".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 10.47;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Me Before You");
                    nameprice.put("Price", "10.47");
                    ref.child(ID).setValue(nameprice);
                } else if ("2".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 9.55;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Gone Girl");
                    nameprice.put("Price", "9.55");
                    ref.child(ID).setValue(nameprice);
                } else if ("3".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 9.55;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Big Little Lies");
                    nameprice.put("Price", "9.55");
                    ref.child(ID).setValue(nameprice);
                } else if ("4".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 8.49;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "The Seven Husbands Of Evelyn Hugo");
                    nameprice.put("Price", "8.49");
                    ref.child(ID).setValue(nameprice);
                } else if ("5".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 7.74;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Looking For Alaska");
                    nameprice.put("Price", "7.74");
                    ref.child(ID).setValue(nameprice);
                } else if ("6".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 9.28;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "After You");
                    nameprice.put("Price", "9.28");
                    ref.child(ID).setValue(nameprice);
                } else if ("7".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 8.80;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Six Of Crows");
                    nameprice.put("Price", "8.80");
                    ref.child(ID).setValue(nameprice);
                } else if ("8".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 9.02;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "A Court Of Thorns And Roses");
                    nameprice.put("Price", "9.02");
                    ref.child(ID).setValue(nameprice);
                } else if ("9".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 12.30;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Milk And Honey");
                    nameprice.put("Price", "12.30");
                    ref.child(ID).setValue(nameprice);
                } else if ("10".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 15.55;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Frankenstein");
                    nameprice.put("Price", "15.55");
                    ref.child(ID).setValue(nameprice);
                } else if ("11".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 9.81;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Atonement");
                    nameprice.put("Price", "9.81");
                    ref.child(ID).setValue(nameprice);

                } else if ("12".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 7.87;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Enduring Love");
                    nameprice.put("Price", "7.87");
                    ref.child(ID).setValue(nameprice);

                } else if ("13".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 11.22;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "The Brightest Star In The Sky");
                    nameprice.put("Price", "11.22");
                    ref.child(ID).setValue(nameprice);

                } else if ("14".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 9.32;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Wuthering Heights");
                    nameprice.put("Price", "9.32");
                    ref.child(ID).setValue(nameprice);

                } else if ("15".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 7.88;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "1984");
                    nameprice.put("Price", "7.88");
                    ref.child(ID).setValue(nameprice);

                } else if ("16".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 7.98;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Animal Farm");
                    nameprice.put("Price", "7.98");
                    ref.child(ID).setValue(nameprice);

                } else if ("17".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 30.91;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Harry Potter And The Philosopher's Stone");
                    nameprice.put("Price", "30.91");
                    ref.child(ID).setValue(nameprice);

                } else if ("18".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 11.05;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Fantastic Beasts And Where To Find Them");
                    nameprice.put("Price", "11.05");
                    ref.child(ID).setValue(nameprice);

                } else if ("19".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 10.52;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "A Game Of Thrones");
                    nameprice.put("Price", "10.52");
                    ref.child(ID).setValue(nameprice);

                } else if ("20".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 8.30;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Harry Potter And The Chamber Of Secrets");
                    nameprice.put("Price", "8.30");
                    ref.child(ID).setValue(nameprice);

                } else if ("21".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 9.46;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Harry Potter And The Prisoner Of Azkaban");
                    nameprice.put("Price", "9.46");
                    ref.child(ID).setValue(nameprice);

                } else if ("22".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 9.06;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "The Night Circus");
                    nameprice.put("Price", "9.06");
                    ref.child(ID).setValue(nameprice);

                } else if ("23".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 11.40;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Harry Potter And The Order Of The Pheonix");
                    nameprice.put("Price", "11.40");
                    ref.child(ID).setValue(nameprice);

                } else if ("24".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 10.75;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Harry Potter And The Goblet of Fire");
                    nameprice.put("Price", "10.75");
                    ref.child(ID).setValue(nameprice);

                } else if ("25".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 7.18;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "The Hobbit");
                    nameprice.put("Price", "7.18");
                    ref.child(ID).setValue(nameprice);

                } else if ("26".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 24.17;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "The Lord Of The Rings");
                    nameprice.put("Price", "24.17");
                    ref.child(ID).setValue(nameprice);

                } else if ("27".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 10.75;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Harry Potter And The Deathly Hallows");
                    nameprice.put("Price", "10.75");
                    ref.child(ID).setValue(nameprice);

                } else if ("28".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 7.95;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Harry Potter And The Cursed Child");
                    nameprice.put("Price", "7.95");
                    ref.child(ID).setValue(nameprice);

                } else if ("29".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 10.95;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "The Book Thief");
                    nameprice.put("Price", "10.95");
                    ref.child(ID).setValue(nameprice);

                } else if ("30".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 6.87;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Vicious");
                    nameprice.put("Price", "6.87");
                    ref.child(ID).setValue(nameprice);

                } else if ("31".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 3.74;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Dracula");
                    nameprice.put("Price", "3.74");
                    ref.child(ID).setValue(nameprice);

                } else if ("32".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 12.29;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Fahrenheit 451");
                    nameprice.put("Price", "12.29");
                    ref.child(ID).setValue(nameprice);

                } else if ("33".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 10.57;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Vengful");
                    nameprice.put("Price", "10.57");
                    ref.child(ID).setValue(nameprice);

                } else if ("34".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 6.12;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "A Wrinkle In Time");
                    nameprice.put("Price", "6.12");
                    ref.child(ID).setValue(nameprice);

                } else if ("35".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 15.06;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Miss Peregrine's Home For Peculiar Children");
                    nameprice.put("Price", "15.06");
                    ref.child(ID).setValue(nameprice);

                } else if ("36".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 6.33;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Pride And Prejudice");
                    nameprice.put("Price", "6.33");
                    ref.child(ID).setValue(nameprice);

                } else if ("37".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 14.99;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Crooked Kingdom");
                    nameprice.put("Price", "14.99");
                    ref.child(ID).setValue(nameprice);

                } else if ("38".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 7.26;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "StormBreaker");
                    nameprice.put("Price", "7.26");
                    ref.child(ID).setValue(nameprice);

                } else if ("39".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 14.27;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Caraval");
                    nameprice.put("Price", "14.27");
                    ref.child(ID).setValue(nameprice);

                } else if ("40".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 7.48;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Falling Kingdoms");
                    nameprice.put("Price", "7.48");
                    ref.child(ID).setValue(nameprice);

                } else if ("41".equals(GlobalData.selectedDoc)) {
                    Double currentTotal = GlobalData.getFinalTotal();
                    currentTotal += 6.96;
                    GlobalData.setFinalTotal(currentTotal);
                    String ID = ref.push().getKey();
                    nameprice.put("Book_Name", "Bridge To Terebithia");
                    nameprice.put("Price", "6.96");
                    ref.child(ID).setValue(nameprice);

                }

                Toast.makeText(kuttob_book_details.this, "Added to cart!", Toast.LENGTH_LONG).show();
            }
        });

        ArrayList<String> readingStatuses= new ArrayList<>();
        readingStatuses.add(" ");
        readingStatuses.add("To Read");
        readingStatuses.add("Currently Reading");
        readingStatuses.add("Finished Reading");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(kuttob_book_details.this, android.R.layout.simple_spinner_item, readingStatuses);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        readingStatus.setAdapter(adapter);
    }
    public void fetchDataFromFirestore() {
        DocumentReference document=ff.collection("books").document(GlobalData.selectedDoc);
        document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()) {
                            coverdisplay.setImageResource(bookCover);
                            nametv.setText(documentSnapshot.getString("name"));
                            authortv.setText("Author: "+documentSnapshot.getString("author"));
                            categorytv.setText("Category: "+documentSnapshot.getString("category"));
                            pagestv.setText("Pages: "+documentSnapshot.getString("pages"));
                            pricetv.setText("Price: "+"$"+(documentSnapshot.getDouble("price")).toString());
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
}
