package com.company.database.ext;

import com.company.database.ConnectionToDataBase;
import com.company.model.Person;
import com.company.utils.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MySql extends ConnectionToDataBase {

    @Override
    public Connection getConnection(String url,String user,String password)  {
        return super.getConnection(url,user,password);
    }

    @Override
    public void saveUpdateList(List<Person> personList, Connection connection) {

        try {
            PreparedStatement statement = connection.prepareStatement(Constants.MYSQL_DROP);
            try {
                int set = statement.executeUpdate();
            } catch (SQLException e) {

            }
        } catch (SQLException throwables) {
            System.out.println(Constants.INCORRECT_QUERY);
        }
        try {

            PreparedStatement statement = connection.prepareStatement( Constants.MYSQL_CREATE_T_P);
            try {
                int set = statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println(66);

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
                    int resultSet = statement.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(5);

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
