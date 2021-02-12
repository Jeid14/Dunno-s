package com.company.database.ext;

import com.company.database.ConnectionNoSql;
import com.company.model.Person;
import com.company.utils.Constants;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;


public class Mongo extends ConnectionNoSql {

    MongoClient mongoClient;

    public MongoClient getConnection() {

       return new MongoClient(Constants.MONGO_HOST, Constants.MONGO_PORT);

    }

    public MongoCollection<Document> getTable(){
        return mongoClient.getDatabase(Constants.MONGO_DB_NAME).getCollection(Constants.MONGO_COLLECTION_NAME);
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

            person.setId(document.getInteger(Constants.ID));
            person.setFirstName(document.getString(Constants.FIRST_NAME));
            person.setLastName(document.getString(Constants.LAST_NAME));
            person.setCity(document.getString(Constants.CITY));
            person.setAge(document.getInteger(Constants.AGE));

            personList.add(person);
        }
        mongoClient.close();

        return personList;
    }

    @Override
    public void saveUpdateListNonSql(List<Person> personList) {
        mongoClient = getConnection();

        getTable().drop();
        mongoClient.getDatabase(Constants.MONGO_DB_NAME).createCollection(Constants.MONGO_COLLECTION_NAME);

        for (Person person : personList) {

            Document document = new Document();

            document.put(Constants.ID, person.getId());
            document.put(Constants.FIRST_NAME, person.getFirstName());
            document.put(Constants.LAST_NAME, person.getLastName());
            document.put(Constants.CITY, person.getCity());
            document.put(Constants.AGE, person.getAge());

            getTable().insertOne(document);
        }
        mongoClient.close();
    }
}


