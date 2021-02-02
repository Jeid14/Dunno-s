package com.company.database;

import com.company.model.Person;

import java.sql.*;


public abstract class ConnectionToDataBase {

    public Connection getConnection(String url,String password,String userName) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,userName,password);
        } catch (SQLException throwables) {
            System.out.println("DATABASE NOT FOUND!");
            throwables.printStackTrace();
        }
        return connection;

    }

}
