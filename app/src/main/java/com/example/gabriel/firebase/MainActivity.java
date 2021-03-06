package com.example.gabriel.firebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText password;
    private EditText email;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        password = findViewById(R.id.password);
        email = findViewById(R.id.email);

        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void login(View v) {

        String sLogin = email.getText().toString();
        String sPassword = password.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(sLogin, sPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Logado com sucesso", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, IndexActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Erro ao logar", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void goregister(View v) {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
    public void gowelcome(View v){
        Intent intent = new Intent(MainActivity.this, InsertActivity.class);
        startActivity(intent);

    }

}
