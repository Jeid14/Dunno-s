package com.company.visual;



import com.company.Listeners.TableListener;

import com.company.model.Person;
import com.company.utils.ConstantString;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseListener;
import java.io.IOException;


import java.util.List;



public class Table {


    static JScrollPane scrollPane;
    private ControlPanel controlPanel;

    public Table(ControlPanel controlPanel){

        this.controlPanel = controlPanel;
    }


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

        MouseListener mouseListener = new TableListener(table, controlPanel);
        table.addMouseListener(mouseListener);

     return panelTable;

    }




}
