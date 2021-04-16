package com.example.dmobapp;

import com.google.android.gms.maps.model.LatLng;

public class Salles {

    private String nom;
    private String adresse;
    private String tel;
    private LatLng position;
    Double latitude;
    Double longitude;


    public Salles() {
    }



    public Salles(String nom, String adresse, String tel, Double latitude, Double longitude ) {
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
        this.latitude = latitude;
        this.longitude = longitude;

    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    //    public LatLng getPosition() {
//        return position;
//    }
//
//    public void setPosition(LatLng position) {
//        this.position = position;
//    }
}