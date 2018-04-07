package com.lawteam.lawinfo;

import java.io.Serializable;

public class Person implements Serializable {           //класс участника команды
    private int id;
    private String name;        //имя участника
    private String group;       //учебная группа МГТУ им. Н.Э. Баумана
    private String workingOn;   //должность при разработке данного проекта
    private String description; //информация о себе

    //конструктор с параметрами
    Person(int _id, String _name, String _group, String _workingOn, String _description){
        id = _id;
        name = _name;
        group = _group;
        workingOn = _workingOn;
        description = _description;
    }

    int getId() { return id; }
    //возврат имени участника
    String getName(){
        return name;
    }

    //возврат учебной группы участника
    String getGroup(){
        return group;
    }

    //возврат должности участника
    String getWorkingOn(){
        return workingOn;
    }

    //возврат информации о себе
    String getDescription() {
        return description;
    }
}
