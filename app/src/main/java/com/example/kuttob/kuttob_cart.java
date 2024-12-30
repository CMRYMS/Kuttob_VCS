package com.example.kuttob;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class kuttob_cart extends AppCompatActivity {

    private RecyclerView recView;

    private List<kuttob_cart_display> kuttob_cart_displayList = new ArrayList<>();

    public DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kuttob_cart);

        recView = findViewById(R.id.recView);

        recView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://kuttob-14976-default-rtdb.asia-southeast1.firebasedatabase.app/");
        ref = database.getReference();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    kuttob_cart_displayList.clear();
                    for (DataSnapshot snapshot1 : snapshot.getChildren()){
                        kuttob_cart_display cart_displays = snapshot1.getValue(kuttob_cart_display.class);
                        kuttob_cart_displayList.add(cart_displays);
                    }

                    recView.setAdapter(new kuttob_cartDisplay_Adapter(getApplicationContext(), kuttob_cart_displayList));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        showMessage("Total", "Total is: "+GlobalData.getFinalTotal());

    }

    public void showMessage(String title, String mes) {
        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setCancelable(true);
        ad.setTitle(title);
        ad.setMessage(mes);
        ad.show();
    }
}