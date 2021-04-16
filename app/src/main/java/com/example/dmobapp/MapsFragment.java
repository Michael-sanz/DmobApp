package com.example.dmobapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

public class MapsFragment extends Fragment implements OnMapReadyCallback{
    GoogleMap gMap;
    ArrayList<LatLng> listePosition = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps,container,false);
        SupportMapFragment supportMapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this::onMapReady);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.gMap = googleMap;
        DatabaseReference maref;
        maref = FirebaseDatabase.getInstance().getReference().child("Salles");
        maref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()){
//                    String nom = snapshot1.child("Nom").getValue().toString(); pour ajouter le nom faire un HaspMap<String nom, Double Latlng>
                    double longitude = snapshot1.child("Longitude").getValue(Double.class);
                    double latitude = snapshot1.child("Latitude").getValue(Double.class);
                    LatLng ll = new LatLng(longitude,latitude);
                    listePosition.add(ll);
                }
                for (int i=0 ; i<listePosition.size();i++){
                    gMap.addMarker(new MarkerOptions().position(listePosition.get(i)));
                    gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(listePosition.get(i),12.0f));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}