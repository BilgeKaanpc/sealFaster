package com.bilge.sealfasters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class nickSet extends AppCompatActivity {
    TextView nickname;
    private FirebaseFirestore score;
    private FirebaseAuth auth;
    private FirebaseUser user;
    String mail;
    ImageView save;
    String documant;
    int boll;
    String nicks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nick_set);
        nickname = findViewById(R.id.nickText);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        score = FirebaseFirestore.getInstance();
        mail = user.getEmail();
        documant = mail + "Kashikoi";
        save= findViewById(R.id.savebutton);


    }
    public void save(View view) {

        boll = 0;

        nicks = nickname.getText().toString();

        score.collection("userDatas")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot getter : task.getResult()) {
                                Map<String, Object> geldi = getter.getData();
                                String nickget = (String) geldi.get("nick");
                                if (nickget.matches(nicks)) {
                                    boll = 1;
                                }
                                if (boll == 0) {

                                    String recor = "999:999";
                                    long lvl = 1;
                                    if (nicks.matches("")) {
                                        Toast.makeText(nickSet.this, "Please enter your nickname", Toast.LENGTH_LONG).show();
                                    } else {
                                        save.setVisibility(View.INVISIBLE);
                                        Toast.makeText(nickSet.this, "Please wait", Toast.LENGTH_LONG).show();
                                        HashMap<String, Object> nick = new HashMap<>();
                                        nick.put("nick", nicks);
                                        nick.put("mail", mail);
                                        nick.put("best", recor);
                                        nick.put("Level", lvl);

                                        score.collection("userDatas").document(documant).set(nick).addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Intent intent = new Intent(nickSet.this, menu.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(nickSet.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
                                            }
                                        });

                                    }
                                }else{
                                    Toast.makeText(nickSet.this,"this nick has been taken before",Toast.LENGTH_SHORT).show();
                                }


                            }
                        }
                    }
                });



    }
}