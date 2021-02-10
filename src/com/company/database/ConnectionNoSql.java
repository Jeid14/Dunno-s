package com.company.database;

import com.company.model.Person;

import java.util.List;

public  abstract class ConnectionNoSql {

    public abstract List<Person> getList();
    public abstract void saveUpdateListNonSql(List<Person> personList);
}
