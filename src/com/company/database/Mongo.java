package com.company.database;

import com.company.model.Person;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;


public class Mongo extends ConnectionNoSql{

    MongoClient mongoClient;

    public MongoClient getConnection() {

       return new MongoClient( "localhost" , 27017 );

    }

    public MongoCollection<Document> getTable(){
        return mongoClient.getDatabase("persons").getCollection("person");
    }

    @Override
    public List<Person> getList() {
        mongoClient = getConnection();
        MongoCursor<Document> documentFindIterable = getTable().find().iterator();

        List<Person> personList = new ArrayList<>();

        Person person;
        while (documentFindIterable.hasNext()) {
            person = new Person();

            Document document = documentFindIterable.next();

            person.setId(document.getInteger("id"));
            person.setFirstName(document.getString("firstName"));
            person.setLastName(document.getString("lastName"));
            person.setCity(document.getString("city"));
            person.setAge(document.getInteger("age"));

            personList.add(person);
        }
        mongoClient.close();

        return personList;
    }

    @Override
    public void saveUpdateListNonSql(List<Person> personList) {
        mongoClient = getConnection();

        getTable().drop();
        mongoClient.getDatabase("persons").createCollection("person");

        for (Person person : personList) {

            Document document = new Document();

            document.put("id", person.getId());
            document.put("firstName", person.getFirstName());
            document.put("lastName", person.getLastName());
            document.put("city", person.getCity());
            document.put("age", person.getAge());

            getTable().insertOne(document);
        }
        mongoClient.close();
    }
}


