package com.company;

import com.company.database.H2;
import com.company.database.Postgres;


import com.company.model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

//
//        InterfaceMain interfaceMain = new InterfaceMain();
//        interfaceMain.createGUI();
        Postgres postgres = new Postgres();
        List<Person> personList = postgres.getList(postgres.getConnection(Postgres.url, Postgres.password, Postgres.user));
        System.out.println(personList);
//        Person person = new Person(714, "AAA", "KK", 311, "Lff");
//        personList.add(person);
//        postgres.saveUpdateList(personList, postgres.getConnection(Postgres.url, Postgres.password, Postgres.user));
//        personList = postgres.getList(postgres.getConnection(Postgres.url, Postgres.password, Postgres.user));
//        System.out.println(personList);



//        H2 h2 = new H2();
//        List<Person> personList = h2.getList(h2.getConnection(H2.url,H2.password,H2.user));
//        System.out.println(personList);
//        Person person = new Person(714, "AAA", "KK", 311, "Lff");
//        personList.add(person);
//        h2.saveUpdateList(personList, h2.getConnection(Postgres.url, Postgres.password, Postgres.user));
//        List<Person> personList1 =  h2.getList(h2.getConnection(Postgres.url, Postgres.password, Postgres.user));
//
//        System.out.println(personList1);

    }
}

