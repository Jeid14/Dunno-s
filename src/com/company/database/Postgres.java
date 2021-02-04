package com.company.database;

import com.company.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Postgres extends ConnectionToDataBase {
    public static String url = "jdbc:postgresql://localhost:5432/persons";
    public static String user = "postgres";
    public static String password = "1111";

    @Override
    public Connection getConnection(String url, String password, String user) {
        return super.getConnection(url, password, user);
    }

    @Override
    public void saveUpdateList(List<Person> personList, Connection connection) {
        super.saveUpdateList(personList, connection);
    }

    @Override
    public List getList(Connection connection) {
        return super.getList(connection);
    }
}
