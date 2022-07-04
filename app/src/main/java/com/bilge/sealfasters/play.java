package com.bilge.sealfasters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
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

import java.util.Map;
import java.util.Random;

public class play extends AppCompatActivity {

    ImageView horse00,boar00,tiger00,dragon00,ram00,hare00,snake00,rat00,dog00,monkey00,ox00,bird00;
    ImageView horse10,boar10,tiger10,dragon10,ram10,hare10,snake10,rat10,dog10,monkey10,ox10,bird10;
    ImageView horse20,boar20,tiger20,dragon20,ram20,hare20,snake20,rat20,dog20,monkey20,ox20,bird20;
    ImageView horse30,boar30,tiger30,dragon30,ram30,hare30,snake30,rat30,dog30,monkey30,ox30,bird30;
    ImageView horse40,boar40,tiger40,dragon40,ram40,hare40,snake40,rat40,dog40,monkey40,ox40,bird40;
    ImageView horse50,boar50,tiger50,dragon50,ram50,hare50,snake50,rat50,dog50,monkey50,ox50,bird50;
    ImageView horse01,boar01,tiger01,dragon01,ram01,hare01,snake01,rat01,dog01,monkey01,ox01,bird01;
    ImageView horse11,boar11,tiger11,dragon11,ram11,hare11,snake11,rat11,dog11,monkey11,ox11,bird11;
    ImageView horse21,boar21,tiger21,dragon21,ram21,hare21,snake21,rat21,dog21,monkey21,ox21,bird21;
    ImageView horse31,boar31,tiger31,dragon31,ram31,hare31,snake31,rat31,dog31,monkey31,ox31,bird31;
    ImageView horse41,boar41,tiger41,dragon41,ram41,hare41,snake41,rat41,dog41,monkey41,ox41,bird41;
    ImageView horse51,boar51,tiger51,dragon51,ram51,hare51,snake51,rat51,dog51,monkey51,ox51,bird51;

    ImageView [] array00;
    ImageView [] array10;
    ImageView [] array20;
    ImageView [] array30;
    ImageView [] array40;
    ImageView [] array50;
    ImageView [] array01;
    ImageView [] array11;
    ImageView [] array21;
    ImageView [] array31;
    ImageView [] array41;
    ImageView [] array51;


    CountDownTimer kalan;

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
    MediaPlayer finish;

    String sifre;
    String sonuc;

    private FirebaseAuth auth;
    private FirebaseFirestore score;
    private FirebaseUser user;

    String userMail;
    long bestScore;
    TextView seviye;

    ImageView finishButton;

    TextView times;

    int how;

