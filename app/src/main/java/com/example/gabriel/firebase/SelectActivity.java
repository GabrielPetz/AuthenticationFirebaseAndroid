package com.example.gabriel.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gabriel.firebase.model.Usuario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class SelectActivity extends AppCompatActivity {

    private TextView name;
    private TextView birthday;
    private TextView graduation;
    private TextView nativelanguage;
    private Usuario value;

    private FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        firebaseAuth = FirebaseAuth.getInstance();

        value = new Usuario();

        name = findViewById(R.id.name);
        birthday = findViewById(R.id.birthday);
        graduation = findViewById(R.id.graduation);
        nativelanguage = findViewById(R.id.nativelanguage);


        database = FirebaseDatabase.getInstance();
        myRef = database.getReference(firebaseAuth.getUid().toString());

        getData();

    }


    public void getData() {

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                name.setText(dataSnapshot.child("nome").getValue().toString());
                birthday.setText(dataSnapshot.child("dtnascimento").getValue().toString());
                graduation.setText(dataSnapshot.child("graduacao").getValue().toString());
                nativelanguage.setText(dataSnapshot.child("idiomanativo").getValue().toString());

                Toast.makeText(SelectActivity.this, "Dados recuperados", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(SelectActivity.this, "Deu ruim!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void back(View v) {
        Intent intent = new Intent(SelectActivity.this, IndexActivity.class);
        startActivity(intent);
    }

}
