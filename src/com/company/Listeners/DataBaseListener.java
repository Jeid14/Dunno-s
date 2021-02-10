package com.company.Listeners;

import com.company.database.*;
import com.company.utils.FileHelper;
import com.company.visual.Table;
import com.company.visual.TextFilds;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;

public class DataBaseListener implements ActionListener {
    private final JFrame frame;
    private final TextFilds textFilds;
    public static String DB ;
    public static ConnectionToDataBase connection;


    public DataBaseListener(JFrame frame, TextFilds textFilds, FileHelper fileHelper) {
        this.frame = frame;
        this.textFilds = textFilds;
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
                DB ="Postgres";
                frame.setTitle(DB);
                ConnectionToDataBase postgres = new Postgres();
                createTableFromDataBase(postgres.getConnection(Postgres.url, Postgres.user, Postgres.password), Postgres.url, Postgres.password, Postgres.user, postgres);
                break;
            case "SQL-H2":
                DB ="H2";
                connection = new H2();
                frame.setTitle(DB);
                createTableFromDataBase(connection.getConnection(H2.url, H2.user, H2.password), H2.url, H2.user, H2.password, connection);
                break;
            case "SQL-MySQL":
                DB = "MySql";
                connection = new MySql();
                createTableFromDataBase(connection.getConnection(MySql.url,MySql.user,MySql.password),MySql.url,MySql.user,MySql.password,connection );
                break;

            case "NonSQL - Graph":
                DB = "Graph";
                ConnectionNoSql graphQl = new GraphQl();
                createTableFromNonSql(graphQl);
                break;
        }

    }

    private void createTableFromDataBase(Connection connection, String url, String user, String password, ConnectionToDataBase connectionToDataBase) {
        try {
            if (ButtonsListeners.countOpen == 0) {
                table = new Table(frame, textFilds, fileHelper);
                ButtonsListeners.setTable(table);
                fileHelper.seList(connectionToDataBase.getList(connection));
                table.createTable(fileHelper.getPersonList());
                ButtonsListeners.countOpen++;
            } else if (ButtonsListeners.countOpen > 0) {
                ButtonsListeners.path = null;
                table = ButtonsListeners.getTable();
                System.out.println(ButtonsListeners.countOpen);
                fileHelper.seList(connectionToDataBase.getList(connection));
                table.redrawTable();
            }
            textFilds.getTextFildId().setText("");
            textFilds.getTextFieldAge().setText("");
            textFilds.getTextFieldCity().setText("");
            textFilds.getTextFieldFirstName().setText("");
            textFilds.getTextFieldLastName().setText("");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
    private void createTableFromNonSql(ConnectionNoSql connectionNoSql) {
        try {
            if (ButtonsListeners.countOpen == 0) {
                table = new Table(frame, textFilds, fileHelper);
                ButtonsListeners.setTable(table);
                fileHelper.seList(connectionNoSql.getList());
                table.createTable(fileHelper.getPersonList());
                ButtonsListeners.countOpen++;
            } else if (ButtonsListeners.countOpen > 0) {
                ButtonsListeners.path = null;
                table = ButtonsListeners.getTable();
                System.out.println(ButtonsListeners.countOpen);
                fileHelper.seList(connectionNoSql.getList());
                table.redrawTable();
            }
            textFilds.getTextFildId().setText("");
            textFilds.getTextFieldAge().setText("");
            textFilds.getTextFieldCity().setText("");
            textFilds.getTextFieldFirstName().setText("");
            textFilds.getTextFieldLastName().setText("");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

}