    private AdView mAdView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adViews);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        finishButton = findViewById(R.id.finishButton);


        seviye = findViewById(R.id.lvlText);

        auth = FirebaseAuth.getInstance();
        score = FirebaseFirestore.getInstance();
        user = auth.getCurrentUser();

        System.out.println("1deneme");
        idm = user.getEmail() + "Kashikoi";




        horse00 = findViewById(R.id.horse00);
        boar00 = findViewById(R.id.boar00);
        tiger00 = findViewById(R.id.tiger00);
        dragon00 = findViewById(R.id.dragon00);
        ram00 = findViewById(R.id.ram00);
        hare00 = findViewById(R.id.hare00);
        snake00 = findViewById(R.id.snake00);
        rat00 = findViewById(R.id.rat00);
        dog00 = findViewById(R.id.dog00);
        monkey00 = findViewById(R.id.monkey00);
        ox00 = findViewById(R.id.ox00);
        bird00 = findViewById(R.id.bird00);

        horse10 = findViewById(R.id.horse10);
        boar10 = findViewById(R.id.boar10);
        tiger10 = findViewById(R.id.tiger10);
        dragon10 = findViewById(R.id.dragon10);
        ram10 = findViewById(R.id.ram10);
        hare10 = findViewById(R.id.hare10);
        snake10 = findViewById(R.id.snake10);
        rat10 = findViewById(R.id.rat10);
        dog10 = findViewById(R.id.dog10);
        monkey10 = findViewById(R.id.monkey10);
        ox10 = findViewById(R.id.ox10);
        bird10 = findViewById(R.id.bird10);

        horse20 = findViewById(R.id.horse20);
        boar20 = findViewById(R.id.boar20);
        tiger20 = findViewById(R.id.tiger20);
        dragon20 = findViewById(R.id.dragon20);
        ram20 = findViewById(R.id.ram20);
        hare20 = findViewById(R.id.hare20);
        snake20 = findViewById(R.id.snake20);
        rat20 = findViewById(R.id.rat20);
        dog20 = findViewById(R.id.dog20);
        monkey20 = findViewById(R.id.monkey20);
        ox20 = findViewById(R.id.ox20);
        bird20 = findViewById(R.id.bird20);

        horse30 = findViewById(R.id.horse30);
        boar30 = findViewById(R.id.boar30);
        tiger30 = findViewById(R.id.tiger30);
        dragon30 = findViewById(R.id.dragon30);
        ram30 = findViewById(R.id.ram30);
        hare30 = findViewById(R.id.hare30);
        snake30 = findViewById(R.id.snake30);
        rat30 = findViewById(R.id.rat30);
        dog30 = findViewById(R.id.dog30);
        monkey30 = findViewById(R.id.monkey30);
        ox30 = findViewById(R.id.ox30);
        bird30 = findViewById(R.id.bird30);

        horse40 = findViewById(R.id.horse40);
        boar40 = findViewById(R.id.boar40);
        tiger40 = findViewById(R.id.tiger40);
        dragon40 = findViewById(R.id.dragon40);
        ram40 = findViewById(R.id.ram40);
        hare40 = findViewById(R.id.hare40);
        snake40 = findViewById(R.id.snake40);
        rat40 = findViewById(R.id.rat40);
        dog40 = findViewById(R.id.dog40);
        monkey40 = findViewById(R.id.monkey40);
        ox40 = findViewById(R.id.ox40);
        bird40 = findViewById(R.id.bird40);

        horse50 = findViewById(R.id.horse50);
        boar50 = findViewById(R.id.boar50);
        tiger50 = findViewById(R.id.tiger50);
        dragon50 = findViewById(R.id.dragon50);
        ram50 = findViewById(R.id.ram50);
        hare50 = findViewById(R.id.hare50);
        snake50 = findViewById(R.id.snake50);
        rat50 = findViewById(R.id.rat50);
        dog50 = findViewById(R.id.dog50);
        monkey50 = findViewById(R.id.monkey50);
        ox50 = findViewById(R.id.ox50);
        bird50 = findViewById(R.id.bird50);

        horse01 = findViewById(R.id.horse01);
        boar01 = findViewById(R.id.boar01);
        tiger01 = findViewById(R.id.tiger01);
        dragon01 = findViewById(R.id.dragon01);
        ram01 = findViewById(R.id.ram01);
        hare01 = findViewById(R.id.hare01);
        snake01 = findViewById(R.id.snake01);
        rat01 = findViewById(R.id.rat01);
        dog01 = findViewById(R.id.dog01);
        monkey01 = findViewById(R.id.monkey01);
        ox01 = findViewById(R.id.ox01);
        bird01 = findViewById(R.id.bird01);

        horse11 = findViewById(R.id.horse11);
        boar11 = findViewById(R.id.boar11);
        tiger11 = findViewById(R.id.tiger11);
        dragon11 = findViewById(R.id.dragon11);
        ram11 = findViewById(R.id.ram11);
        hare11 = findViewById(R.id.hare11);
        snake11 = findViewById(R.id.snake11);
        rat11 = findViewById(R.id.rat11);
        dog11 = findViewById(R.id.dog11);
        monkey11 = findViewById(R.id.monkey11);
        ox11 = findViewById(R.id.ox11);
        bird11 = findViewById(R.id.bird11);

        horse21 = findViewById(R.id.horse21);
        boar21 = findViewById(R.id.boar21);
        tiger21 = findViewById(R.id.tiger21);
        dragon21 = findViewById(R.id.dragon21);
        ram21 = findViewById(R.id.ram21);
        hare21 = findViewById(R.id.hare21);
        snake21 = findViewById(R.id.snake21);
        rat21 = findViewById(R.id.rat21);
        dog21 = findViewById(R.id.dog21);
        monkey21 = findViewById(R.id.monkey21);
        ox21 = findViewById(R.id.ox21);
        bird21 = findViewById(R.id.bird21);

        horse31 = findViewById(R.id.horse31);
        boar31 = findViewById(R.id.boar31);
        tiger31 = findViewById(R.id.tiger31);
        dragon31 = findViewById(R.id.dragon31);
        ram31 = findViewById(R.id.ram31);
        hare31 = findViewById(R.id.hare31);
        snake31 = findViewById(R.id.snake31);
        rat31 = findViewById(R.id.rat31);
        dog31 = findViewById(R.id.dog31);
        monkey31 = findViewById(R.id.monkey31);
        ox31 = findViewById(R.id.ox31);
        bird31 = findViewById(R.id.bird31);

        horse41 = findViewById(R.id.horse41);
        boar41 = findViewById(R.id.boar41);
        tiger41 = findViewById(R.id.tiger41);
        dragon41 = findViewById(R.id.dragon41);
        ram41 = findViewById(R.id.ram41);
        hare41 = findViewById(R.id.hare41);
        snake41 = findViewById(R.id.snake41);
        rat41 = findViewById(R.id.rat41);
        dog41 = findViewById(R.id.dog41);
        monkey41 = findViewById(R.id.monkey41);
        ox41 = findViewById(R.id.ox41);
        bird41 = findViewById(R.id.bird41);

        horse51 = findViewById(R.id.horse51);
        boar51 = findViewById(R.id.boar51);
        tiger51 = findViewById(R.id.tiger51);
        dragon51 = findViewById(R.id.dragon51);
        ram51 = findViewById(R.id.ram51);
        hare51 = findViewById(R.id.hare51);
        snake51 = findViewById(R.id.snake51);
        rat51 = findViewById(R.id.rat51);
        dog51 = findViewById(R.id.dog51);
        monkey51 = findViewById(R.id.monkey51);
        ox51 = findViewById(R.id.ox51);
        bird51 = findViewById(R.id.bird51);


        array00= new ImageView[] {horse00,boar00,tiger00,dragon00,ram00,hare00,snake00,rat00,dog00,monkey00,ox00,bird00};
        array10= new ImageView[] {horse10,boar10,tiger10,dragon10,ram10,hare10,snake10,rat10,dog10,monkey10,ox10,bird10};
        array20= new ImageView[] {horse20,boar20,tiger20,dragon20,ram20,hare20,snake20,rat20,dog20,monkey20,ox20,bird20};
        array30= new ImageView[] {horse30,boar30,tiger30,dragon30,ram30,hare30,snake30,rat30,dog30,monkey30,ox30,bird30};
        array40= new ImageView[] {horse40,boar40,tiger40,dragon40,ram40,hare40,snake40,rat40,dog40,monkey40,ox40,bird40};
        array50= new ImageView[] {horse50,boar50,tiger50,dragon50,ram50,hare50,snake50,rat50,dog50,monkey50,ox50,bird50};
        array01= new ImageView[] {horse01,boar01,tiger01,dragon01,ram01,hare01,snake01,rat01,dog01,monkey01,ox01,bird01};
        array11= new ImageView[] {horse11,boar11,tiger11,dragon11,ram11,hare11,snake11,rat11,dog11,monkey11,ox11,bird11};
        array21= new ImageView[] {horse21,boar21,tiger21,dragon21,ram21,hare21,snake21,rat21,dog21,monkey21,ox21,bird21};
        array31= new ImageView[] {horse31,boar31,tiger31,dragon31,ram31,hare31,snake31,rat31,dog31,monkey31,ox31,bird31};
        array41= new ImageView[] {horse41,boar41,tiger41,dragon41,ram41,hare41,snake41,rat41,dog41,monkey41,ox41,bird41};
        array51= new ImageView[] {horse51,boar51,tiger51,dragon51,ram51,hare51,snake51,rat51,dog51,monkey51,ox51,bird51};


        sifre = "";
        sonuc = "";


        times = findViewById(R.id.time);

        getdatas();




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
        finish = MediaPlayer.create(getApplicationContext(),R.raw.finish);
    }

    public void getdatas(){
        DocumentReference datam = score.collection("userDatas").document(idm);
        datam.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot documan = task.getResult();

                        Map<String,Object> lastData = documan.getData();
                        bestScore = (Long) lastData.get("Level");
                        seviye.setText("Level : " + bestScore);
                    if( bestScore == 1){

                        how = 10000;
                        times.setText(""+how/1000);

                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);

                        array20[one].setVisibility(View.VISIBLE);
                        array30[two].setVisibility(View.VISIBLE);

                        sifre = one +","+two+",";
                    }
                    else if( bestScore == 2){

                        how = 9000;
                        times.setText(""+how/1000);

                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);

                        array20[one].setVisibility(View.VISIBLE);
                        array30[two].setVisibility(View.VISIBLE);

                        sifre = one +","+two+",";
                    }
                    else if( bestScore == 3){

                        how = 7000;
                        times.setText(""+how/1000);

                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);

                        array20[one].setVisibility(View.VISIBLE);
                        array30[two].setVisibility(View.VISIBLE);

                        sifre = one +","+two+",";
                    }
                    else if( bestScore == 4){

                        how = 6000;
                        times.setText(""+how/1000);

                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);

                        array20[one].setVisibility(View.VISIBLE);
                        array30[two].setVisibility(View.VISIBLE);

                        sifre = one +","+two+",";
                    }
                    else if( bestScore == 5){
                        how = 4000;
                        times.setText(""+how/1000);

                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);

                        array20[one].setVisibility(View.VISIBLE);
                        array30[two].setVisibility(View.VISIBLE);

                        sifre = one +","+two+",";
                    }
                    else if( bestScore == 6){
                        how = 4000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);

                        array20[one].setVisibility(View.VISIBLE);
                        array30[two].setVisibility(View.VISIBLE);

                        sifre = one +","+two+",";
                    }
                    else if( bestScore == 7){
                        how = 15000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 8){
                        how = 14000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 9){
                        how = 13000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 10){
                        how = 12000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 11){
                        how = 11000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 12){
                        how = 10000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 13){
                        how = 9000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 14){
                        how = 9000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 15){
                        how = 8000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 16){
                        how = 8000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 17){
                        how = 7000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 18){
                        how = 7000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }

                    else if( bestScore == 19){
                        how = 6000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 20){
                        how = 6000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 21){
                        how = 6000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 22){
                        how = 5000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 23){
                        how = 5000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 24){
                        how = 5000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 25){
                        how = 5000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 26){
                        how = 5000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 27){
                        how = 4000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 28){
                        how = 4000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 29){
                        how = 4000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 30){
                        how = 3000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);

                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ",";
                    }
                    else if( bestScore == 31){
                        how = 40000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ",";
                    }
                    else if( bestScore == 32){
                        how = 35000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ",";
                    }
                    else if( bestScore == 33){
                        how = 30000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ",";
                    }
                    else if( bestScore == 34){
                        how = 30000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ",";
                    }
                    else if( bestScore == 35){
                        how = 27000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ",";
                    }
                    else if( bestScore == 36){
                        how = 26000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ",";
                    }
                    else if( bestScore == 37){
                        how = 25000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ",";
                    }
                    else if( bestScore == 38){
                        how = 24000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ",";
                    }
                    else if( bestScore == 39){
                        how = 23000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ",";
                    }
                    else if( bestScore == 40){
                        how = 20000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ",";
                    }
                    else if( bestScore == 41){
                        how = 15000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ",";
                    }
                    else if( bestScore == 42){
                        how = 10000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ",";
                    }
                    else if( bestScore == 43){
                        how = 8000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ",";
                    }
                    else if( bestScore == 44){
                        how = 8000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ",";
                    }
                    else if( bestScore == 45){
                        how = 7000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ",";
                    }
                    else if( bestScore == 46){
                        how = 6000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ",";
                    }
                    else if( bestScore == 47){
                        how = 6000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ",";
                    }
                    else if( bestScore == 48){
                        how = 6000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ",";
                    }
                    else if( bestScore == 49){
                        how = 5000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ",";
                    }
                    else if( bestScore == 50){
                        how = 30000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }

                    else if( bestScore == 51){
                        how = 25000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }

                    else if( bestScore == 52){
                        how = 25000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }

                    else if( bestScore == 53){
                        how = 20000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }

                    else if( bestScore == 54){
                        how = 20000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }

                    else if( bestScore == 55){
                        how = 15000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }

                    else if( bestScore == 56){
                        how = 15000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }

                    else if( bestScore == 57){
                        how = 10000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }

                    else if( bestScore == 58){
                        how = 10000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }

                    else if( bestScore == 59){
                        how = 10000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }
                    else if( bestScore == 60){
                        how = 10000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }
                    else if( bestScore == 61){
                        how = 10000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }
                    else if( bestScore == 62){
                        how = 10000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }
                    else if( bestScore == 63){
                        how = 10000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }
                    else if( bestScore == 64){
                        how = 9000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }
                    else if( bestScore == 65){
                        how = 9000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }
                    else if( bestScore == 66){
                        how = 9000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }
                    else if( bestScore == 67){
                        how = 8000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }
                    else if( bestScore == 68){
                        how = 8000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }
                    else if( bestScore == 69){
                        how = 7000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }
                    else if( bestScore == 70){
                        how = 7000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }
                    else if( bestScore == 71){
                        how = 7000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }
                    else if( bestScore == 72){
                        how = 7000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }
                    else if( bestScore == 73){
                        how = 7000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }
                    else if( bestScore == 74){
                        how = 6000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }
                    else if( bestScore == 75){
                        how = 5000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);


                        array10[one].setVisibility(View.VISIBLE);
                        array20[two].setVisibility(View.VISIBLE);
                        array30[three].setVisibility(View.VISIBLE);
                        array40[four].setVisibility(View.VISIBLE);
                        array11[five].setVisibility(View.VISIBLE);
                        array21[six].setVisibility(View.VISIBLE);
                        array31[seven].setVisibility(View.VISIBLE);
                        array41[eight].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ",";
                    }
                    else if( bestScore == 76){
                        how = 30000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 77){
                        how = 30000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 78){
                        how = 25000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 79){
                        how = 25000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 80){
                        how = 20000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 81){
                        how = 20000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 82){
                        how = 15000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 83){
                        how = 15000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 84){
                        how = 10000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 85){
                        how = 10000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 86){
                        how = 9000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 87){
                        how = 8000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 88){
                        how = 7000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 89){
                        how = 7000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 90){
                        how = 7000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 91){
                        how = 7000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 92){
                        how = 7000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 93){
                        how = 7000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 94){
                        how = 7000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 95){
                        how = 7000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 96){
                        how = 7000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 97){
                        how = 6000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 98){
                        how = 6000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 99){
                        how = 6000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore == 100){
                        how = 5000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }
                    else if( bestScore > 100){
                        how = 5000;
                        times.setText(""+how/1000);
                        Random random = new Random();
                        int one = random.nextInt(12);
                        int two = random.nextInt(12);
                        int three = random.nextInt(12);
                        int four = random.nextInt(12);
                        int five = random.nextInt(12);
                        int six = random.nextInt(12);
                        int seven = random.nextInt(12);
                        int eight = random.nextInt(12);
                        int nine = random.nextInt(12);
                        int ten = random.nextInt(12);
                        int eleven = random.nextInt(12);
                        int twelwe = random.nextInt(12);

                        array00[one].setVisibility(View.VISIBLE);
                        array10[two].setVisibility(View.VISIBLE);
                        array20[three].setVisibility(View.VISIBLE);
                        array30[four].setVisibility(View.VISIBLE);
                        array40[five].setVisibility(View.VISIBLE);
                        array50[six].setVisibility(View.VISIBLE);
                        array01[seven].setVisibility(View.VISIBLE);
                        array11[eight].setVisibility(View.VISIBLE);
                        array21[nine].setVisibility(View.VISIBLE);
                        array31[ten].setVisibility(View.VISIBLE);
                        array41[eleven].setVisibility(View.VISIBLE);
                        array51[twelwe].setVisibility(View.VISIBLE);

                        sifre = one + "," + two + "," + three + "," + four + ","+ five + ","+ six + ","+ seven + ","+ eight + ","+ nine + ","+ ten + ","+ eleven + ","+ twelwe + ",";
                    }

                    kalan = new CountDownTimer(how,1000){

                        @Override
                        public void onTick(long millisUntilFinished) {
                            times.setText(""+millisUntilFinished/1000);
                        }

                        @Override
                        public void onFinish() {



                            AlertDialog.Builder alert = new AlertDialog.Builder(play.this);
                            alert.setTitle("Time's up!");
                            alert.setMessage("Your opponent moved faster than you.");
                            alert.setPositiveButton("Menu", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(play.this,menu.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                            alert.setNegativeButton("Try Again", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent intent = getIntent();
                                    finish();
                                    startActivity(intent);

                                }
                            });
                            try {
                                alert.show();
                            }
                            catch (WindowManager.BadTokenException e) {
                                //use a log message
                            }



                            finishButton.setVisibility(View.INVISIBLE);
                        }
                    }.start();
                    if(documan.exists()){


                    }else{
                        Toast.makeText(play.this,"Try Again",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    public void horse(View view){
        sonuc = sonuc + "0,";
        mediaPlayer1.start();
    }
    public void boar(View view){
        sonuc = sonuc + "1,";
        mediaPlayer2.start();
    }
    public void tiger(View view){
        sonuc = sonuc + "2,";
        mediaPlayer3.start();
    }
    public void dragon(View view){
        sonuc = sonuc + "3,";
        mediaPlayer4.start();
    }
    public void ram(View view){
        sonuc = sonuc + "4,";
        mediaPlayer5.start();
    }
    public void hare(View view){
        sonuc = sonuc + "5,";
        mediaPlayer6.start();
    }
    public void snake(View view){
        sonuc = sonuc + "6,";
        mediaPlayer7.start();
    }
    public void rat(View view){
        sonuc = sonuc + "7,";
        mediaPlayer8.start();
    }
    public void dog(View view){
        sonuc = sonuc + "8,";
        mediaPlayer9.start();
    }
    public void monkey(View view){
        sonuc = sonuc + "9,";
        mediaPlayer10.start();
    }
    public void ox(View view){
        sonuc = sonuc + "10,";
        mediaPlayer11.start();
    }
    public void bird(View view){
        sonuc = sonuc + "11,";
        mediaPlayer12.start();
    }



    public void onReceivedSslError(MediaPlayer view, SslErrorHandler handler, SslError error) {

        handler.proceed(); // Ignore SSL certificate errors
    }



    public void seal(View view){
        finish.start();

        if(sonuc.matches(sifre)){


            kalan.cancel();

            seviye.setVisibility(View.INVISIBLE);


            AlertDialog.Builder win = new AlertDialog.Builder(this);
            win.setTitle("Congratulations!");
            win.setMessage("You passed to the next level.");
            win.setPositiveButton("Menu", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    final DocumentReference dr = score.collection("userDatas").document(idm);
                    score.runTransaction(new Transaction.Function<Void>() {
                        @Override
                        public Void apply (Transaction tr) throws FirebaseFirestoreException{
                            DocumentSnapshot snap = tr.get(dr);
                            tr.update(dr,"Level",bestScore+1);

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

                    Intent intent = new Intent(play.this,menu.class);
                    startActivity(intent);
                    finish();
                }
            });
            win.setNegativeButton("Next", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    final DocumentReference dr = score.collection("userDatas").document(idm);
                    score.runTransaction(new Transaction.Function<Void>() {
                        @Override
                        public Void apply (Transaction tr) throws FirebaseFirestoreException{
                            DocumentSnapshot snap = tr.get(dr);
                            tr.update(dr,"Level",bestScore+1);

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

                    Intent intent = new Intent(play.this,play.class);
                    startActivity(intent);
                    finish();
                }
            });
            win.show();
        }else{

            kalan.cancel();

            AlertDialog.Builder lose = new AlertDialog.Builder(this);
            lose.setTitle("You didn't succeed");
            lose.setMessage("You made the wrong seals.");
            lose.setPositiveButton("Menu", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(play.this,menu.class);
                    startActivity(intent);
                    finish();
                }
            });
            lose.setNegativeButton("Play Again", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(play.this,play.class);
                    startActivity(intent);
                    finish();
                }
            });
            lose.show();
        }


    }

}