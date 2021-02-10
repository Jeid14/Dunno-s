package com.company.database;


import com.company.model.Person;
import org.neo4j.driver.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphQl  extends ConnectionNoSql{
    public static String url = "bolt://localhost:7687";
    public static String user = "neo4j";
    public static String password = "1111";
    public static Driver driver;

    public Driver getDriver() {
        driver = GraphDatabase.driver(url,
                AuthTokens.basic(user, password));
        return driver;
    }
    public List<Person> getList() {
        List<Person> personList = new ArrayList<>();

        Person person;
        try (Session session = getDriver().session()) {

            Result result = session.run("MATCH (n) RETURN n.id, n.fname, n.lname, n.age, n.city");

            while (result.hasNext()) {
                Record record = result.next();
                person = new Person(
                        record.values().get(0).asInt(),
                        record.values().get(1).asString(),
                        record.values().get(2).asString(),
                        record.values().get(3).asNumber().byteValue(),
                        record.values().get(4).asString()
                );

                personList.add(person);
            }
        }
        driver.close();
        return personList;
    }

    public void saveUpdateListNonSql(List<Person> personList){
        try (Session session = getDriver().session()){
            int  id;
            Result result = session.run("MATCH (n) RETURN n.id, n.fname, n.lname, n.age, n.city");
            while (result.hasNext()) {
                Record record = result.next();
                id = record.values().get(0).asInt();
                Map<String, Object> params = new HashMap<>();
                params.put("id", id);
                session.run("MATCH (n { id: $id }) DETACH DELETE n", params);
            }
        }
        for(Person p : personList){
            try (Session session = getDriver().session()) {
                Map<String, Object> params = new HashMap<>();

                params.put("id", p.getId());
                params.put("fname", p.getFirstName());
                params.put("lname", p.getLastName());
                params.put("age", p.getAge());
                params.put("city", p.getCity());

                session.run("CREATE (n:persons {id: $id, fname: $fname, lname: $lname, age: $age, city: $city})", params);
            }

        }
        driver.close();
    }

    }
