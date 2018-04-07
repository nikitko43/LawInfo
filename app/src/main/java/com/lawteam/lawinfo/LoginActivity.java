package com.lawteam.lawinfo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //вызывается при создании формы
        super.onCreate(savedInstanceState); //передача параметров для создания при вызове метода родительского класса
        setContentView(R.layout.activity_login);    //устанавливает содержимое Activity из layout-файла

        mAuth = FirebaseAuth.getInstance(); //получение экземпляра класса FirebaseAuth, для работы с разграничение доступа
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    public void onClickLogIn(View v) {  //вызывает при нажатии на кнопку входа
        //считывание данных из полей для ввода
        EditText etEmail = findViewById(R.id.editTextEmail);
        EditText etPassword = findViewById(R.id.editTextPassword);
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        //вход под именем определенного пользователя
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {  //вход при верном логине и пароле
                            finish();
                        } else {    //вывод сообщение о некорректности введенных данных
                            Toast.makeText(LoginActivity.this, "Неверный логин/пароль",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
