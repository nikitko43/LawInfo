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
                    "Капитан", "Красавчик"));

            team.add(new Person(1,"Кондратьев Максим", "ИУ5-43",
                    "Проектирование, тестирование и отладка", "Гениальный лентяй"));

            team.add(new Person(2,"Чеснавский Марк", "ИУ5-43",
                    "Программирование, базы данных", "Водитель шкоды"));

            team.add(new Person(3,"Векшин Роман", "ИУ6-42",
                    "Программирование, дизайн", "Просто хороший парень"));
        }
    }
}
