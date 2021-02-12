package com.company.Listeners;

import com.company.database.*;
import com.company.database.ext.*;
import com.company.utils.Constants;
import com.company.utils.FileHelper;
import com.company.visual.Table;
import com.company.visual.TextFields;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;

public class DataBaseListener implements ActionListener {
    private final JFrame frame;
    private final TextFields textFields;
    public static String DB ;
    private   ConnectionToDataBase connection;


    public DataBaseListener(JFrame frame, TextFields textFields, FileHelper fileHelper) {
        this.frame = frame;
        this.textFields = textFields;
        this.fileHelper = fileHelper;
    }

    private FileHelper fileHelper;
    private static Table table;


    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox box = (JComboBox) e.getSource();
        String item = (String) box.getSelectedItem();
        ButtonsListeners.path = null;
        switch (item) {
            case "SQL-PostgresSQL":
                DB = "Postgres";
                frame.setTitle(DB);
                ConnectionToDataBase postgres = new Postgres();
                createTableFromDataBase(postgres.getConnection(Constants.POSTGRES_URL,Constants.POSTGRES_USER,Constants.POSTGRES_PASSWORD),  postgres);
                break;
            case "SQL-H2":
                DB = "H2";
                connection = new H2();
                frame.setTitle(DB);
                createTableFromDataBase(connection.getConnection(Constants.H2_URL, Constants.H2_USER, Constants.H2_PASSWORD),  connection);
                break;
            case "SQL-MySQL":
                DB = "MySql";
                frame.setTitle(DB);
                connection = new MySql();
                createTableFromDataBase(connection.getConnection(Constants.MYSQL_URL,Constants.MYSQL_USER, Constants.MYSQL_PASSWORD),connection );
                break;

            case "NonSQL - Graph":
                DB = "Graph";
                frame.setTitle(DB);
                ConnectionNoSql graphQl = new GraphQl();
                createTableFromNonSql(graphQl);
                break;
            case "NonSQL - Mongo":
                DB = "Mongo";
                frame.setTitle(DB);
                ConnectionNoSql mongo = new Mongo();
                createTableFromNonSql(mongo);

                break;
            case "NonSQL - Cassandra":
                DB = "Cassandra";
                frame.setTitle(DB);
                ConnectionNoSql cassandra = new Cassandra();
                createTableFromNonSql(cassandra);
                break;
            case "NonSQL - Redis":
                DB = "Redis";
                frame.setTitle(DB);
                ConnectionNoSql redis  = new Redis();
                createTableFromNonSql(redis);
                break;
        }
    }

    private void createTableFromDataBase(Connection connection, ConnectionToDataBase connectionToDataBase) {
        try {
            if (ButtonsListeners.countOpen == 0) {
                table = new Table(frame, textFields, fileHelper);
                ButtonsListeners.setTable(table);
                fileHelper.setList(connectionToDataBase.getList(connection));
                table.createTable(fileHelper.getPersonList());
                ButtonsListeners.countOpen++;
            } else if (ButtonsListeners.countOpen > 0) {
                ButtonsListeners.path = null;
                table = ButtonsListeners.getTable();

                fileHelper.setList(connectionToDataBase.getList(connection));
                table.redrawTable();
            }
            textFields.getTextFildId().setText("");
            textFields.getTextFieldAge().setText("");
            textFields.getTextFieldCity().setText("");
            textFields.getTextFieldFirstName().setText("");
            textFields.getTextFieldLastName().setText("");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
    private void createTableFromNonSql(ConnectionNoSql connectionNoSql) {
        try {
            if (ButtonsListeners.countOpen == 0) {
                table = new Table(frame, textFields, fileHelper);
                ButtonsListeners.setTable(table);
                fileHelper.setList(connectionNoSql.getList());
                table.createTable(fileHelper.getPersonList());
                ButtonsListeners.countOpen++;
            } else if (ButtonsListeners.countOpen > 0) {
                ButtonsListeners.path = null;
                table = ButtonsListeners.getTable();
                System.out.println(ButtonsListeners.countOpen);
                fileHelper.setList(connectionNoSql.getList());
                table.redrawTable();
            }
            textFields.getTextFildId().setText("");
            textFields.getTextFieldAge().setText("");
            textFields.getTextFieldCity().setText("");
            textFields.getTextFieldFirstName().setText("");
            textFields.getTextFieldLastName().setText("");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

}
