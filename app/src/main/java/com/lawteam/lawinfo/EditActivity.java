package com.lawteam.lawinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//класс формы для изменения данных об участнике
public class EditActivity extends AppCompatActivity {

    private FirebaseAuth mAuth; //объект для аутентификации через базу данных пользователей

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //вызывается при создании формы
        super.onCreate(savedInstanceState); //передача параметров для создания при вызове метода родительского класса
        setContentView(R.layout.activity_edit); //устанавливает содержимое Activity из layout-файла

        mAuth = FirebaseAuth.getInstance(); //получение экземпляра класса FirebaseAuth, для работы с разграничение доступа
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null){   //если не произошел вход, то переходим к форме входа
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }


    }
}
