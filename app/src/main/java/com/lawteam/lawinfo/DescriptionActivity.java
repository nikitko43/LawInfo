package com.lawteam.lawinfo;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

//класс формы с информацией об определённом участнике
public class DescriptionActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {   //вызывается при выборе элемента из Action bar
        switch (item.getItemId()) { //выбор действия в соответствии с конкретным элементом меню
            case android.R.id.home: //выход из приложения
                finish();
                return true;
            case R.id.first:    //открытие форма изменения
                Intent intent = new Intent(this, EditActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //вызывается при создании опционального меню
        getMenuInflater().inflate(R.menu.context_menu, menu); //формирование View-элемента из layout-файла меню
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //вызывается при создании формы
        super.onCreate(savedInstanceState); //передача параметров для создания при вызове метода родительского класса
        setContentView(R.layout.activity_description); //устанавливает содержимое Activity из layout-файла

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //формирование кнопки возврата

        Intent intent = getIntent();
        //получение объекта участника из объекта, описывающего операцию открытия формы
        Person selected = (Person) intent.getSerializableExtra("Selected");

        //копирование данных об участнике
        TextView tvName = findViewById(R.id.DescrName);
        TextView tvGroup = findViewById(R.id.DescrGroup);
        TextView tvWorkingOn = findViewById(R.id.DescrWorkingOn);
        TextView tvDescription = findViewById(R.id.DescrDescription);

        //вывод данных об участнике
        tvName.setText(selected.getName());
        tvGroup.setText("Группа: " + selected.getGroup());
        tvWorkingOn.setText(selected.getWorkingOn());
        tvDescription.setText(selected.getDescription());
    }
}
