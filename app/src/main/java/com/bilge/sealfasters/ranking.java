package com.bilge.sealfasters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.google.firebase.firestore.Transaction;
import com.google.firebase.firestore.WriteBatch;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ranking extends AppCompatActivity {

    private AdView mAdView;
    private FirebaseFirestore score;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private
    TextView timer;
    TextView best;

    ImageView se1;
    ImageView se2;
    ImageView se3;
    ImageView se4;
    ImageView se5;
    ImageView se6;
    ImageView se7;
    ImageView se8;
    ImageView se9;
    ImageView se10;
    ImageView se11;
    ImageView se12;
    ImageView[] imageArray;
    String bestScore;
    WriteBatch batch;

    Handler handler;
    Runnable runnable;
    Handler handlery;
    Runnable runnabley;

    String idm;

    MediaPlayer mediaPlayer1;
    MediaPlayer mediaPlayer2;
    MediaPlayer mediaPlayer3;
    MediaPlayer mediaPlayer4;
    MediaPlayer mediaPlayer5;
    MediaPlayer mediaPlayer6;
    MediaPlayer mediaPlayer7;
    MediaPlayer mediaPlayer8;
    MediaPlayer mediaPlayer9;
    MediaPlayer mediaPlayer10;
    MediaPlayer mediaPlayer11;
    MediaPlayer mediaPlayer12;

    int x;
    int y;
    int i;
    int tahmin;
    String sure;
    String userMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adViewss);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        auth = FirebaseAuth.getInstance();
        score = FirebaseFirestore.getInstance();
        user = auth.getCurrentUser();

        timer = findViewById(R.id.timer);
        best = findViewById(R.id.bestTime);

        idm = user.getEmail() + "Kashikoi";

        batch = score.batch();

        userMail = user.getEmail();

        mediaPlayer1 = MediaPlayer.create(getApplicationContext(), R.raw.sound);
        mediaPlayer2 = MediaPlayer.create(getApplicationContext(), R.raw.sound);
        mediaPlayer3 = MediaPlayer.create(getApplicationContext(), R.raw.sound);
        mediaPlayer4 = MediaPlayer.create(getApplicationContext(), R.raw.sound);
        mediaPlayer5 = MediaPlayer.create(getApplicationContext(), R.raw.sound);
        mediaPlayer6 = MediaPlayer.create(getApplicationContext(), R.raw.sound);
        mediaPlayer7 = MediaPlayer.create(getApplicationContext(), R.raw.sound);
        mediaPlayer8 = MediaPlayer.create(getApplicationContext(), R.raw.sound);
        mediaPlayer9 = MediaPlayer.create(getApplicationContext(), R.raw.sound);
        mediaPlayer10 = MediaPlayer.create(getApplicationContext(), R.raw.sound);
        mediaPlayer11 = MediaPlayer.create(getApplicationContext(), R.raw.sound);
        mediaPlayer12 = MediaPlayer.create(getApplicationContext(), R.raw.sound);


        x = 00;
        y = 00;

        se1 = findViewById(R.id.seal1);
        se2 = findViewById(R.id.seal2);
        se3 = findViewById(R.id.seal3);
        se4 = findViewById(R.id.seal4);
        se5 = findViewById(R.id.seal5);
        se6 = findViewById(R.id.seal6);
        se7 = findViewById(R.id.seal7);
        se8 = findViewById(R.id.seal8);
        se9 = findViewById(R.id.seal9);
        se10 = findViewById(R.id.seal10);
        se11 = findViewById(R.id.seal11);
        se12 = findViewById(R.id.seal12);

        imageArray = new ImageView[] {se1,se2,se3,se4,se5,se6,se7,se8,se9,se10,se11,se12};
        sakla();

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                y=y+9;
                handler.postDelayed(runnable,100);

                if(y==90){
                    x=x+1;
                    y=00;
                }
                String ilk = Integer.toString(x);
                String iki = Integer.toString(y);
                if(y==1){
                    iki="01";
                }
                if(y==2){
                    iki="02";
                }
                if(y==3){
                    iki="03";
                }
                if(y==4){
                    iki="04";
                }
                if(y==5){
                    iki="05";
                }
                if(y==6){
                    iki="06";
                }
                if(y==7){
                    iki="07";
                }
                if(y==8){
                    iki="08";
                }
                if(y==9){
                    iki="09";
                }
                if(x==1){
                    ilk="01";
                }
                if(x==2){
                    ilk="02";
                }
                if(x==3){
                    ilk="03";
                }
                if(x==4){
                    ilk="04";
                }
                if(x==5){
                    ilk="05";
                }
                if(x==6){
                    ilk="06";
                }
                if(x==7){
                    ilk="07";
                }
                if(x==8){
                    ilk="08";
                }
                if(x==9){
                    ilk="09";
                }

                sure = ilk + ":" + iki;
                timer.setText(sure);
            }
        };
        handler.post(runnable);

        i = 0;
        tahmin = 0;
        Random random = new Random();
        int kac = random.nextInt(12);
        imageArray[kac].setVisibility(View.VISIBLE);
        tahmin = kac;




        getData();



    }
    public void getData(){
        userMail = (String) user.getEmail();
        CollectionReference dataReferance = score.collection("userDatas");
        dataReferance.whereEqualTo("mail",userMail).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error != null){
                    Toast.makeText(ranking.this,error.getLocalizedMessage().toString(),Toast.LENGTH_SHORT).show();
                }
                if(value != null){
                    for(DocumentSnapshot snap : value.getDocuments()){
                        Map<String,Object> datalar = snap.getData();
                        bestScore = (String) datalar.get("best");


                    }
                    if(bestScore.matches("999:999")){
                        best.setText("Best : 00:00");
                    }else {
                        best.setText("Best : " + bestScore);
                    }
                }
            }
        });
    }
    public void sakla(){
        for(ImageView image : imageArray){
            image.setVisibility(View.INVISIBLE);
        }
    }
    public void stop(){
        handler.removeCallbacks(runnable);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Wrong Seal");
        alert.setMessage("you made the wrong seal");
        alert.setPositiveButton("Menu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ranking.this,menu.class);
                startActivity(intent);
                finish();
            }
        });
        alert.setNegativeButton("Try Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ranking.this,ranking.class);
                startActivity(intent);
                finish();
            }
        });
        alert.show();
    }
    public void s(View view){
        mediaPlayer1.start();
        if (tahmin == 0){


            imageArray[tahmin].setVisibility(View.INVISIBLE);
            Random random = new Random();
            int kac = random.nextInt(12);
            imageArray[kac].setVisibility(View.VISIBLE);
            tahmin = kac;
            i = i + 1;
            if(i == 50){
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Game's Over!");
                alert.setMessage("Time : " + timer.getText().toString());
                alert.setPositiveButton("Menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,menu.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.setNegativeButton("Play Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,ranking.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.show();
                handler.removeCallbacks(runnable);
                String hadi = timer.getText().toString();
                String [] array = hadi.split(":");
                String birinci = array[0];
                String ikinci = array[1];
                int deger = Integer.parseInt(birinci);
                int deger2 = Integer.parseInt(ikinci);

                String [] array2 = bestScore.split(":");
                String one = array2[0];
                String two = array2[1];
                int valuem = Integer.parseInt(one);
                int valuem2 = Integer.parseInt(two);



                if(deger<=valuem && deger2<valuem2){
                    final String sonuc = birinci + ":" + ikinci;
                    final DocumentReference basems = score.collection("userDatas").document(idm);
                    score.runTransaction(new Transaction.Function<Void>(){
                        @Override
                        public Void apply (Transaction transaction) throws FirebaseFirestoreException {
                            DocumentSnapshot snapshot = transaction.get(basems);
                            transaction.update(basems,"best",sonuc);

                            return null;
                        }
                    }).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });
                }



            }
        }else{
            stop();
        }
    }
    public void ss(View view){
        mediaPlayer2.start();
        if (tahmin == 1){
            imageArray[tahmin].setVisibility(View.INVISIBLE);
            Random random = new Random();
            int kac = random.nextInt(12);
            imageArray[kac].setVisibility(View.VISIBLE);
            tahmin = kac;
            i = i + 1;
            if(i == 50){
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Game's Over!");
                alert.setMessage("Time : " + timer.getText().toString());
                alert.setPositiveButton("Menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,menu.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.setNegativeButton("Play Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,ranking.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.show();
                handler.removeCallbacks(runnable);
                String hadi = timer.getText().toString();
                String [] array = hadi.split(":");
                String birinci = array[0];
                String ikinci = array[1];
                int deger = Integer.parseInt(birinci);
                int deger2 = Integer.parseInt(ikinci);

                String [] array2 = bestScore.split(":");
                String one = array2[0];
                String two = array2[1];
                int valuem = Integer.parseInt(one);
                int valuem2 = Integer.parseInt(two);



                if(deger<valuem){
                    final String sonuc = birinci + ":" + ikinci;
                    final DocumentReference basems = score.collection("userDatas").document(idm);
                    score.runTransaction(new Transaction.Function<Void>(){
                        @Override
                        public Void apply (Transaction transaction) throws FirebaseFirestoreException {
                            DocumentSnapshot snapshot = transaction.get(basems);
                            transaction.update(basems,"best",sonuc);

                            return null;
                        }
                    }).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });
                }
            }
        }else{
            stop();
        }
    }
    public void sss(View view){
        mediaPlayer3.start();
        if (tahmin == 2){
            imageArray[tahmin].setVisibility(View.INVISIBLE);
            Random random = new Random();
            int kac = random.nextInt(12);
            imageArray[kac].setVisibility(View.VISIBLE);
            tahmin = kac;
            i = i + 1;
            if(i == 50){
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Game's Over!");
                alert.setMessage("Time : " + timer.getText().toString());
                alert.setPositiveButton("Menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,menu.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.setNegativeButton("Play Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,ranking.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.show();
                handler.removeCallbacks(runnable);
                String hadi = timer.getText().toString();
                String [] array = hadi.split(":");
                String birinci = array[0];
                String ikinci = array[1];
                int deger = Integer.parseInt(birinci);
                int deger2 = Integer.parseInt(ikinci);

                String [] array2 = bestScore.split(":");
                String one = array2[0];
                String two = array2[1];
                int valuem = Integer.parseInt(one);
                int valuem2 = Integer.parseInt(two);



                if(deger<valuem){
                    final String sonuc = birinci + ":" + ikinci;
                    final DocumentReference basems = score.collection("userDatas").document(idm);
                    score.runTransaction(new Transaction.Function<Void>(){
                        @Override
                        public Void apply (Transaction transaction) throws FirebaseFirestoreException {
                            DocumentSnapshot snapshot = transaction.get(basems);
                            transaction.update(basems,"best",sonuc);

                            return null;
                        }
                    }).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });
                }
            }
        }else{
            stop();        }
    }
    public void ssss(View view){
        mediaPlayer4.start();
        if (tahmin == 3){
            imageArray[tahmin].setVisibility(View.INVISIBLE);
            Random random = new Random();
            int kac = random.nextInt(12);
            imageArray[kac].setVisibility(View.VISIBLE);
            tahmin = kac;
            i = i + 1;
            if(i == 50){
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Game's Over!");
                alert.setMessage("Time : " + timer.getText().toString());
                alert.setPositiveButton("Menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,menu.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.setNegativeButton("Play Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,ranking.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.show();
                handler.removeCallbacks(runnable);
                String hadi = timer.getText().toString();
                String [] array = hadi.split(":");
                String birinci = array[0];
                String ikinci = array[1];
                int deger = Integer.parseInt(birinci);
                int deger2 = Integer.parseInt(ikinci);

                String [] array2 = bestScore.split(":");
                String one = array2[0];
                String two = array2[1];
                int valuem = Integer.parseInt(one);
                int valuem2 = Integer.parseInt(two);



                if(deger<valuem){
                    final String sonuc = birinci + ":" + ikinci;
                    final DocumentReference basems = score.collection("userDatas").document(idm);
                    score.runTransaction(new Transaction.Function<Void>(){
                        @Override
                        public Void apply (Transaction transaction) throws FirebaseFirestoreException {
                            DocumentSnapshot snapshot = transaction.get(basems);
                            transaction.update(basems,"best",sonuc);

                            return null;
                        }
                    }).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });
                }
            }
        }else{
            stop();
        }
    }
    public void sssss(View view){
        mediaPlayer5.start();
        if (tahmin == 4){
            imageArray[tahmin].setVisibility(View.INVISIBLE);
            Random random = new Random();
            int kac = random.nextInt(12);
            imageArray[kac].setVisibility(View.VISIBLE);
            tahmin = kac;
            i = i + 1;
            if(i == 50){
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Game's Over!");
                alert.setMessage("Time : " + timer.getText().toString());
                alert.setPositiveButton("Menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,menu.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.setNegativeButton("Play Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,ranking.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.show();
                handler.removeCallbacks(runnable);
                String hadi = timer.getText().toString();
                String [] array = hadi.split(":");
                String birinci = array[0];
                String ikinci = array[1];
                int deger = Integer.parseInt(birinci);
                int deger2 = Integer.parseInt(ikinci);

                String [] array2 = bestScore.split(":");
                String one = array2[0];
                String two = array2[1];
                int valuem = Integer.parseInt(one);
                int valuem2 = Integer.parseInt(two);



                if(deger<valuem){
                    final String sonuc = birinci + ":" + ikinci;
                    final DocumentReference basems = score.collection("userDatas").document(idm);
                    score.runTransaction(new Transaction.Function<Void>(){
                        @Override
                        public Void apply (Transaction transaction) throws FirebaseFirestoreException {
                            DocumentSnapshot snapshot = transaction.get(basems);
                            transaction.update(basems,"best",sonuc);

                            return null;
                        }
                    }).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });
                }
            }
        }else{
            stop();        }
    }
    public void ssssss(View view){
        mediaPlayer6.start();
        if (tahmin == 5){
            imageArray[tahmin].setVisibility(View.INVISIBLE);
            Random random = new Random();
            int kac = random.nextInt(12);
            imageArray[kac].setVisibility(View.VISIBLE);
            tahmin = kac;
            i = i + 1;
            if(i == 50){
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Game's Over!");
                alert.setMessage("Time : " + timer.getText().toString());
                alert.setPositiveButton("Menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,menu.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.setNegativeButton("Play Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,ranking.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.show();
                handler.removeCallbacks(runnable);
                String hadi = timer.getText().toString();
                String [] array = hadi.split(":");
                String birinci = array[0];
                String ikinci = array[1];
                int deger = Integer.parseInt(birinci);
                int deger2 = Integer.parseInt(ikinci);

                String [] array2 = bestScore.split(":");
                String one = array2[0];
                String two = array2[1];
                int valuem = Integer.parseInt(one);
                int valuem2 = Integer.parseInt(two);



                if(deger<valuem){
                    final String sonuc = birinci + ":" + ikinci;
                    final DocumentReference basems = score.collection("userDatas").document(idm);
                    score.runTransaction(new Transaction.Function<Void>(){
                        @Override
                        public Void apply (Transaction transaction) throws FirebaseFirestoreException {
                            DocumentSnapshot snapshot = transaction.get(basems);
                            transaction.update(basems,"best",sonuc);

                            return null;
                        }
                    }).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });
                }
            }
        }else{
            stop();
        }
    }
    public void sssssss(View view){
        mediaPlayer7.start();
        if (tahmin == 6){
            imageArray[tahmin].setVisibility(View.INVISIBLE);
            Random random = new Random();
            int kac = random.nextInt(12);
            imageArray[kac].setVisibility(View.VISIBLE);
            tahmin = kac;
            i = i + 1;
            if(i == 50){
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Game's Over!");
                alert.setMessage("Time : " + timer.getText().toString());
                alert.setPositiveButton("Menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,menu.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.setNegativeButton("Play Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,ranking.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.show();
                handler.removeCallbacks(runnable);
                String hadi = timer.getText().toString();
                String [] array = hadi.split(":");
                String birinci = array[0];
                String ikinci = array[1];
                int deger = Integer.parseInt(birinci);
                int deger2 = Integer.parseInt(ikinci);

                String [] array2 = bestScore.split(":");
                String one = array2[0];
                String two = array2[1];
                int valuem = Integer.parseInt(one);
                int valuem2 = Integer.parseInt(two);



                if(deger<valuem){
                    final String sonuc = birinci + ":" + ikinci;
                    final DocumentReference basems = score.collection("userDatas").document(idm);
                    score.runTransaction(new Transaction.Function<Void>(){
                        @Override
                        public Void apply (Transaction transaction) throws FirebaseFirestoreException {
                            DocumentSnapshot snapshot = transaction.get(basems);
                            transaction.update(basems,"best",sonuc);

                            return null;
                        }
                    }).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });
                }
            }
        }else{
            stop();        }
    }
    public void ssssssss(View view){
        mediaPlayer8.start();
        if (tahmin == 7){
            imageArray[tahmin].setVisibility(View.INVISIBLE);
            Random random = new Random();
            int kac = random.nextInt(12);
            imageArray[kac].setVisibility(View.VISIBLE);
            tahmin = kac;
            i = i + 1;
            if(i == 50){
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Game's Over!");
                alert.setMessage("Time : " + timer.getText().toString());
                alert.setPositiveButton("Menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,menu.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.setNegativeButton("Play Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,ranking.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.show();
                handler.removeCallbacks(runnable);
                String hadi = timer.getText().toString();
                String [] array = hadi.split(":");
                String birinci = array[0];
                String ikinci = array[1];
                int deger = Integer.parseInt(birinci);
                int deger2 = Integer.parseInt(ikinci);

                String [] array2 = bestScore.split(":");
                String one = array2[0];
                String two = array2[1];
                int valuem = Integer.parseInt(one);
                int valuem2 = Integer.parseInt(two);



                if(deger<valuem){
                    final String sonuc = birinci + ":" + ikinci;
                    final DocumentReference basems = score.collection("userDatas").document(idm);
                    score.runTransaction(new Transaction.Function<Void>(){
                        @Override
                        public Void apply (Transaction transaction) throws FirebaseFirestoreException {
                            DocumentSnapshot snapshot = transaction.get(basems);
                            transaction.update(basems,"best",sonuc);

                            return null;
                        }
                    }).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });
                }
            }
        }else{
            stop();        }
    }
    public void sssssssss(View view){
        mediaPlayer9.start();
        if (tahmin == 8){
            imageArray[tahmin].setVisibility(View.INVISIBLE);
            Random random = new Random();
            int kac = random.nextInt(12);
            imageArray[kac].setVisibility(View.VISIBLE);
            tahmin = kac;
            i = i + 1;
            if(i == 50){
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Game's Over!");
                alert.setMessage("Time : " + timer.getText().toString());
                alert.setPositiveButton("Menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,menu.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.setNegativeButton("Play Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,ranking.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.show();
                handler.removeCallbacks(runnable);
                String hadi = timer.getText().toString();
                String [] array = hadi.split(":");
                String birinci = array[0];
                String ikinci = array[1];
                int deger = Integer.parseInt(birinci);
                int deger2 = Integer.parseInt(ikinci);

                String [] array2 = bestScore.split(":");
                String one = array2[0];
                String two = array2[1];
                int valuem = Integer.parseInt(one);
                int valuem2 = Integer.parseInt(two);



                if(deger<valuem){
                    final String sonuc = birinci + ":" + ikinci;
                    final DocumentReference basems = score.collection("userDatas").document(idm);
                    score.runTransaction(new Transaction.Function<Void>(){
                        @Override
                        public Void apply (Transaction transaction) throws FirebaseFirestoreException {
                            DocumentSnapshot snapshot = transaction.get(basems);
                            transaction.update(basems,"best",sonuc);

                            return null;
                        }
                    }).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });
                }
            }
        }else{
            stop();        }
    }
    public void ssssssssss(View view){
        mediaPlayer10.start();
        if (tahmin == 9){
            imageArray[tahmin].setVisibility(View.INVISIBLE);
            Random random = new Random();
            int kac = random.nextInt(12);
            imageArray[kac].setVisibility(View.VISIBLE);
            tahmin = kac;
            i = i + 1;
            if(i == 50){
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Game's Over!");
                alert.setMessage("Time : " + timer.getText().toString());
                alert.setPositiveButton("Menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,menu.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.setNegativeButton("Play Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,ranking.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.show();
                handler.removeCallbacks(runnable);
                String hadi = timer.getText().toString();
                String [] array = hadi.split(":");
                String birinci = array[0];
                String ikinci = array[1];
                int deger = Integer.parseInt(birinci);
                int deger2 = Integer.parseInt(ikinci);

                String [] array2 = bestScore.split(":");
                String one = array2[0];
                String two = array2[1];
                int valuem = Integer.parseInt(one);
                int valuem2 = Integer.parseInt(two);



                if(deger<valuem){
                    final String sonuc = birinci + ":" + ikinci;
                    final DocumentReference basems = score.collection("userDatas").document(idm);
                    score.runTransaction(new Transaction.Function<Void>(){
                        @Override
                        public Void apply (Transaction transaction) throws FirebaseFirestoreException {
                            DocumentSnapshot snapshot = transaction.get(basems);
                            transaction.update(basems,"best",sonuc);

                            return null;
                        }
                    }).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });
                }
            }
        }else{
            stop();        }
    }
    public void sssssssssss(View view){
        mediaPlayer11.start();
        if (tahmin == 10){
            imageArray[tahmin].setVisibility(View.INVISIBLE);
            Random random = new Random();
            int kac = random.nextInt(12);
            imageArray[kac].setVisibility(View.VISIBLE);
            tahmin = kac;
            i = i + 1;
            if(i == 50){
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Game's Over!");
                alert.setMessage("Time : " + timer.getText().toString());
                alert.setPositiveButton("Menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,menu.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.setNegativeButton("Play Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,ranking.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.show();
                handler.removeCallbacks(runnable);
                String hadi = timer.getText().toString();
                String [] array = hadi.split(":");
                String birinci = array[0];
                String ikinci = array[1];
                int deger = Integer.parseInt(birinci);
                int deger2 = Integer.parseInt(ikinci);

                String [] array2 = bestScore.split(":");
                String one = array2[0];
                String two = array2[1];
                int valuem = Integer.parseInt(one);
                int valuem2 = Integer.parseInt(two);



                if(deger<valuem){
                    final String sonuc = birinci + ":" + ikinci;
                    final DocumentReference basems = score.collection("userDatas").document(idm);
                    score.runTransaction(new Transaction.Function<Void>(){
                        @Override
                        public Void apply (Transaction transaction) throws FirebaseFirestoreException {
                            DocumentSnapshot snapshot = transaction.get(basems);
                            transaction.update(basems,"best",sonuc);

                            return null;
                        }
                    }).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });
                }
            }
        }else{
            stop();        }
    }
    public void ssssssssssss(View view){
        mediaPlayer12.start();
        if (tahmin == 11){
            imageArray[tahmin].setVisibility(View.INVISIBLE);
            Random random = new Random();
            int kac = random.nextInt(12);
            imageArray[kac].setVisibility(View.VISIBLE);
            tahmin = kac;
            i = i + 1;
            if(i == 50){
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Game's Over!");
                alert.setMessage("Time : " + timer.getText().toString());
                alert.setPositiveButton("Menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,menu.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.setNegativeButton("Play Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ranking.this,ranking.class);
                        startActivity(intent);
                        finish();
                    }
                });
                alert.show();
                handler.removeCallbacks(runnable);
                String hadi = timer.getText().toString();
                String [] array = hadi.split(":");
                String birinci = array[0];
                String ikinci = array[1];
                int deger = Integer.parseInt(birinci);
                int deger2 = Integer.parseInt(ikinci);

                String [] array2 = bestScore.split(":");
                String one = array2[0];
                String two = array2[1];
                int valuem = Integer.parseInt(one);
                int valuem2 = Integer.parseInt(two);



                if(deger<valuem){
                    final String sonuc = birinci + ":" + ikinci;
                    final DocumentReference basems = score.collection("userDatas").document(idm);
                    score.runTransaction(new Transaction.Function<Void>(){
                        @Override
                        public Void apply (Transaction transaction) throws FirebaseFirestoreException {
                            DocumentSnapshot snapshot = transaction.get(basems);
                            transaction.update(basems,"best",sonuc);

                            return null;
                        }
                    }).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });
                }
            }
        }else{
            stop();        }
    }



}