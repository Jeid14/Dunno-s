package com.company.visual;

import com.company.CRUD.Read;
import com.company.executor.ExecutorFactory;
import com.company.model.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.time.Period;
import java.util.*;
import java.util.List;


public class Table extends Component {
    List<Person>personList;


    public Table(List<Person>personList){
        this.personList =personList;


    }

    public JTable create() throws IOException {
        DefaultTableModel model = new DefaultTableModel() ;
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
       return table;
    }
    public Component updateTable(JTable table,List<Person>personList,DefaultTableModel model){
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
        return table;

    }

}
