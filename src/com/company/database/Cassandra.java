package com.company.database;

import com.company.model.Person;
import com.datastax.driver.core.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Cassandra extends ConnectionNoSql{

    private Session session;
    private Cluster cluster;


    public Session getConnection() {
        cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        session = cluster.connect("persons");
        return session;
    }

    @Override
    public List<Person> getList() {

        List<Person> personList = new ArrayList<>();

        Person person;

        ResultSet resultset = getConnection().execute("SELECT * FROM person");

        for (Row row : resultset) {

            int id = (row.getInt("id"));
            String first_name = row.getString("firstName");
            String last_name = row.getString("lastName");
            String city = row.getString("city");
            int age = row.getInt("age");

            person = new Person(id, first_name, last_name, (byte) age, city);

            personList.add(person);
        }

        cluster.close();
        return personList;
    }


    @Override
    public void saveUpdateListNonSql(List<Person> personList) {

        getConnection().execute("DROP TABLE person");
        getConnection().execute("CREATE TABLE person(id int PRIMARY KEY, firstName text, lastName text, city text, age int);");

        for (Person person : personList) {
            Map<String, Object> params = new HashMap<>();

            params.put("id", person.getId());
            params.put("firstname", person.getFirstName());
            params.put("lastname", person.getLastName());
            params.put("city", person.getCity());
            params.put("age", person.getAge());

            ResultSet execute = getConnection().execute("INSERT INTO person (id,firstname,lastname,city,age) VALUES (?,?,?,?,?);", params);
        }
        cluster.close();
    }


}
