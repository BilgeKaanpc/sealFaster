package com.bilge.sealfasters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class list extends AppCompatActivity {

    private FirebaseFirestore db;
    private FirebaseAuth auth;
    private FirebaseUser user;
    adapter radaptor;

    ArrayList<String> bestDb;
    ArrayList<String> nickDb;

    String sıralama;



    RecyclerView rv;

    CollectionReference sayi;

    int what;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adViewsset);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        user = auth.getCurrentUser();


        bestDb = new ArrayList<>();
        nickDb = new ArrayList<>();



        for(int t = 0 ; t<1 ; t++) {

            getData();

        }

        radaptor = new adapter(bestDb,nickDb);

        rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(radaptor);


        sayi = db.collection("userDatas");
        sayi.get();

    }
    public void getData(){


        db.collection("userDatas")
                .orderBy("best",Query.Direction.ASCENDING)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot getter : task.getResult()){
                                Map<String,Object> geldi = getter.getData();
                                sıralama = (String) geldi.get("best");
                                String nick = (String) geldi.get("nick");


                                if (sıralama.matches("999:999")) {
                                    sıralama = "not played";
                                }
                                    bestDb.add(sıralama);
                                    nickDb.add(nick);
                                    radaptor.notifyDataSetChanged();

                            }
                        }
                    }
                });






    }

}
