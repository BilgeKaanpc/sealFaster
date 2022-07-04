package com.bilge.sealfasters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class menu extends AppCompatActivity {
    private FirebaseAuth user;
    private AdView mAdView;
    private FirebaseFirestore data;
    private FirebaseUser users;
    HashMap<String, Object> hashMap;
    String mailUser;


    //ca-app-pub-1056663813267203~8300837286   Kimlik
    //ca-app-pub-1056663813267203/8983008343   Reklam Birimi

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adViews);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        user = FirebaseAuth.getInstance();
        data = FirebaseFirestore.getInstance();
        users = user.getCurrentUser();



    }


    public void play(View view){

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService (Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        if (activeNetwork != null) {
            // internet var ise
            Intent intent = new Intent(menu.this,play.class);
            startActivity(intent);
        } else {
            // eğer internet yok ise
            Toast.makeText(getApplicationContext(), "Could not connect to the internet", Toast.LENGTH_SHORT).show();


        }


    }
    public void ranking(View view){

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService (Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        if (activeNetwork != null) {
            // internet var ise
            Intent intent = new Intent(menu.this, ranking.class);
            startActivity(intent);
        } else {
            // eğer internet yok ise
            Toast.makeText(getApplicationContext(), "Could not connect to the internet", Toast.LENGTH_SHORT).show();


        }

    }
    public void list(View view){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService (Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        if (activeNetwork != null) {
            // internet var ise
            Intent intent = new Intent(menu.this,list.class);
            startActivity(intent);
        } else {
            // eğer internet yok ise
            Toast.makeText(getApplicationContext(), "Could not connect to the internet", Toast.LENGTH_SHORT).show();


        }

    }
    public void signout(View view){

        user.signOut();
        Intent intent = new Intent(menu.this,MainActivity.class);
        startActivity(intent);
        finish();

    }

}