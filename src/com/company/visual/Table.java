package com.company.visual;


import com.company.Listeners.ButtonsListeners;
import com.company.Listeners.TableListener;
import com.company.model.Person;
import com.company.utils.ConstantString;
import com.company.utils.FileHelper;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseListener;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;


public class Table {
    private final FileHelper fileHelper;
    private final JFrame frame;
    JScrollPane scrollPane;

    TextFilds textFilds;

    public Table(JFrame frame, TextFilds textFilds, FileHelper fileHelper) {
        this.frame = frame;
        this.textFilds = textFilds;
        this.fileHelper = fileHelper;

    }

    public void createTable(List<Person> personList) throws IOException {


        DefaultTableModel model = new DefaultTableModel();

        model.addColumn(ConstantString.ENTER_ID);
        model.addColumn(ConstantString.ENTER_FIRST_NAME);
        model.addColumn(ConstantString.ENTER_LAST_NAME);
        model.addColumn(ConstantString.ENTER_CITY);
        model.addColumn(ConstantString.ENTER_AGE);

        for (Person p : personList) {
            model.addRow(new String[]{String.valueOf(p.getId()), p.getFirstName(), p.getLastName(), p.getCity(), String.valueOf(p.getAge())});
        }
        JTable jtable = new JTable(model);
        jtable.setFillsViewportHeight(true);

        jtable.getColumnModel().getColumn(0).setPreferredWidth(2);
        jtable.getColumnModel().getColumn(4).setPreferredWidth(2);
        jtable.getColumnModel().getColumn(3).setPreferredWidth(15);


        MouseListener listener = new TableListener(jtable, textFilds);
        jtable.addMouseListener(listener);

        scrollPane = createScrollPane(jtable);
        frame.add(scrollPane);

    }


    public void redrawTable() throws IOException {
        frame.remove(this.scrollPane);
        if (ButtonsListeners.path != null) {
            fileHelper.isEmpty();
        }
        createTable(fileHelper.getPersonList());


    }

    public JScrollPane createScrollPane(JTable defaultTable) {
        scrollPane = new JScrollPane(defaultTable,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.scrollPane.setBounds(30, 35, 450, 300);
        return scrollPane;
    }
}



