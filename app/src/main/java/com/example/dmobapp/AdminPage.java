package com.example.dmobapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminPage extends AppCompatActivity {

    RecyclerView recyclerView;
    adaperAdmin adapter;
    FloatingActionButton fbAdd, fbOut;
    Button buttonRemove, buttonCall;
    private EditText editTextRemove;
    FirebaseAuth firebaseAuth;
    private ArrayList<Salles> dataHolderAdmin;
    private DatabaseReference myref;

    public AdminPage() {
        // Required empty public constructor
//        this.dataHolderAdmin = dataHolderAdmin;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        recyclerView = findViewById(R.id.recyclerAmin);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataHolderAdmin = new ArrayList<>();
        myref = FirebaseDatabase.getInstance().getReference();
        Query query = myref.child("Salles");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    Salles salles = new Salles();

                    salles.setNom(snapshot1.child("Nom").getValue().toString());
                    salles.setAdresse(snapshot1.child("Adresse").getValue().toString());
                    salles.setTel(snapshot1.child("Tel").getValue().toString());
//                    salles.setLongitude(snapshot1.child("Longitude").getValue().toString());
//                    salles.setLatitude(snapshot1.child("Latitude").getValue().toString());

                    dataHolderAdmin.add(salles);
                }
                recyclerView.setAdapter(new adaperAdmin(dataHolderAdmin));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        fbAdd = (FloatingActionButton) findViewById(R.id.floatingAddButton);
        fbAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ajouterSalle.class);
                startActivity(i);
            }
        });


        fbOut = (FloatingActionButton) findViewById(R.id.btnOut);
        fbOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });



    }


    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        adapter.startListening();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        adapter.stopListening();
//    }

//}