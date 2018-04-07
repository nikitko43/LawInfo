package com.lawteam.lawinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//класс формы для изменения данных об участнике
public class EditActivity extends AppCompatActivity {

    private FirebaseAuth mAuth; //объект для аутентификации через базу данных пользователей

    EditText editName;
    EditText editGroup;
    EditText editWorkingOn;
    EditText editDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //вызывается при создании формы
        super.onCreate(savedInstanceState); //передача параметров для создания при вызове метода родительского класса
        setContentView(R.layout.activity_edit); //устанавливает содержимое Activity из layout-файла

        Person person = Team.team.get(getIntent().getIntExtra("Selected", 1));

        editName = findViewById(R.id.editName);
        editGroup = findViewById(R.id.editGroup);
        editWorkingOn = findViewById(R.id.editWorkingOn);
        editDescription = findViewById(R.id.editDescription);

        editName.setText(person.getName());
        editGroup.setText(person.getGroup());
        editWorkingOn.setText(person.getWorkingOn());
        editDescription.setText(person.getDescription());

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null){   //если не произошел вход, то переходим к форме входа
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void onClickSave(View v) {
        int id_selected = getIntent().getIntExtra("Selected", 1);
        System.out.println("------->" + id_selected);
        Person p = new Person(id_selected,
                editName.getText().toString(), editGroup.getText().toString(),
                editWorkingOn.getText().toString(), editDescription.getText().toString());

        Team.team.set(id_selected, p);
        setResult(RESULT_OK, new Intent());
        finish();
    }
}
