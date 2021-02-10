package com.company.database;

import com.company.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySql extends ConnectionToDataBase {
    public static String url = "jdbc:mysql://localhost:3306/persons";
    public static String user = "root";
    public static String password = "1111";
    @Override
    public Connection getConnection(String url,String user,String password)  {
        return super.getConnection(url,user,password);
    }

    @Override
    public void saveUpdateList(List<Person> personList, Connection connection) {

        try {
            PreparedStatement statement = connection.prepareStatement("DROP TABLE personList");
            try {
                int set = statement.executeUpdate();
            } catch (SQLException e) {

            }
        } catch (SQLException throwables) {
            System.out.println("Incorect query!");
        }
        try {

            PreparedStatement statement = connection.prepareStatement("CREATE TABLE `persons`.`personlist` (\n" +
                    "  `id` INT NOT NULL,\n" +
                    "  `FirstName` VARCHAR(45) NULL,\n" +
                    "  `LastName` VARCHAR(45) NULL,\n" +
                    "  `City` VARCHAR(45) NULL,\n" +
                    "  `Age` INT NULL);");
            try {
                int set = statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println(66);


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
                    int resultSet = statement.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(5);

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
