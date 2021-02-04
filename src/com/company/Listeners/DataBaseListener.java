package com.company.Listeners;

import com.company.database.ConnectionToDataBase;
import com.company.database.H2;
import com.company.database.Postgres;
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
   public static String DB = "null";


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
            case "SQL-PostgresSql":
                DB = "postgres";
                ConnectionToDataBase postgres = new Postgres();
                createTableFromDataBase(postgres.getConnection(Postgres.url,Postgres.password,Postgres.user),Postgres.url,Postgres.password,Postgres.user,postgres );
                break;
            case "SQL-H2":
                DB = "H2";
                H2 h2 = new H2();
                createTableFromDataBase(h2.getConnection(H2.url,H2.user,H2.password),H2.url,H2.user,H2.password,h2);
                break;

            case "NonSQL":

                break;
        }

    }
    private void createTableFromDataBase(Connection connection, String url, String user, String password,ConnectionToDataBase connectionToDataBase){
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

}
