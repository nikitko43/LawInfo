package com.lawteam.lawinfo;

import java.io.Serializable;

public class Person implements Serializable {           //класс участника команды
    private String name;        //имя участника
    private String urlPhoto;    //указание на местоположение фото участника с помощью URL
    private String group;       //учебная группа МГТУ им. Н.Э. Баумана
    private String workingOn;   //должность при разработке данного проекта
    private String description; //информация о себе

    //конструктор с параметрами
    Person(String _name, String _group, String _workingOn, String _urlPhoto, String _description){
        name = _name;
        group = _group;
        workingOn = _workingOn;
        urlPhoto = _urlPhoto;
        description = _description;
    }

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

    //возврат URL-пути фото участника
    String getUrlPhoto(){
        return urlPhoto;
    }

    //возврат информации о себе
    String getDescription() {
        return description;
    }
}
