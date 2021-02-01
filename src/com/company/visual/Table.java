package com.company.visual;


import com.company.Listeners.TableListener;
import com.company.executor.ExecutorFactory;
import com.company.model.Person;
import com.company.utils.ConstantString;
import com.company.CRUD.Read;
import com.company.executor.ExecutorFactory;
import com.company.model.Person;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseListener;
import java.io.IOException;

import java.util.*;
import java.util.List;

import java.time.Period;
import java.util.*;



public class Table {

    static JScrollPane scrollPane;
    MouseListener mouseListener;
    ControlPanel controlPanel = new ControlPanel();


    public JPanel createTable(List<Person> personList) throws IOException {

        JPanel panelTable = new JPanel();
        panelTable.setLayout(new BoxLayout(panelTable, BoxLayout.Y_AXIS));
        panelTable.setBounds(10, 70, 680, 360);
        panelTable.setOpaque(false);

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn(ConstantString.ENTER_ID);
        model.addColumn(ConstantString.ENTER_FIRST_NAME);
        model.addColumn(ConstantString.ENTER_LAST_NAME);
        model.addColumn(ConstantString.ENTER_CITY);
        model.addColumn(ConstantString.ENTER_AGE);

        for (Person p : personList) {
            model.addRow(new String[]{String.valueOf(p.getId()), p.getFirstName(), p.getLastName(), p.getCity(), String.valueOf(p.getAge())});
        }

        table.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(table,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, 680, 360);
        panelTable.add(scrollPane);

        mouseListener = new TableListener(table, controlPanel.getPanelControl());
        table.addMouseListener(mouseListener);

        return panelTable;
    }

}
