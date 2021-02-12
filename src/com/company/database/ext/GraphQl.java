package com.company.database.ext;

import com.company.database.ConnectionNoSql;
import com.company.model.Person;
import com.company.utils.Constants;
import org.neo4j.driver.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphQl  extends ConnectionNoSql {
    public static Driver driver;

    public Driver getDriver() {
        driver = GraphDatabase.driver(Constants.GRAPHQL_URL, AuthTokens.basic(Constants.GRAPHQL_USER, Constants.GRAPHQL_PASSWORD));
        return driver;
    }
    public List<Person> getList() {
        List<Person> personList = new ArrayList<>();

        Person person;
        try (Session session = getDriver().session()) {

            Result result = session.run(Constants.GRAPHQL_READ);

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
            Result result = session.run(Constants.GRAPHQL_READ);
            while (result.hasNext()) {
                Record record = result.next();
                id = record.values().get(0).asInt();
                Map<String, Object> params = new HashMap<>();
                params.put(Constants.ID, id);
                session.run(Constants.GRAPHQL_DELETE, params);
            }
        }
        for(Person p : personList){
            try (Session session = getDriver().session()) {
                Map<String, Object> params = new HashMap<>();

                params.put(Constants.ID, p.getId());
                params.put("fname", p.getFirstName());
                params.put("lname", p.getLastName());
                params.put(Constants.AGE, p.getAge());
                params.put(Constants.CITY, p.getCity());

                session.run(Constants.GRAPHQL_CREATE, params);
            }

        }
        driver.close();
    }

}
