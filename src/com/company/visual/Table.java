package com.company.visual;

import com.company.CRUD.Read;
import com.company.executor.ExecutorFactory;
import com.company.model.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.time.Period;
import java.util.*;


public class Table {

    public void create(List<Person>personList) throws IOException {
//        List<Person> personArrayList =new ExecutorFactory().getInstanceByFormat("json").read("1.json");;
       // personArrayList.add(new Person(11,"33","44",55,"ii"));
        int count =0;
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn("ID");
        model.addColumn("FirstName");
        model.addColumn("LastName");
        model.addColumn("City");
        model.addColumn("Age");
        for(Person p:personList) {
            model.addRow(new String[]{String.valueOf(p.getId()),p.getFirstName(),p.getLastName(),p.getCity(),String.valueOf(p.getAge())});
        }
        Vector data = model.getDataVector();
        Vector row = (Vector) data.elementAt(0);
        // Copy the first column
        int mColIndex = 0;
        List colData = new ArrayList(table.getRowCount());
        for (int i = 0; i < table.getRowCount(); i++) {
            row = (Vector) data.elementAt(i);
            colData.add(row.get(mColIndex));
        }
        JFrame f = new JFrame();
        f.setSize(600, 300);
        f.add(new JScrollPane(table));
        f.setVisible(true);
    }
}