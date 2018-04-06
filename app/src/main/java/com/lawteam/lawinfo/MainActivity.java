package com.lawteam.lawinfo;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

class TeamAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Person> team;

    public TeamAdapter(Context context, ArrayList<Person> _team) {
        ctx = context;
        team = _team;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        Person p = getPerson(position);

        // заполняем View в пункте списка данными
        // и картинка
        ((TextView) view.findViewById(R.id.textName)).setText(p.getName());
        ((TextView) view.findViewById(R.id.textWorkingOn)).setText(p.getWorkingOn());
        ((ImageView) view.findViewById(R.id.photo)).setImageResource(R.mipmap.lexech);

        return view;
    }

    private Person getPerson(int position) {
        return ((Person) getItem(position));
    }

}


public class MainActivity extends AppCompatActivity {

    ArrayList<Person> team = new ArrayList<Person>();
    TeamAdapter teamAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        team.add(new Person("Никита", "ИУ5", "фвфы", "dsf", "asdas"));
        team.add(new Person("Максим", "ИУ5", "фвфы", "dsf", "asda"));
        team.add(new Person("Марк", "ИУ5", "фвфы", "dsf", "asdas"));
        team.add(new Person("Роман", "ИУ5", "фвфы", "dsf", "dss"));

        teamAdapter = new TeamAdapter(getApplicationContext(), team);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.mainListView);
        lv.setAdapter(teamAdapter);
    }
}
