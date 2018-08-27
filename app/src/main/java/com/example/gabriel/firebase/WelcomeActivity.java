package com.example.gabriel.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class WelcomeActivity extends AppCompatActivity {

    private EditText password;
    private EditText email;
    private FirebaseAuth firebaseAuth;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        text = findViewById(R.id.text);
        text.setText("Bem Vindo!");
        firebaseAuth = FirebaseAuth.getInstance();
    }

}
