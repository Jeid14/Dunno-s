package com.company.visual;


import com.company.Listeners.ButtonsListeners;
import com.company.Listeners.TableListener;
import com.company.model.Person;
import com.company.utils.Constants;
import com.company.utils.FileHelper;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseListener;
import java.io.IOException;

import java.util.List;


public class Table {
    private final FileHelper fileHelper;
    private final JFrame frame;
    JScrollPane scrollPane;

    TextFields textFields;

    public Table(JFrame frame, TextFields textFields, FileHelper fileHelper) {
        this.frame = frame;
        this.textFields = textFields;
        this.fileHelper = fileHelper;

    }

    public void createTable(List<Person> personList) throws IOException {


        DefaultTableModel model = new DefaultTableModel();

        model.addColumn(Constants.ID);
        model.addColumn(Constants.FIRST_NAME);
        model.addColumn(Constants.LAST_NAME);
        model.addColumn(Constants.CITY);
        model.addColumn(Constants.AGE);


        for (Person p : personList) {
            model.addRow(new String[]{String.valueOf(p.getId()), p.getFirstName(), p.getLastName(), p.getCity(), String.valueOf(p.getAge())});
        }
        JTable jtable = new JTable(model);
        jtable.setFillsViewportHeight(true);
        jtable.getTableHeader().setReorderingAllowed(false);

        jtable.getColumnModel().getColumn(0).setPreferredWidth(0);
        jtable.getColumnModel().getColumn(1).setPreferredWidth(15);
        jtable.getColumnModel().getColumn(3).setPreferredWidth(10);

        jtable.getColumnModel().getColumn(4).setPreferredWidth(0);



        MouseListener listener = new TableListener(jtable, textFields);
        jtable.addMouseListener(listener);

        scrollPane = createScrollPane(jtable);
        scrollPane.setBackground(Color.lightGray);

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
        this.scrollPane.setBounds(10, 50, 470, 300);
        return scrollPane;
    }
}



