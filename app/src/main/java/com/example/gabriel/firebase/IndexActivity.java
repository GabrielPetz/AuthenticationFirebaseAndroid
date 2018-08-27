package com.example.gabriel.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class IndexActivity extends AppCompatActivity {

    private EditText nome;
    private EditText dtnascimento;
    private EditText idiomanativo;
    private Spinner graduacao;

    private FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        firebaseAuth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference(firebaseAuth.getUid().toString());

    }

    public void goInsert(View v){
        Intent intent = new Intent(IndexActivity.this, InsertActivity.class);
        startActivity(intent);
    }

    public void goSelect(View v){
        Intent intent = new Intent(IndexActivity.this, SelectActivity.class);
        startActivity(intent);
    }

}
