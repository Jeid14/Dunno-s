package com.company.database;

import com.company.model.Person;
import com.company.utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public abstract class ConnectionToDataBase {


    public Connection getConnection(String url, String user, String password){
        Connection connection;
        try {
            Class.forName(Constants.H2_DRIVER);
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException throwables) {
            System.out.println(Constants.DATA_PROBLEM);
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        return null;

    }


    public void saveUpdateList(List<Person> personList, Connection connection) {

        try {
            PreparedStatement statement = connection.prepareStatement(Constants.MYSQL_DROP);
            try {
                ResultSet set = statement.executeQuery();
            } catch (SQLException e) {

            }
        } catch (SQLException throwables) {
            System.out.println(Constants.INCORRECT_QUERY);
        }
        try {

            PreparedStatement statement = connection.prepareStatement(Constants.MYSQL_CREATE_T_PL);
            try {
                ResultSet set = statement.executeQuery();
            } catch (SQLException e) {


            }
        } catch (SQLException throwables) {
            System.out.println(Constants.INCORRECT_QUERY);
        }
        try {
            for (Person person : personList) {
                int id = person.getId();
                String fn = person.getFirstName();
                String ln = person.getLastName();
                String ci = person.getCity();
                int age = person.getAge();
                PreparedStatement statement = connection.prepareStatement(String.format(Constants.MYSQL_INSERT, id, fn, ln, ci, age));
                try {
                    ResultSet resultSet = statement.executeQuery();
                } catch (SQLException e) {

                }
            }
        } catch (SQLException throwables) {
            System.out.println(Constants.INCORRECT_QUERY);
            throwables.printStackTrace();
        }

    }

    public List getList(Connection connection) {
        List<Person> personList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Constants.MYSQL_READ)) {
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
