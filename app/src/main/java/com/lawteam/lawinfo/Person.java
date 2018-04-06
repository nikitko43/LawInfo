package com.lawteam.lawinfo;

/**
 * Created by nikitareutov on 06.04.2018.
 */

public class Person {
    private String name;
    private String urlPhoto;
    private String group;
    private String workingOn;

    Person(String _name, String _group, String _workingOn, String _urlPhoto){
        name = _name;
        group = _group;
        workingOn = _workingOn;
        urlPhoto = _urlPhoto;
    }

    String getName(){
        return name;
    }
    String getGroup(){
        return group;
    }
    String getWorkingOn(){
        return workingOn;
    }
    String getUrlPhoto(){
        return urlPhoto;
    }
}
