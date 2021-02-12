package com.company.database.ext;

import com.company.database.ConnectionNoSql;
import com.company.model.Person;
import com.company.utils.Constants;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

public class Redis extends ConnectionNoSql {

    private Person person;
    private Jedis jedis;

    public Jedis getConnecting() {
        return new Jedis(Constants.REDIS_HOST, Constants.REDIS_PORT);
    }

    @Override
    public List<Person> getList() {
        jedis = getConnecting();
        List<Person> personList = new ArrayList<>();
        for (int count = 0; jedis.lindex(Constants.REDIS_KEY, count) != null; count++) {
            String redis = jedis.lindex(Constants.REDIS_KEY, count);
            String[] arrayRedis = redis.split(Constants.SEPARATOR);
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
        int length = Math.toIntExact(jedis.llen(Constants.REDIS_KEY));
        for (int count = 0; count <= length; count++) {
            jedis.lpop(Constants.REDIS_KEY);
        }
        for (Person person : personList) {
            jedis.lpush(
                    Constants.REDIS_KEY,
                    person.getId() + Constants.SEPARATOR
                            + person.getFirstName() + Constants.SEPARATOR
                            + person.getLastName() + Constants.SEPARATOR
                            + person.getAge() + Constants.SEPARATOR
                            + person.getCity()
            );
        }
        jedis.close();
    }
}
