package com.lawteam.lawinfo;

import java.util.ArrayList;

/**
 * Created by nikitareutov on 07.04.2018.
 */

public class Team {
    public static ArrayList<Person> team = new ArrayList<Person>(){

    };  //список участников
    Team(){
        if (team.size() == 0) {
            team.add(new Person(0,"Реутов Никита", "ИУ5-43",
                    "Капитан, красавчик", "dsf", "asdas"));

            team.add(new Person(1,"Кондратьев Максим", "ИУ5-43",
                    "Чисто нихуя", "dsf", "asda"));

            team.add(new Person(2,"Чеснавский Марк", "ИУ5-43",
                    "Программирование", "dsf", "asdas"));

            team.add(new Person(3,"Векшин Роман", "ИУ6",
                    "Что-то еще, хз", "dsf", "dss"));
        }
    }
}
