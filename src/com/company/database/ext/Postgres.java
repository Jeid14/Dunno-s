package com.company.database.ext;

import com.company.database.ConnectionToDataBase;
import com.company.model.Person;
import com.company.utils.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Postgres extends ConnectionToDataBase {


    @Override
    public Connection getConnection(String url,  String user,String password) {
        return super.getConnection(Constants.POSTGRES_URL, Constants.POSTGRES_USER, Constants.POSTGRES_PASSWORD);
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
