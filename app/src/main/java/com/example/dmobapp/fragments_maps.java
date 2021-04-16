//package com.example.dmobapp;
//
//import android.os.Bundle;
//
//import androidx.fragment.app.Fragment;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//
//
//public class fragments_maps extends Fragment implements OnMapReadyCallback {
//    GoogleMap gMap;
//
//
//    public fragments_maps() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_maps, null, false);
//        SupportMapFragment supportMapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.google_map);
//        supportMapFragment.getMapAsync(this);
//
//
//        return view;
//    }
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        gMap = googleMap;
//        LatLng salle1 = new LatLng(46.19670193715442,6.129966127145971);
//        gMap.addMarker(new MarkerOptions().position(salle1).title("Queue d'arve"));
//        gMap.moveCamera(CameraUpdateFactory.newLatLng(salle1));
//    }
//}