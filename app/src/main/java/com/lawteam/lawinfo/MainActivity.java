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

//класс воспроизведения списка участников
class TeamAdapter extends BaseAdapter {
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
        View view = convertView;    //основа компонента интерфейса
        if (view == null) {
            //формирование View-элемента
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        Person p = getPerson(position);

        // заполняем View в пункте списка текстовыми данными и изображениями
        ((TextView) view.findViewById(R.id.textName)).setText(p.getName());
        ((TextView) view.findViewById(R.id.textWorkingOn)).setText(p.getWorkingOn());
        switch (p.getId()) {
            case 0:
                ((ImageView) view.findViewById(R.id.photo)).setImageResource(R.mipmap.nikita);
                break;
            case 1:
                ((ImageView) view.findViewById(R.id.photo)).setImageResource(R.mipmap.maksim);
                break;
            case 2:
                ((ImageView) view.findViewById(R.id.photo)).setImageResource(R.mipmap.mark);
                break;
            case 3:
                ((ImageView) view.findViewById(R.id.photo)).setImageResource(R.mipmap.roman);
                break;
        }

        return view;
    }

    //возврат участника по его позиции в списке
    private Person getPerson(int position) {
        return ((Person) getItem(position));
    }
}

//класс основной формы, обеспечивающей взаимодействие пользователя с приложением
public class MainActivity extends AppCompatActivity {

    TeamAdapter teamAdapter;                       //объект, необходимый для вопроизведения всех элементов интерфейса на экране

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        teamAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //считывание данных об участниках из базы данных
        Team t = new Team();

        teamAdapter = new TeamAdapter(getApplicationContext(), Team.team);   //создание адаптера

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
                intent.putExtra("Selected", i);
                startActivityForResult(intent, 112);
            }
        });
    }
}
