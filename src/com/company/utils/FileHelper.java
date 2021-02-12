package com.company.utils;

import com.company.Listeners.ButtonsListeners;
import com.company.Listeners.DataBaseListener;
import com.company.database.*;
import com.company.database.ext.*;
import com.company.executor.ExecutorFactory;
import com.company.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    List<Person> personList;


    public void saveToFile(String content, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
        writer.write(content);
        writer.close();

    }

    public String readFromFile(String fileName) {
        StringBuilder outputString = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                outputString.append(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputString.toString();
    }


    public String getFileExtension() {
        if (ButtonsListeners.path.lastIndexOf(".") != -1 && ButtonsListeners.path.lastIndexOf(".") != 0) {
            return ButtonsListeners.path.substring(ButtonsListeners.path.lastIndexOf(".") + 1);
        }
        else return " ";
    }

    public void saveChange(List<Person> personList) throws IOException {
        if (ButtonsListeners.path == null) {

            switch (DataBaseListener.DB) {
                case "Postgres":
                    ConnectionToDataBase postgres = new Postgres();
                    postgres.saveUpdateList(personList, postgres.getConnection(Constants.POSTGRES_URL, Constants.POSTGRES_USER, Constants.POSTGRES_PASSWORD));
                    break;
                case "H2":
                    ConnectionToDataBase connection = new H2();
                    connection.saveUpdateList(personList, connection.getConnection(Constants.H2_URL, Constants.H2_USER, Constants.H2_PASSWORD));
                    break;
                case "MySql":
                    ConnectionToDataBase mySql = new MySql();
                    mySql.saveUpdateList(personList, mySql.getConnection(Constants.MYSQL_URL, Constants.MYSQL_USER, Constants.MYSQL_PASSWORD));
                    break;
                case "Graph":
                    ConnectionNoSql graph = new GraphQl();
                    graph.saveUpdateListNonSql(personList);
                    break;
                case "Mongo":
                    ConnectionNoSql mongo = new Mongo();
                    mongo.saveUpdateListNonSql(personList);
                    break;
                case "Cassandra":
                    ConnectionNoSql cassandra = new Cassandra();
                    cassandra.saveUpdateListNonSql(personList);
                    break;
                case "Redis":
                    ConnectionNoSql redis = new Redis();
                    redis.saveUpdateListNonSql(personList);
                    break;
            }
        }

        else{
            new ExecutorFactory().getInstanceByFormat(getFileExtension()).write(ButtonsListeners.path, personList);
            System.out.println(Constants.CHANGED_SAVED);
        }
    }

    public void isEmpty() throws IOException {
        List<Person> personList;

        File yourFile = new File(ButtonsListeners.path);
        if (yourFile.length() == 0) {
            personList = new ArrayList<>();
            setList(personList);
        } else {
            setList(new ExecutorFactory().getInstanceByFormat(getFileExtension()).read(ButtonsListeners.path));
        }
    }

    public void setList(List<Person> newPersonList) {
        this.personList = newPersonList;
    }

    public List<Person> getPersonList() {
        return personList;
    }
}



