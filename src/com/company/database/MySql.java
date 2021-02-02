package com.company.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MySql extends ConnectionToDataBase {
    @Override
    public Connection getConnection(String url, String password, String userName)  {
        return super.getConnection(url, password, userName);
    }


}
