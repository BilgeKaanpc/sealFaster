package com.bilge.sealfasters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth user;
    TextView mail;
    TextView password;

    ImageView log;
    ImageView reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = FirebaseAuth.getInstance();
        mail = findViewById(R.id.mailText);
        password = findViewById(R.id.passText);
        log = findViewById(R.id.loginButton);
        reg = findViewById(R.id.registerButton);


        FirebaseUser firebaseUser = user.getCurrentUser();
        if(firebaseUser != null){
            Intent intent = new Intent(MainActivity.this,menu.class);
            startActivity(intent);
            finish();
        }

    }
    public void login(View view){
        String email = mail.getText().toString();
        String sifre = password.getText().toString();
        if(email.matches("") || sifre.matches("")){
            Toast.makeText(MainActivity.this,"Please do not leave the email and password blank.",Toast.LENGTH_LONG).show();
        }else {
            log.setVisibility(View.INVISIBLE);
            Toast.makeText(MainActivity.this,"Please wait",Toast.LENGTH_LONG).show();
            user.signInWithEmailAndPassword(email, sifre).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Intent intent = new Intent(MainActivity.this, menu.class);
                    startActivity(intent);
                    finish();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
    public void register(View view){

        String email = mail.getText().toString();
        String sifre = password.getText().toString();
        if(email.matches("") || sifre.matches("")){
            Toast.makeText(MainActivity.this,"Please do not leave the email and password blank.",Toast.LENGTH_LONG).show();
        }else{
            reg.setVisibility(View.INVISIBLE);
            Toast.makeText(MainActivity.this,"Please wait",Toast.LENGTH_LONG).show();
            user.createUserWithEmailAndPassword(email,sifre).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {


                    Toast.makeText(MainActivity.this,"Your account has been created",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this,nickSet.class);
                    startActivity(intent);
                    finish();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                }
            });
        }


    }
}