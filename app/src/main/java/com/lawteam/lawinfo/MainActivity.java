package com.lawteam.lawinfo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class TeamAdapter extends BaseAdapter { //класс воспроизведения списка участников
    Context ctx;    //объект, предоставляющий доступ к базовым функциям приложения, ресурсам, файловой системе
    LayoutInflater lInflater; //объект, необходимый для формирования View-элемента из содержимого layout-файла
    ArrayList<Person> team; //список участников

    //конструктор с параметрами
    public TeamAdapter(Context context, ArrayList<Person> _team) {
        ctx = context;
        team = _team;
        //получение доступа для формирования View-элементы
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //возврат кол-ва элементов
    @Override
    public int getCount() {
        return team.size();
    }

    //возврат элемента по позиции
    @Override
    public Object getItem(int position) {
        return team.get(position);
    }

    //возврат id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    //возврат пункта списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;    //основа компоненета интерфейса
        if (view == null) {
            //формирование View-элемента
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        Person p = getPerson(position);

        // заполняем View в пункте списка текстовыми данными и изображениями
        ((TextView) view.findViewById(R.id.textName)).setText(p.getName());
        ((TextView) view.findViewById(R.id.textWorkingOn)).setText(p.getWorkingOn());
        ((ImageView) view.findViewById(R.id.photo)).setImageResource(R.mipmap.lexech);

        return view;
    }

    //возврат участника по его позиции в списке
    private Person getPerson(int position) {
        return ((Person) getItem(position));
    }
}

//класс основной формы, обеспечивающей взаимодействие пользователя с приложением
public class MainActivity extends AppCompatActivity {

    ArrayList<Person> team = new ArrayList<Person>();   //список участников
    TeamAdapter teamAdapter;                       //объект, необходимый для вопроизведения всех элементов интерфейса на экране

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //считывание данных об участниках из базы данных
        team.add(new Person("Реутов Никита", "ИУ5", "Капитан, красавчик", "dsf", "asdas"));
        team.add(new Person("Кондратьев Максим", "ИУ5", "Чисто нихуя", "dsf", "asda"));
        team.add(new Person("Чеснавский Марк", "ИУ5", "Программирование", "dsf", "asdas"));
        team.add(new Person("Векшин Роман", "ИУ6", "Что-то еще, хз", "dsf", "dss"));

        teamAdapter = new TeamAdapter(getApplicationContext(), team);   //создание адаптера

        super.onCreate(savedInstanceState); //передача параметров для создания при вызове метода родительского класса
        setContentView(R.layout.activity_main); //генерирование формы на основе layout-файлаы

        ListView lv = findViewById(R.id.mainListView);  //поиск View-элемента по id
        lv.setAdapter(teamAdapter); //установка адаптера

        //предоставление ListView интерфейса для обратного вызова, вызываемого при нажатии элемента в этом адаптере
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //создание объекта, описывающего операцию открытия новой формы
                Intent intent = new Intent(MainActivity.this, DescriptionActivity.class);
                intent.putExtra("Selected", team.get(i));
                startActivityForResult(intent, 114);
            }
        });
    }
}
