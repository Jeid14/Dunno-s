package com.company.database.ext;

import com.company.database.ConnectionNoSql;
import com.company.model.Person;
import com.company.utils.Constants;
import com.datastax.driver.core.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Cassandra extends ConnectionNoSql {

    private Session session;
    private Cluster cluster;

    public Session getConnection() {
        cluster = Cluster.builder().addContactPoint(Constants.CASSANDRA_HOST).build();
        session = cluster.connect(Constants.CASSANDRA_KEYSPACE);
        return session;
    }

    @Override
    public List<Person> getList() {

        List<Person> personList = new ArrayList<>();

        Person person;

        ResultSet resultset = getConnection().execute(Constants.CASSANDRA_READ);

        for (Row row : resultset) {

            int id = (row.getInt(Constants.ID));
            String firstName = row.getString(Constants.FIRST_NAME);
            String lastName = row.getString(Constants.LAST_NAME);
            String city = row.getString(Constants.CITY);
            int age = row.getInt(Constants.AGE);

            person = new Person(id, firstName, lastName, age, city);

            personList.add(person);
        }

        cluster.close();
        return personList;
    }


    @Override
    public void saveUpdateListNonSql(List<Person> personList) {

        getConnection().execute(Constants.CASSANDRA_DROP_TABLE);
        getConnection().execute(Constants.CASSANDRA_CREATE_TABLE);

        for (Person person : personList) {
            Map<String, Object> params = new HashMap<>();

            params.put(Constants.ID, person.getId());
            params.put(Constants.FIRST_NAME, person.getFirstName());
            params.put(Constants.LAST_NAME, person.getLastName());
            params.put(Constants.CITY, person.getCity());
            params.put(Constants.AGE, person.getAge());

            getConnection().execute(Constants.CASSANDRA_INSERT, params);
        }
        cluster.close();
    }

}
