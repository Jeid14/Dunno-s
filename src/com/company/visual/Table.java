package com.company.visual;

import com.company.executor.ExecutorFactory;
import com.company.model.Person;
import com.company.utils.ConstantString;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.*;
import java.util.List;


public class Table {

    public JPanel createTable() throws IOException {

        List<Person> personList = new ExecutorFactory().getInstanceByFormat("json").read("1.json");

        JPanel panelTable = new JPanel();
        panelTable.setLayout(new BoxLayout(panelTable,BoxLayout.Y_AXIS));
        panelTable.setBounds(10,70,680,360);
        panelTable.setOpaque(false);

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn(ConstantString.ENTER_ID);
        model.addColumn(ConstantString.ENTER_FIRST_NAME);
        model.addColumn(ConstantString.ENTER_LAST_NAME);
        model.addColumn(ConstantString.ENTER_CITY);
        model.addColumn(ConstantString.ENTER_AGE);
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

        panelTable.add(table);

        JScrollPane scrollPane = new JScrollPane(table,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 100, 400, 200);

        panelTable.add(scrollPane);

        return panelTable;
    }
}
