package com.company.database;

import com.company.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public abstract class ConnectionToDataBase {


    public Connection getConnection(String url, String password, String userName){
        Connection connection;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(url, userName, password);
            return connection;
        } catch (SQLException throwables) {
            System.out.println("DATA problem");
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(1);
            e.printStackTrace();
        }
        return null;

    }


    public void saveUpdateList(List<Person> personList, Connection connection) {

        try {
            PreparedStatement statement = connection.prepareStatement("DROP TABLE personList");
            try {
                ResultSet set = statement.executeQuery();
            } catch (SQLException e) {

            }
        } catch (SQLException throwables) {
            System.out.println("Incorect query!");
        }
        try {

            PreparedStatement statement = connection.prepareStatement("CREATE TABLE personList( id INTEGER UNIQUE, FirstName VARCHAR NOT NULL, LastName VARCHAR NOT NULL, City VARCHAR NOT NULL, age INTEGER);");
            try {
                ResultSet set = statement.executeQuery();
            } catch (SQLException e) {
                System.out.println(4);

            }
        } catch (SQLException throwables) {
            System.out.println("Incorect query!");
        }
        try {
            for (Person person : personList) {
                int id = person.getId();
                String fn = person.getFirstName();
                String ln = person.getLastName();
                String ci = person.getCity();
                int age = person.getAge();
                PreparedStatement statement = connection.prepareStatement(String.format("INSERT INTO personList(id,FirstName,LastName,City,age) VALUES (%s,'%s','%s','%s',%s);", id, fn, ln, ci, age));
                try {
                    ResultSet resultSet = statement.executeQuery();
                } catch (SQLException e) {
                    System.out.println(5);
                }
            }
        } catch (SQLException throwables) {
            System.out.println("Not Corect SQL query");
            throwables.printStackTrace();
        }

    }

    public List getList(Connection connection) {
        List<Person> personList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT*FROM personList")) {
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Person person = new Person(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(5), resultSet.getString(4));
                personList.add(person);
            }
        } catch (SQLException throwables) {
            personList.add(new Person(0, " ", " ", 0, " "));
            throwables.printStackTrace();
        }
        ;
        return personList;
    }

}
