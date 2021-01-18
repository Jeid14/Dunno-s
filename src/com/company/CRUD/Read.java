package com.company.CRUD;

import com.company.model.Person;

import java.util.List;

public class Read {

    public void read(List<Person> personList){
        for (Person p : personList) {
            System.out.println(p);
        }
}
}
