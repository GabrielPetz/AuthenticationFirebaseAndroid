package com.example.gabriel.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gabriel.firebase.model.Usuario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class InsertActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_welcome);
        firebaseAuth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference(firebaseAuth.getUid().toString());

        nome = findViewById(R.id.nome);
        dtnascimento = findViewById(R.id.dtnascimento);
        idiomanativo = findViewById(R.id.idiomanativo);
        graduacao = (Spinner) findViewById(R.id.graduacao);

    }


    public void create(View v){

        Usuario user  = mapper();

        myRef.setValue(user);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Toast.makeText(InsertActivity.this, "Usuário Salvo", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(InsertActivity.this, "Ta fazendo merda em", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public Usuario mapper(){

        Usuario user = new Usuario(firebaseAuth.getCurrentUser());

        user.setNome(nome.getText().toString());
        user.setDtnascimento(dtnascimento.getText().toString());
        user.setIdiomanativo(idiomanativo.getText().toString());
        user.setGraduacao(graduacao.getSelectedItem().toString());

        return user;
    }

    public void back(View v){
        Intent intent = new Intent(InsertActivity.this, IndexActivity.class);
        startActivity(intent);
    }


}
