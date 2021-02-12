package com.company.database.ext;

import com.company.database.ConnectionToDataBase;
import com.company.model.Person;
import com.company.utils.Constants;

import java.sql.*;
import java.util.List;

public class H2 extends ConnectionToDataBase {

    public  Connection connection ;

    public Connection getConnection(String url, String user, String password) {
        try {
            connection = DriverManager.getConnection(url,user,password);
            return connection;
        } catch (SQLException throwables) {
            System.out.println(Constants.DATA_PROBLEM);
            throwables.printStackTrace();
        }
        return connection;

    }

    public void saveUpdateList(List<Person> personList, Connection connection) {
        connection = getConnection(Constants.H2_URL, Constants.H2_USER, Constants.H2_PASSWORD);

        try {
            PreparedStatement statement = connection.prepareStatement(Constants.H2_DROP);
            try {
                int set = statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        } catch (SQLException throwables) {
            System.out.println(Constants.INCORRECT_QUERY);
        }
        try {

            PreparedStatement statement = connection.prepareStatement(Constants.H2_CREATE);
            try {
                int set = statement.executeUpdate();
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

                PreparedStatement statement = connection.prepareStatement(String.format(Constants.H2_INSERT, id, fn, ln, ci, age));
                try {
                    int resultSet = statement.executeUpdate();
                } catch (SQLException e) {

                }
            }
        } catch (SQLException throwables) {
            System.out.println(Constants.INCORRECT_QUERY);
            throwables.printStackTrace();
        }
    }

    @Override
    public List getList(Connection connection) {
        return super.getList(connection);
    }
}
