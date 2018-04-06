package com.lawteam.lawinfo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class TeamAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Person> team;

    TeamAdapter(Context context, ArrayList<Person> _team) {
        ctx = context;
        team = _team;
        lInflater = LayoutInflater.from(context);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return team.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return team.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        Person p = getPerson(position);

        // заполняем View в пункте списка данными
        // и картинка
        ((TextView) view.findViewById(R.id.textName)).setText(p.getName());
        ((TextView) view.findViewById(R.id.textGroup)).setText(p.getGroup());
        // ((ImageView) view.findViewById(R.id.photo)).setImageResource(p.image); <- фото

        return view;
    }

    Person getPerson(int position) {
        return ((Person) getItem(position));
    }

}


public class MainActivity extends AppCompatActivity {

    ArrayList<Person> team = new ArrayList<Person>();
    TeamAdapter teamAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView lv = findViewById(R.id.mainListView);
        team.add(new Person("Никита", "ИУ5", "фвфы", "dsf"));
        team.add(new Person("Максим", "ИУ5", "фвфы", "dsf"));
        team.add(new Person("Марк", "ИУ5", "фвфы", "dsf"));
        team.add(new Person("Роман", "ИУ5", "фвфы", "dsf"));

        teamAdapter = new TeamAdapter(this, team);

        lv.setAdapter(teamAdapter);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
