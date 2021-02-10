package com.company.database;

import com.company.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2 extends ConnectionToDataBase{
    public static String url = "jdbc:h2:tcp://localhost/~/test";
    public static String user = "H2";
    public static String password = "1111";
    public  Connection connection ;

    public Connection getConnection(String url, String user, String password) {
        try {
            connection = DriverManager.getConnection(url,user,password);
            return connection;
        } catch (SQLException throwables) {
            System.out.println("DATA problem");
            throwables.printStackTrace();

        }
        return connection;

    }

    public void saveUpdateList(List<Person> personList, Connection connection) {
        connection = getConnection(url,user,password);

        try {
            PreparedStatement statement = connection.prepareStatement("DROP TABLE PERSONLIST");
            try {
                int set = statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        } catch (SQLException throwables) {
            System.out.println("Incorect query!");
        }
        try {

            PreparedStatement statement = connection.prepareStatement("CREATE TABLE PERSONLIST( id INTEGER UNIQUE, FirstName VARCHAR NOT NULL, LastName VARCHAR NOT NULL, City VARCHAR NOT NULL, age INTEGER)");
            try {
                int set = statement.executeUpdate();
            } catch (SQLException e) {


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

                PreparedStatement statement = connection.prepareStatement(String.format("INSERT INTO PERSONLIST VALUES (%s,'%s','%s','%s',%s)", id, fn, ln, ci, age));
                try {
                    int resultSet = statement.executeUpdate();
                } catch (SQLException e) {

                }
            }
        } catch (SQLException throwables) {
            System.out.println("Not Corect SQL query");
            throwables.printStackTrace();
        }
    }

    @Override
    public List getList(Connection connection) {
        return super.getList(connection);
    }
}
