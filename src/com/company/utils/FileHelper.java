package com.company.utils;

import com.company.Listeners.ButtonsListeners;
import com.company.Listeners.DataBaseListener;
import com.company.database.ConnectionToDataBase;
import com.company.database.H2;
import com.company.database.Postgres;
import com.company.executor.ExecutorFactory;
import com.company.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    //   final String path = ButtonsListeners.path;
    List<Person> personList;
    String DB = DataBaseListener.DB;


    public void saveToFile(String content, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
        writer.write(content);
        writer.close();

    }

    public String readFromFile(String fileName) throws IOException {
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

//    public List<Person> getPersonList() throws IOException {
//        return new ExecutorFactory().getInstanceByFormat(getFileExtension()).read(ButtonsListeners.path);
//    }

    public String getFileExtension() {
        // если в имени файла есть точка и она не является первым символом в названии файла
        if (ButtonsListeners.path.lastIndexOf(".") != -1 && ButtonsListeners.path.lastIndexOf(".") != 0) {
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
//            fileEx = path.substring(path.lastIndexOf(".") + 1);
            return ButtonsListeners.path.substring(ButtonsListeners.path.lastIndexOf(".") + 1);
        }            // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return " ";
    }

    public void saveChange(List<Person> personList) throws IOException {
        if (ButtonsListeners.path == null) {

            if (DB.equals("postgres")) {
                ConnectionToDataBase postgres = new Postgres();
                postgres.saveUpdateList(personList, postgres.getConnection(Postgres.url,Postgres.password,Postgres.user));
            }
            if(DB.equals("H2")){
               ConnectionToDataBase h2 = new H2();
                h2.saveUpdateList(personList,h2.getConnection(H2.url,H2.password,H2.user));
            }
        } else {
            new ExecutorFactory().getInstanceByFormat(getFileExtension()).write(ButtonsListeners.path, personList);
            System.out.println("Changed saved!");
        }
    }

    public void isEmpty() throws IOException {
        List<Person> personList;

        File yourFile = new File(ButtonsListeners.path);
        if (yourFile.length() == 0) {
            personList = new ArrayList<>();
            seList(personList);

        } else {
            seList(new ExecutorFactory().getInstanceByFormat(getFileExtension()).read(ButtonsListeners.path));
        }
    }

    public void seList(List<Person> newPersonList) {
        this.personList = newPersonList;
    }

    public List<Person> getPersonList() {
        return personList;
    }
}



