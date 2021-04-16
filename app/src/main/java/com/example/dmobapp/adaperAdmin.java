package com.example.dmobapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.snapshot.ChildKey;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class adaperAdmin extends RecyclerView.Adapter<adaperAdmin.myviewHolder> {

    ArrayList<Salles> dataholderAdmin;
    AdapterView.OnItemClickListener mListener;
    Context context;
    ImageView imgEdit, imgLeave;
    View v;
    private DatabaseReference myref;

    public adaperAdmin(ArrayList<Salles> sallesArrayList){
        dataholderAdmin = sallesArrayList ;
    }



//    public adaperAdmin(ArrayList<Salles> dataholderAdmin, AdapterView.OnItemClickListener listener) {
//        this.dataholderAdmin = dataholderAdmin;
//        this.mListener = listener;
//    }



    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewHolder holder, int position) {
        holder.nom.setText(dataholderAdmin.get(position).getNom());
        holder.adresse.setText(dataholderAdmin.get(position).getAdresse());
        holder.tel.setText(dataholderAdmin.get(position).getTel());
//        holder.longitude.setText(dataholderAdmin.get(position).getLongitude());
//        holder.latitude.setText(dataholderAdmin.get(position).getLatitude());

    }

    @Override
    public int getItemCount() {
        return dataholderAdmin.size();
    }




    class myviewHolder extends RecyclerView.ViewHolder{
        TextView nom,adresse,tel,longitude,latitude;
        ImageView imgLeave, imgEdit;



        public myviewHolder(@NonNull View itemView,Context context) {
            super(itemView);
            nom = (TextView) itemView.findViewById(R.id.nomText);
            adresse = (TextView) itemView.findViewById(R.id.adresseText);
            tel = (TextView) itemView.findViewById(R.id.telText);
            longitude = (TextView) itemView.findViewById(R.id.longitudeText);
            latitude = (TextView) itemView.findViewById(R.id.latitudeText);
            /// Sur les image modifier et supprimer

            imgEdit = (ImageView) itemView.findViewById(R.id.imgModifier);

            imgLeave = (ImageView) itemView.findViewById(R.id.imgSupprimer);

            imgEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    System.out.println("dsffdsdsafasdffsdafdsa");
                }
            });


        }

    }

}
