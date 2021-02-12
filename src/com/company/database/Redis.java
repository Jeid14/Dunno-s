package com.company.database;

import com.company.model.Person;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

public class Redis extends ConnectionNoSql{

    Person person;
    Jedis jedis;


    public Jedis getConnecting() {
        return new Jedis("localhost", 6379);
    }

    @Override
    public List<Person> getList() {
        jedis = getConnecting();
        List<Person> personList = new ArrayList<>();
        for (int count = 0; jedis.lindex("person", count) != null; count++) {
            String redis = jedis.lindex("person", count);
            String[] arrayRedis = redis.split("\u00D8");
            person = new Person(
                    Integer.parseInt(arrayRedis[0]),
                    arrayRedis[1],
                    arrayRedis[2],
                    Integer.parseInt(arrayRedis[3]),
                    arrayRedis[4]);


            personList.add(person);
        }
        jedis.close();
        return personList;

    }

    @Override
    public void saveUpdateListNonSql(List<Person> personList) {
        jedis = getConnecting();
        int length = Math.toIntExact(jedis.llen("person"));
        for (int count = 0; count<=length; count++) {
            jedis.lpop("person");
        }
        for (Person person:personList) {
            jedis.lpush(
                    "person",
                    person.getId() + "\u00D8"
                            + person.getFirstName() + "\u00D8"
                            + person.getLastName() + "\u00D8"
                            + person.getAge() + "\u00D8"
                            + person.getCity()
            );
        }
        jedis.close();
    }
}
